# API 摘要

| 方法 | 路径 | 说明 |
| --- | --- | --- |
| POST | `/api/auth/login` | 用户登录并签发 JWT |
| GET | `/api/mdm/dashboard` | 主数据驾驶舱指标 |
| GET/POST | `/api/mdm/demands` | 查询或新建数据标准 |
| GET/POST | `/api/mdm/orders` | 查询或新建变更申请 |
| POST | `/api/mdm/orders/{id}/approve` | 审核变更申请 |
| POST | `/api/mdm/orders/{id}/receive` | 登记采购到货 |
| GET | `/api/mdm/suppliers` | 供应商及绩效列表 |
| GET | `/api/mdm/materials` | 物料库存列表 |
| GET | `/api/mdm/alerts` | 主数据风险列表 |
| POST | `/api/mdm/alerts/{id}/close` | 关闭风险预警 |

除登录接口外均需 `Authorization: Bearer <token>`。演示接口仅用于个人非商业学习。

## 重复记录匹配

`POST /api/mdm/duplicate-match`：返回主数据匹配分、合并决策和证据列表。
