package com.jungle.wiki.service;

import com.jungle.wiki.entity.Test;
import com.jungle.wiki.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 使用@Service注解, 将这个Service交给Spring来管理 
 * @author Jungle 
 * @version 2022/11/12 12:09
**/
@Service
public class TestService {

    @Resource
    private TestMapper testMapper;

    public List<Test> getList() {
        return testMapper.list();
    }

}
