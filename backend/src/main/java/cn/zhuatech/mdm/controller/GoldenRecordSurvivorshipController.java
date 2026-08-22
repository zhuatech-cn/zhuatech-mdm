/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.mdm.controller;

import cn.zhuatech.mdm.common.ApiResponse;
import cn.zhuatech.mdm.service.GoldenRecordSurvivorshipService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mdm/insights")
public class GoldenRecordSurvivorshipController {
    private final GoldenRecordSurvivorshipService service;

    public GoldenRecordSurvivorshipController(GoldenRecordSurvivorshipService service) {
        this.service = service;
    }

    @PostMapping("/golden-record-survivorship")
    public ApiResponse<GoldenRecordSurvivorshipService.Result> select(
        @Valid @RequestBody GoldenRecordSurvivorshipService.Request request) {
        return ApiResponse.ok(service.select(request));
    }
}
