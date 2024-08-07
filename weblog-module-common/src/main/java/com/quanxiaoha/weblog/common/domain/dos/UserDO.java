/*
 * Ant Group
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.quanxiaoha.weblog.common.domain.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 秋涩
 * @version UserDO.java, v 0.1 2024年07月22日 21:23 秋涩
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_user")
public class UserDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;

    private String password;

    private Date createTime;

    private Date updateTime;

    private Boolean isDeleted;
}