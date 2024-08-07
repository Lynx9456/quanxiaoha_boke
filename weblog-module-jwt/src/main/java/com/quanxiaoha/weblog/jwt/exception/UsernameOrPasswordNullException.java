/*
 * Ant Group
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.quanxiaoha.weblog.jwt.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 用户名或者密码为空异常
 *
 * @author 秋涩
 * @version UsernameOrPasswordNullException.java, v 0.1 2024年08月04日 18:54 秋涩
 */
public class UsernameOrPasswordNullException extends AuthenticationException {
    public UsernameOrPasswordNullException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public UsernameOrPasswordNullException(String msg) {
        super(msg);
    }
}