/*
 * Ant Group
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.quanxiaoha.weblog.web.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author 秋涩
 * @version User.java, v 0.1 2024年07月14日 23:11 秋涩
 */
@Data
@ApiModel("用户实体类")
public class User {

    // 用户名
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty("用户名")
    private String username;

    // 性别
    @NotNull(message = "性别不能为空")
    @ApiModelProperty("性别")
    private Integer sex;

    // 年龄
    @NotNull
    @Min(value = 18,message = "年龄必须大于等于18")
    @Max(value = 100,message = "年龄必须小于等于100")
    @ApiModelProperty("年龄")
    private Integer age;

    // 邮箱
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    @ApiModelProperty("邮箱")
    private String email;

    // 创建时间
    private LocalDateTime creatTime;

    // 更新日期
    private LocalDate updateDate;

    // 时间
    private LocalTime time;
}