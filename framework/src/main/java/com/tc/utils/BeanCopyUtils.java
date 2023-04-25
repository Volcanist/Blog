package com.tc.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class BeanCopyUtils {

//    私有的构造方法，表明该类不能直接new出来
    private BeanCopyUtils(){}

    public static <V> V copyBean(Object source, Class<V> clazz){
        //创建目标对象
        V result = null;
        //实现属性copy
        try {
            result =  clazz.newInstance();
            BeanUtils.copyProperties(source,result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回结果
        return result;
    }

    public static <O,V> List<V> copyBeanList(List<O> list, Class<V> clazz){
        return list.stream()
                .map(o -> copyBean(o, clazz))
                .collect(Collectors.toList());
    }
}
