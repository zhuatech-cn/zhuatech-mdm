# 数据库设计

- `sys_user`：主数据治理员、计划专员和数据管理员账号。
- `mdm_supplier`：供应商档案、等级、交付率、质量率与合作状态。
- `mdm_material`：物料编码、类别、单位、安全库存与当前库存。
- `mdm_demand_plan`：需求来源、需求数量、需求日期和计划状态。
- `mdm_purchase_order`：采购供应商、物料、数量、价格、交期与到货进度。
- `mdm_supply_alert`：库存、交付与数据质量风险。

初始化脚本位于 `backend/src/main/resources/db/migration/V1__init.sql`，表名、索引及外键均通过 Flyway 管理。
