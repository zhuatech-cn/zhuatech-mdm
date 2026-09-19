/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.mdm.controller;
import cn.zhuatech.mdm.common.ApiResponse;import cn.zhuatech.mdm.service.GoldenRecordPublishGovernanceService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/enterprise/mdm")public class GoldenRecordPublishGovernanceController{private final GoldenRecordPublishGovernanceService service;/**
                                                                                                                                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                       */
public GoldenRecordPublishGovernanceController(GoldenRecordPublishGovernanceService service){this.service=service;}/**
                                                                                                                                                                                                                                                                                          * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                          */
@PostMapping("/golden-record-publish")public ApiResponse<GoldenRecordPublishGovernanceService.Assessment> assess(@Valid @RequestBody GoldenRecordPublishGovernanceService.Request request){return ApiResponse.ok("黄金记录发布评估完成",service.assess(request));}}
