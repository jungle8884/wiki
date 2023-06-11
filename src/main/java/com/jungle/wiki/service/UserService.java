package com.jungle.wiki.service;

import com.jungle.wiki.domain.User;
import com.jungle.wiki.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 使用@Service注解, 将这个Service交给Spring来管理 
 * @author Jungle 
 * @version 2022/11/12 12:09
**/
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public List<User> getList() {
        return userMapper.selectByExample(null);
    }

}
