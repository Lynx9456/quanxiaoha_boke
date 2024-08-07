/*
 * Ant Group
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.quanxiaoha.weblog.jwt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户登录
 *
 * 此类是登录的响参类，VO (View Object) 表示和视图相关的实体类，rsp 是 response 的缩写，表示返参，对应的 req 是 request 的缩写，表示请求。
 * 小哈习惯上对 VO 类的命名规则是：动作 + 请求标识/响应标识 + VO，如 LoginReqVO、LoginRspVO 等
 * 这样做的好处是，可以一眼看出此类的作用，方便后续维护。
 *
 * @author 秋涩
 * @version LoginRspVO.java, v 0.1 2024年08月04日 19:03 秋涩
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRspVO {

    /**
     * Token 值
     */
    private String token;
}