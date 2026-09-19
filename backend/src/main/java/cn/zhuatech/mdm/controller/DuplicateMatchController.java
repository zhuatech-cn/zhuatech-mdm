/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.mdm.controller;

import cn.zhuatech.mdm.common.ApiResponse;
import cn.zhuatech.mdm.service.DuplicateMatchService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/mdm")
public class DuplicateMatchController {
    private final DuplicateMatchService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public DuplicateMatchController(DuplicateMatchService service) { this.service = service; }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/duplicate-match")
    public ApiResponse<DuplicateMatchService.Result> compare(@Valid @RequestBody DuplicateMatchService.Request request) {
        return ApiResponse.ok(service.compare(request));
    }
}
