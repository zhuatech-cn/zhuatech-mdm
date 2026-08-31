# 企业级黄金记录发布治理

发布前检查质量阈值、重复消解、关键冲突、字段血缘、隐私分类、数据管理员审批、下游影响和可靠分发准备。

`POST /api/enterprise/mdm/golden-record-publish` 返回 `PUBLISH / REVIEW / HOLD`，避免低质量主数据扩散到业务系统。
