/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.mdm.service;
import jakarta.validation.constraints.*;import org.springframework.stereotype.Service;import java.util.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service
public class GoldenRecordPublishGovernanceService{
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public Assessment assess(Request r){List<String>b=new ArrayList<>();List<String>a=new ArrayList<>();
  if(r.qualityScore()<r.requiredQualityScore())b.add("主数据质量分低于发布阈值");if(!r.duplicatesResolved())b.add("重复候选尚未完成合并或排除");
  if(r.criticalConflicts()>0)b.add("关键字段仍存在来源冲突");if(!r.lineageComplete())b.add("字段级来源血缘不完整");
  if(!r.privacyClassified())b.add("隐私与敏感等级未标注");if(!r.stewardApproved())a.add("取得数据管理员批准");
  if(!r.downstreamImpactReviewed())a.add("评估下游系统映射和变更影响");if(!r.outboxReady())a.add("准备可靠分发事件与幂等键");
  Decision d=!b.isEmpty()?Decision.HOLD:!a.isEmpty()?Decision.REVIEW:Decision.PUBLISH;
  return new Assessment(r.recordId(),r.qualityScore(),d,List.copyOf(b),List.copyOf(a));}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record Request(@NotBlank String recordId,@Min(0)@Max(100)int qualityScore,@Min(0)@Max(100)int requiredQualityScore,
  boolean duplicatesResolved,@Min(0)int criticalConflicts,boolean lineageComplete,boolean privacyClassified,
  boolean stewardApproved,boolean downstreamImpactReviewed,boolean outboxReady){}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record Assessment(String recordId,int qualityScore,Decision decision,List<String> blockers,List<String> actions){}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public enum Decision{PUBLISH,REVIEW,HOLD}
}
