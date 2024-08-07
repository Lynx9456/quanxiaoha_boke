/*
 * Ant Group
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.quanxiaoha.weblog.web.controller;

import com.quanxiaoha.weblog.common.enums.ResponseCodeEnum;
import com.quanxiaoha.weblog.common.exception.BizException;
import com.quanxiaoha.weblog.common.utils.JsonUtil;
import com.quanxiaoha.weblog.common.utils.Response;
import com.quanxiaoha.weblog.web.model.User;
import com.quanxiaoha.weblog.common.aspect.ApiOperationLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Collectors;

/**
 * @author 秋涩
 * @version TestController.java, v 0.1 2024年07月14日 23:11 秋涩
 */
@RestController
@Slf4j
@Api(tags = "首页模块")
public class TestController {

    /**
     * @param user
     * @param bindingResult
     * @return
     * @Validated: 告诉 Spring 需要对 User 对象执行校验;
     * BindingResult : 验证的结果对象，其中包含所有验证错误信息；
     */
    @PostMapping("/test")
    @ApiOperationLog(description = "测试接口")
    @ApiOperation("测试接口")
    public Response test(@RequestBody @Validated User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldErrors().stream()
                    .map(FieldError::getDefaultMessage)
                    .collect(Collectors.joining(", "));
            return Response.fail(errorMsg);
        }

        // 返参
        return Response.success();
    }

    @PostMapping("/test/not/valid")
    @ApiOperationLog(description = "测试not valid")
    @ApiOperation("测试无效参数")
    public Response testNotValid(@RequestBody @Validated User user) {
        return Response.success();
    }

    @PostMapping("/test/exception")
    @ApiOperationLog(description = "测试exception")
    @ApiOperation("测试其他的错误异常")
    public Response testException(@RequestBody @Validated User user, BindingResult bindingResult) {

        // 主动定义一个运行时异常，分母不能为零
        int i = 1 / 0;

        //手动抛出异常，入参是前面定义好的异常码枚举，返参统一交给全局异常处理器搞定
        throw new BizException(ResponseCodeEnum.PRODUCT_NOT_FOUND);
    }

    @PostMapping("/admin/test/localdatetime")
    @ApiOperationLog(description = "测试LocalDateTime")
    @ApiOperation("测试LocalDateTime")
    public Response testLocalDateTime(@RequestBody @Validated User user){
        //打印入参
        log.info(JsonUtil.toJsonString(user));

        //设置三种日期字段值
        user.setCreatTime(LocalDateTime.now());
        user.setUpdateDate(LocalDate.now());
        user.setTime(LocalTime.now());

        return Response.success(user);
    }

}