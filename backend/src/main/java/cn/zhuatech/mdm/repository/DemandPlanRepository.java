/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.mdm.repository;import cn.zhuatech.mdm.model.DemandPlan;import org.springframework.data.jpa.repository.JpaRepository;import java.util.List;public interface DemandPlanRepository extends JpaRepository<DemandPlan,Long>{List<DemandPlan> findAllByOrderByRequiredDateAsc();long countByStatus(String status);}
