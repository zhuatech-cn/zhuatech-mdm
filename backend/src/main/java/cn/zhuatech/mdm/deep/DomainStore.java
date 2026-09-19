/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.mdm.deep;import jakarta.persistence.*;import java.time.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="deep_mdm_domain",uniqueConstraints=@UniqueConstraint(columnNames="domain_code")) class MasterDomain{@Id@GeneratedValue(strategy=GenerationType.IDENTITY)Long id;@Column(name="domain_code")String domainCode;String name;String keyField;int matchThreshold;String status="DRAFT";@Version long lockVersion;/**
                                                                                                                                                                                                                                                                                                                                  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                  */
protected MasterDomain(){}/**
                                                                                                                                                                                                                                                                                                                                                            * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                            */
MasterDomain(String c,String n,String k,int t){domainCode=c;name=n;keyField=k;matchThreshold=t;}}
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="deep_mdm_record",uniqueConstraints=@UniqueConstraint(columnNames="record_no")) class MasterRecord{@Id@GeneratedValue(strategy=GenerationType.IDENTITY)Long id;Long domainId;@Column(name="record_no")String recordNo;String sourceSystem;String businessKey;String name;String normalizedName;String identityNo;String status="DRAFT";Long goldenId;LocalDateTime createdAt=LocalDateTime.now();@Version long lockVersion;/**
                                                                                                                                                                                                                                                                                                                                                                                                                                                * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                                                                                */
protected MasterRecord(){}/**
                                                                                                                                                                                                                                                                                                                                                                                                                                                                          * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                                                                                                          */
MasterRecord(Long d,String r,String s,String b,String n,String i){domainId=d;recordNo=r;sourceSystem=s;businessKey=b;name=n;normalizedName=n.replaceAll("\\s+","").toUpperCase();identityNo=i;}}
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="deep_mdm_match",uniqueConstraints=@UniqueConstraint(columnNames={"record_id","candidate_id"})) class MatchCandidate{@Id@GeneratedValue(strategy=GenerationType.IDENTITY)Long id;Long recordId;Long candidateId;int score;String status="OPEN";/**
                                                                                                                                                                                                                                                                    * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                    */
protected MatchCandidate(){}/**
                                                                                                                                                                                                                                                                                                * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                */
MatchCandidate(Long r,Long c,int s){recordId=r;candidateId=c;score=s;}}
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="deep_mdm_change",uniqueConstraints=@UniqueConstraint(columnNames="change_no")) class MasterChangeRequest{@Id@GeneratedValue(strategy=GenerationType.IDENTITY)Long id;@Column(name="change_no")String changeNo;Long goldenRecordId;String fieldName;String oldValue;String newValue;String reason;String status="PENDING";@Version long lockVersion;/**
                                                                                                                                                                                                                                                                                                                                                                         * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                         */
protected MasterChangeRequest(){}/**
                                                                                                                                                                                                                                                                                                                                                                                                          * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                                          */
MasterChangeRequest(String n,Long g,String f,String o,String v,String r){changeNo=n;goldenRecordId=g;fieldName=f;oldValue=o;newValue=v;reason=r;}}
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="deep_mdm_outbox",uniqueConstraints=@UniqueConstraint(columnNames="event_no")) class DistributionOutbox{@Id@GeneratedValue(strategy=GenerationType.IDENTITY)Long id;@Column(name="event_no")String eventNo;Long recordId;String targetSystem;String status="PENDING";int retries;LocalDateTime createdAt=LocalDateTime.now();LocalDateTime sentAt;/**
                                                                                                                                                                                                                                                                                                                                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                       */
protected DistributionOutbox(){}/**
                                                                                                                                                                                                                                                                                                                                                                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                                       */
DistributionOutbox(String n,Long r,String t){eventNo=n;recordId=r;targetSystem=t;}}
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="deep_mdm_audit") class MasterAudit{@Id@GeneratedValue(strategy=GenerationType.IDENTITY)Long id;String action;String aggregateNo;String detail;LocalDateTime createdAt=LocalDateTime.now();/**
                                                                                                                                                                                                                * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                */
protected MasterAudit(){}/**
                                                                                                                                                                                                                                         * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                         */
MasterAudit(String a,String n,String d){action=a;aggregateNo=n;detail=d;}}
