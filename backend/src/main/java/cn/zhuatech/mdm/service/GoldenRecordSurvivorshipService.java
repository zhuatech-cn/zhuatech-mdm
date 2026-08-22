/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.mdm.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class GoldenRecordSurvivorshipService {
    public Result select(Request request) {
        List<ScoredCandidate> ranked = request.candidates().stream()
            .map(candidate -> new ScoredCandidate(candidate.sourceSystem(), score(candidate),
                candidate.criticalConflicts()))
            .sorted(Comparator.comparingInt(ScoredCandidate::score).reversed())
            .toList();
        ScoredCandidate winner = ranked.getFirst();
        int scoreGap = ranked.size() == 1 ? winner.score()
            : winner.score() - ranked.get(1).score();
        boolean severeConflict = request.candidates().stream()
            .anyMatch(candidate -> candidate.criticalConflicts() >= 2);
        String decision = severeConflict ? "BLOCK_MERGE"
            : winner.criticalConflicts() == 0 && winner.score() >= 80 && scoreGap >= 10
                ? "AUTO_MERGE" : "STEWARD_REVIEW";
        List<String> actions = "AUTO_MERGE".equals(decision)
            ? List.of("按优胜来源生成黄金记录并保留字段级血缘")
            : severeConflict
                ? List.of("冻结合并并由数据管理员解决关键字段冲突")
                : List.of("展示候选记录差异并提交数据管理员确认");
        return new Result(request.entityKey(), winner.sourceSystem(), winner.score(),
            scoreGap, decision, ranked, actions);
    }

    private int score(Candidate candidate) {
        int value = Math.round(candidate.completenessScore() * .5F);
        if (candidate.verified()) value += 20;
        if (candidate.stewardApproved()) value += 20;
        value -= Math.min(15, candidate.freshnessDays() / 10);
        value -= candidate.criticalConflicts() * 15;
        return Math.max(0, Math.min(100, value));
    }

    public record Request(@NotBlank String entityKey,
                          @NotEmpty List<@Valid Candidate> candidates) {}

    public record Candidate(@NotBlank String sourceSystem,
                            @Min(0) @Max(100) int completenessScore,
                            boolean verified, @Min(0) int freshnessDays,
                            boolean stewardApproved, @Min(0) int criticalConflicts) {}

    public record ScoredCandidate(String sourceSystem, int score, int criticalConflicts) {}

    public record Result(String entityKey, String winningSource, int winningScore,
                         int scoreGap, String decision, List<ScoredCandidate> ranking,
                         List<String> actions) {}
}
