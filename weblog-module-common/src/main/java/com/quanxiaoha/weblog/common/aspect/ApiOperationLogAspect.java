/*
 * Ant Group
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.quanxiaoha.weblog.common.aspect;

import com.quanxiaoha.weblog.common.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author 秋涩
 * @version ApiOperationLogAspect.java, v 0.1 2024年07月14日 22:47 秋涩
 */

@Aspect
@Component
@Slf4j
public class ApiOperationLogAspect {

    /**
     * 以自定义 @ApiOperationLog 注解为切点，凡是添加 @ApiOperationLog 的方法，都会执行环绕中的代码
     */
    @Pointcut("@annotation(com.quanxiaoha.weblog.common.aspect.ApiOperationLog)")
    public void apiOperationLog() {
    }

    /**
     * 环绕
     *
     * @param pjp
     * @return
     */
    @Around("apiOperationLog()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        try {
            //请求开始时间
            long startTime = System.currentTimeMillis();

            //MDC，traceId 表示跟踪 ID， 值这里直接用的 UUID
            MDC.put("traceId", UUID.randomUUID().toString());

            // 获取被请求的类和方法
            String className = pjp.getTarget().getClass().getSimpleName();
            String methodName = pjp.getSignature().getName();

            // 请求入参
            Object[] args = pjp.getArgs();
            // 入参转 JSON 字符串
            String argsJsonStr = Arrays.stream(args).map(JsonUtil::toJsonString).collect(Collectors.joining(", "));

            // 功能描述信息
            String description = getApiOperationLogDescription(pjp);

            // 打印请求相关参数
            log.info("====== 请求开始: [{}], 入参: {}, 请求类: {}, 请求方法: {} =================================== ",
                    description, argsJsonStr, className, methodName);

            // 执行切点方法
            Object result = pjp.proceed();

            // 执行耗时
            long executionTime = System.currentTimeMillis() - startTime;

            // 打印出参等相关信息
            log.info("====== 请求结束: [{}], 耗时: {}ms, 出参: {} =================================== ",
                    description, executionTime, JsonUtil.toJsonString(result));

            return result;
        } finally {
            MDC.clear();
        }
    }

    /**
     * 获取注解的描述信息
     * @param pjp
     * @return
     */
    private String getApiOperationLogDescription(ProceedingJoinPoint pjp) {
        // 1. 从 ProceedingJoinPoint 获取 MethodSignature
        MethodSignature signature = (MethodSignature) pjp.getSignature();

        // 2. 使用 MethodSignature 获取当前被注解的 Method
        Method method = signature.getMethod();

        // 3. 从 Method 中提取 LogExecution 注解
        ApiOperationLog apiOperationLog = method.getAnnotation(ApiOperationLog.class);

        // 4. 从 LogExecution 注解中获取 description 属性
        return apiOperationLog.description();
    }
}