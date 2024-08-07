/*
 * Ant Group
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.quanxiaoha.weblog.jwt.handler;

import com.quanxiaoha.weblog.common.utils.Response;
import com.quanxiaoha.weblog.jwt.utils.JwtTokenHelper;
import com.quanxiaoha.weblog.jwt.model.LoginRspVO;
import com.quanxiaoha.weblog.jwt.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证成功处理器
 *
 * @author 秋涩
 * @version RestAuthenticationSuccessHandler.java, v 0.1 2024年08月04日 18:57 秋涩
 */

@Component
@Slf4j
public class RestAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        // 从 authentication 对象中获取用户的 UserDetails 实例，这里是获取用户的用户名
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // 通过用户名生成 Token
        String username = userDetails.getUsername();
        String token = jwtTokenHelper.generateToken(username);

        // 返回 Token
        LoginRspVO loginRspVO = LoginRspVO.builder().token(token).build();

        ResultUtil.ok(response, Response.success(loginRspVO));
    }
}