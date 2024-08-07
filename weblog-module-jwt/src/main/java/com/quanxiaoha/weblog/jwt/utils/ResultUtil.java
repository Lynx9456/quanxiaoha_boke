/*
 * Ant Group
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.quanxiaoha.weblog.jwt.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quanxiaoha.weblog.common.utils.Response;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 响参工具
 *
 * @author 秋涩
 * @version ResultUtil.java, v 0.1 2024年08月04日 19:06 秋涩
 */
public class ResultUtil {

    /**
     * 成功响参
     *
     * @param response
     * @param result
     * @throws IOException
     */
    public static void ok(HttpServletResponse response, Response<?> result) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpStatus.OK.value());
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();

        ObjectMapper mapper = new ObjectMapper();
        writer.write(mapper.writeValueAsString(result));
        writer.flush();
        writer.close();
    }

    /**
     * 失败响参
     *
     * @param response
     * @param result
     * @throws IOException
     */
    public static void fail(HttpServletResponse response, Response<?> result) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpStatus.OK.value());
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();

        ObjectMapper mapper = new ObjectMapper();
        writer.write(mapper.writeValueAsString(result));
        writer.flush();
        writer.close();
    }

    /**
     * 失败响参
     *
     * @param response
     * @param status   可指定响应码，如 401 等
     * @param result
     * @throws IOException
     */
    public static void fail(HttpServletResponse response, int status, Response<?> result) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setStatus(status);
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();

        ObjectMapper mapper = new ObjectMapper();
        writer.write(mapper.writeValueAsString(result));
        writer.flush();
        writer.close();
    }
}