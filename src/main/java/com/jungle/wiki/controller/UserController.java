package com.jungle.wiki.controller;

import com.jungle.wiki.domain.Demo;
import com.jungle.wiki.domain.User;
import com.jungle.wiki.service.DemoService;
import com.jungle.wiki.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author Jungle
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    @GetMapping("/list")
    public List<User> list() {
        return userService.getList();
    }

}
