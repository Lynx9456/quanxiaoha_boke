/*
 * Ant Group
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.quanxiaoha.weblog.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 密码加密
 *
 * @author 秋涩
 * @version PasswordEncoderConfig.java, v 0.1 2024年08月04日 11:43 秋涩
 */

@Component
public class PasswordEncoderConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCrypt 是一种安全且适合密码存储的哈希算法，它在进行哈希时会自动加入“盐”，增加密码的安全性。
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("quanxiaoha"));
    }
}