/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.mdm;

import cn.zhuatech.mdm.service.GoldenRecordSurvivorshipService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GoldenRecordSurvivorshipServiceTests {
    private final GoldenRecordSurvivorshipService service = new GoldenRecordSurvivorshipService();

    @Test
    void autoMergesClearlySuperiorVerifiedSource() {
        var result = service.select(new GoldenRecordSurvivorshipService.Request("CUSTOMER-1001", List.of(
            new GoldenRecordSurvivorshipService.Candidate("CRM", 95, true, 2, true, 0),
            new GoldenRecordSurvivorshipService.Candidate("ERP", 70, true, 40, false, 0))));

        assertEquals("CRM", result.winningSource());
        assertEquals("AUTO_MERGE", result.decision());
    }

    @Test
    void blocksMergeWithCriticalConflicts() {
        var result = service.select(new GoldenRecordSurvivorshipService.Request("SUPPLIER-2001", List.of(
            new GoldenRecordSurvivorshipService.Candidate("SRM", 90, true, 1, true, 2),
            new GoldenRecordSurvivorshipService.Candidate("ERP", 88, true, 2, true, 0))));

        assertEquals("BLOCK_MERGE", result.decision());
    }
}
