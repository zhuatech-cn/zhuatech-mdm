/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.mdm.service;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service
public class DuplicateMatchService {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Result compare(Request request) {
        int score = Math.max(0, Math.min(100, (int) Math.round((request.codeSimilarity() * .25
            + request.nameSimilarity() * .35 + request.addressSimilarity() * .20) * 100
            + (request.sameTaxId() ? 20 : 0) - request.conflictingFields() * 5)));
        String decision = score >= 85 && request.conflictingFields() <= 1 ? "MERGE"
            : score >= 60 ? "REVIEW" : "KEEP_SEPARATE";
        List<String> evidence = new ArrayList<>();
        if (request.sameTaxId()) evidence.add("统一社会信用代码一致");
        if (request.nameSimilarity() >= .9) evidence.add("名称高度相似");
        if (request.addressSimilarity() >= .8) evidence.add("地址信息高度相似");
        if (request.conflictingFields() > 0) evidence.add("存在字段冲突，需要保留审计记录");
        return new Result(request.leftRecordId(), request.rightRecordId(), score, decision, evidence);
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Request(@NotBlank String leftRecordId, @NotBlank String rightRecordId,
                          @DecimalMin("0") @DecimalMax("1") double codeSimilarity,
                          @DecimalMin("0") @DecimalMax("1") double nameSimilarity,
                          @DecimalMin("0") @DecimalMax("1") double addressSimilarity,
                          boolean sameTaxId, @Min(0) int conflictingFields) {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Result(String leftRecordId, String rightRecordId, int matchScore,
                         String decision, List<String> evidence) {}
}
