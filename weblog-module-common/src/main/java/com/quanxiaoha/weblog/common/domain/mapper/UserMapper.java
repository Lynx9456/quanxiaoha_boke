/*
 * Ant Group
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.quanxiaoha.weblog.common.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quanxiaoha.weblog.common.domain.dos.UserDO;

/**
 * @author 秋涩
 * @version UserMapper.java, v 0.1 2024年07月22日 21:25 秋涩
 */
public interface UserMapper extends BaseMapper<UserDO> {

    /**
     * 根据用户名查询信息
     *
     * @param username
     * @return
     */
    default UserDO findByUsername(String username) {
        LambdaQueryWrapper<UserDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserDO::getUsername, username);
        return selectOne(wrapper);
    }
}