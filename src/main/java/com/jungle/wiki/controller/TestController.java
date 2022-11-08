package com.jungle.wiki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试 
 * @author Jungle 
 * @version 2022/11/08 23:52
 * // @RestController //返回字符串 == @Controller+@ResponseBody
 * // @Controller //返回页面
 * // @ResponseBody //返回字符串 or json
**/
@RestController
public class TestController {

    /**
     * GET, 查询请求 /user?id=1 ==> /user/1
     * POST, 新增请求
     * PUT, 修改请求
     * DELETE 删除请求
     * // @RequestMapping("/hello") 接受所有请求
     * */
    @RequestMapping("/hello")
    public String hello() {
        return "hello world!";
    }

}
