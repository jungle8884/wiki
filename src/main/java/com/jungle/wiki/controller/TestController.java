package com.jungle.wiki.controller;

import com.jungle.wiki.entity.Test;
import com.jungle.wiki.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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

    @Value("${test.hello:TEST}")
    private String testHello;

    @Resource
    private TestService testService;

    /**
     * GET, 查询请求 /user?id=1 ==> /user/1
     * POST, 新增请求
     * PUT, 修改请求
     * DELETE 删除请求
     * // @RequestMapping("/hello") 接受所有请求
     * */
    @GetMapping("/hello")
    public String hello() {
        return "hello world!" + testHello;
    }

    /**
     * 参数名字一样, 直接映射
     * */
    @PostMapping("/hello/post")
    public String helloPost(String name) {
        return "Hello World! Post，" + name;
    }


    @GetMapping("test/list")
    public List<Test> list() {
        return testService.getList();
    }
}
