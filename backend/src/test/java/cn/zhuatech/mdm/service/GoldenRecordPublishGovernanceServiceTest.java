/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.mdm.service;
import org.junit.jupiter.api.Test;import static org.assertj.core.api.Assertions.assertThat;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class GoldenRecordPublishGovernanceServiceTest{private final GoldenRecordPublishGovernanceService service=new GoldenRecordPublishGovernanceService();
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @Test void publishesGovernedGoldenRecord(){var r=service.assess(new GoldenRecordPublishGovernanceService.Request("MDM-001",96,90,true,0,true,true,true,true,true));assertThat(r.decision()).isEqualTo(GoldenRecordPublishGovernanceService.Decision.PUBLISH);}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @Test void holdsLowQualityConflictedRecord(){var r=service.assess(new GoldenRecordPublishGovernanceService.Request("MDM-002",60,90,false,3,false,false,false,false,false));assertThat(r.decision()).isEqualTo(GoldenRecordPublishGovernanceService.Decision.HOLD);assertThat(r.blockers()).hasSize(5);assertThat(r.actions()).hasSize(3);}}
