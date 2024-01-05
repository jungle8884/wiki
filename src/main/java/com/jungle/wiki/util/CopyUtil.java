package com.jungle.wiki.util;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jungle
 */
public class CopyUtil {

    /**
     * 单体复制：单个对象的复制
     * @param source 源对象
     * @param clazz 目标对象类型
     */
    public static <T> T copy(Object source, Class<T> clazz) {
        if (source == null) {
            return null;
        }
        T obj = null;
        try {
            // 生成目标对象
            obj = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        // 把原对象复制到目标对象
        BeanUtils.copyProperties(source, obj);
        // 返回目标对象
        return obj;
    }

    /**
     * 列表复制
     * @param source 源对象列表
     * @param clazz 目标对象类型
     */
    public static <T> List<T> copyList(List source, Class<T> clazz) {
        List<T> target = new ArrayList<>();
        // 如果源对象列表不为空，就遍历
        if (!CollectionUtils.isEmpty(source)){
            for (Object s : source) {
                // 每个对象复制到目标对象并添加到目标对象列表
                T obj = copy(s, clazz);
                target.add(obj);
            }
        }
        // 返回目标对象列表
        return target;
    }
}
