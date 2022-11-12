package com.jungle.wiki.mapper;

import com.jungle.wiki.entity.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *  
 * @author Jungle 
 * @version 2022/11/12 11:34
**/
@Mapper
public interface TestMapper {

    List<Test> list();

}

