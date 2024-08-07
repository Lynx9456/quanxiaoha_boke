/*
 * Ant Group
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.quanxiaoha.weblog.common.exception;

/**
 * 通用异常接口
 *
 * @author 秋涩
 * @version BaseExceptionInterface.java, v 0.1 2024年07月21日 18:57 秋涩
 */
public interface BaseExceptionInterface {

    /**
     * 获取异常码
     *
     * @return
     */
    String getErrorCode();

    /**
     * 获取异常信息
     *
     * @return
     */
    String getErrorMessage();
}