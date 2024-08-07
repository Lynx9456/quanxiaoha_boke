/*
 * Ant Group
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.quanxiaoha.weblog.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 业务异常
 *
 * @author 秋涩
 * @version BizException.java, v 0.1 2024年07月21日 19:06 秋涩
 */

@Getter
@Setter
public class BizException extends RuntimeException {

    /**
     * 异常码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMessage;

    public BizException(BaseExceptionInterface baseExceptionInterface) {
        this.errorCode = baseExceptionInterface.getErrorCode();
        this.errorMessage = baseExceptionInterface.getErrorMessage();
    }

}