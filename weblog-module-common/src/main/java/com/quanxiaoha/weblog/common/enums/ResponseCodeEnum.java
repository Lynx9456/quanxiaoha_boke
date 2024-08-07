/*
 * Ant Group
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.quanxiaoha.weblog.common.enums;

import com.quanxiaoha.weblog.common.exception.BaseExceptionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 异常码枚举类
 *
 * @author 秋涩
 * @version ResponseCodeEnum.java, v 0.1 2024年07月21日 18:58 秋涩
 */

@Getter
@AllArgsConstructor
public enum ResponseCodeEnum implements BaseExceptionInterface {

    SYSTEM_ERROR("10000", "出错啦，后台小哥正在努力修复中..."),

    PRODUCT_NOT_FOUND("20000", "该产品不存在(测试使用) "),

    PARAM_NOT_VALID("10001", "参数错误"),

    LOGIN_FAIL("20000", "登录失败"),

    USERNAME_OR_PWD_ERROR("20001", "用户名或密码错误"),
    ;

    /**
     * 异常码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMessage;

    /**
     * 通过errorCode查询枚举
     *
     * @param errorCode
     * @return
     */
    public static ResponseCodeEnum getByCode(String errorCode) {
        for (ResponseCodeEnum value : values()) {
            if (value.errorCode.equals(errorCode)) {
                return value;
            }
        }
        return null;
    }
}