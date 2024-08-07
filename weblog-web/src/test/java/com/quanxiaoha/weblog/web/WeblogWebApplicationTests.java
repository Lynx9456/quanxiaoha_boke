package com.quanxiaoha.weblog.web;

import com.quanxiaoha.weblog.common.domain.dos.UserDO;
import com.quanxiaoha.weblog.common.domain.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
@Slf4j
class WeblogWebApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testLog(){
        log.info("这是一行info级别日志");
        log.warn("这是一行warn级别日志");
        log.error("这是一行error级别日志");

        //占位符
        String author="qiuse";
        log.info("这是一行带有占位符日志，作者：{}",author);
    }

    @Test
    void insertTest(){
        UserDO userDO = UserDO.builder()
                .username("秋涩")
                .password("123456")
                .createTime(new Date())
                .updateTime(new Date())
                .isDeleted(false)
                .build();
        userMapper.insert(userDO);
    }

}
