/* Copyright 2026 上海如静知华信息科技有限公司 */
export const stats=[['待审变更','12','物料 7 · 客户 3 · 供应商 2','blue'],['主数据总量','28.6万','今日新增 186 条','green'],['质量预警','3','其中 1 项阻断下游','red'],['规则通过率','97.6%','较上周提升 1.3%','amber']]
export const demands=[
 {no:'CR-20260731-036',material:'工业控制芯片 X48',code:'MAT-IC-1048',source:'ERP / 物料主数据',qty:'6 个属性变更',stock:'92%',gap:'-2 项',date:'08-01',status:'待数据审核',risk:'高'},
 {no:'CR-20260731-041',material:'6061 铝型材 40×40',code:'MAT-AL-3026',source:'PLM / 设计物料',qty:'3 个属性变更',stock:'100%',gap:'0 项',date:'08-02',status:'业务审核中',risk:'中'},
 {no:'CR-20260731-045',material:'伺服电机 750W',code:'MAT-MT-2071',source:'SRM / 供应目录',qty:'新增替代料关系',stock:'100%',gap:'0 项',date:'08-03',status:'已发布',risk:'低'},
 {no:'CR-20260731-052',material:'工业连接器 M12',code:'MAT-CN-4082',source:'MES / 生产反馈',qty:'计量单位修订',stock:'78%',gap:'-4 项',date:'今天',status:'待数据审核',risk:'高'},
 {no:'CR-20260731-058',material:'低压断路器 32A',code:'MAT-EL-5019',source:'WMS / 库存校验',qty:'仓储属性补充',stock:'98%',gap:'0 项',date:'08-05',status:'已发布',risk:'低'}]
export const orders=[
 {no:'MC-202607-0186',supplier:'物料主数据域',material:'工业控制芯片 X48',qty:'18,642 条',received:'17,906',amount:'完整率 96.1%',expected:'08-01',days:'剩余 1 天',status:'治理中',progress:96,owner:'沈雨欣'},
 {no:'SC-202607-0179',supplier:'供应商主数据域',material:'供应商银行与税务信息',qty:'2,680 条',received:'2,612',amount:'完整率 97.5%',expected:'08-03',days:'剩余 3 天',status:'规则校验',progress:82,owner:'赵明远'},
 {no:'CC-202607-0162',supplier:'客户主数据域',material:'客户归属与信用属性',qty:'8,420 条',received:'7,915',amount:'完整率 94.0%',expected:'07-31',days:'今日到期',status:'存在阻断',progress:71,owner:'沈雨欣'},
 {no:'OC-202607-0158',supplier:'组织主数据域',material:'组织、岗位与成本中心',qty:'1,260 条',received:'1,260',amount:'完整率 100%',expected:'07-30',days:'已完成',status:'已发布',progress:100,owner:'赵明远'}]
export const suppliers=[
 {code:'RULE-0018',name:'物料编码唯一性规则',category:'物料主数据',grade:'A',otd:'99.8%',quality:'99.32%',orders:12,amount:'覆盖 18.6万条',status:'启用中'},
 {code:'RULE-0026',name:'供应商证照有效期规则',category:'供应商主数据',grade:'A',otd:'98.6%',quality:'98.71%',orders:8,amount:'覆盖 2,680条',status:'启用中'},
 {code:'RULE-0041',name:'客户信用属性完整性规则',category:'客户主数据',grade:'B',otd:'94.0%',quality:'97.90%',orders:6,amount:'覆盖 8,420条',status:'观察中'},
 {code:'RULE-0057',name:'组织成本中心映射规则',category:'组织主数据',grade:'A',otd:'100%',quality:'99.08%',orders:9,amount:'覆盖 1,260条',status:'启用中'}]
export const alerts=[
 {level:'紧急',type:'质量预警',title:'客户信用等级存在 42 条空值',detail:'已阻断 CRM 客户同步任务，需在今日 16:00 前补齐。',owner:'沈雨欣',time:'10:26'},
 {level:'预警',type:'一致性风险',title:'物料基本单位与 WMS 不一致',detail:'发现 18 条箱/件换算关系冲突，建议发起批量修正。',owner:'物料数据组',time:'09:48'},
 {level:'提醒',type:'时效预警',title:'3 项变更申请即将超过 SLA',detail:'供应商银行信息变更等待财务复核已超过 20 小时。',owner:'数据治理组',time:'08:35'}]
export const flow=[['数据接入','12 个系统','今日同步 286 万条'],['标准化','186 条','12 项待审核'],['质量校验','97.6%','3 项阻断规则'],['合并去重','1,248 条','疑似重复 26 条'],['发布分发','99.2%','下游 8 个系统']]
