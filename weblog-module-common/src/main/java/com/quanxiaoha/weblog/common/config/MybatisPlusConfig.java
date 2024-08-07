/*
 * Ant Group
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.quanxiaoha.weblog.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis Plus 配置文件
 *
 * @author 秋涩
 * @version MybatisPlusConfig.java, v 0.1 2024年07月22日 21:19 秋涩
 */

@Configuration
@MapperScan("com.quanxiaoha.weblog.common.domain.mapper")
public class MybatisPlusConfig {
}