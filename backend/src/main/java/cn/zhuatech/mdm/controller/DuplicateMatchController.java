/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.mdm.controller;

import cn.zhuatech.mdm.common.ApiResponse;
import cn.zhuatech.mdm.service.DuplicateMatchService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mdm")
public class DuplicateMatchController {
    private final DuplicateMatchService service;
    public DuplicateMatchController(DuplicateMatchService service) { this.service = service; }

    @PostMapping("/duplicate-match")
    public ApiResponse<DuplicateMatchService.Result> compare(@Valid @RequestBody DuplicateMatchService.Request request) {
        return ApiResponse.ok(service.compare(request));
    }
}
