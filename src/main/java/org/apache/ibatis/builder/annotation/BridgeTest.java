package org.apache.ibatis.builder.annotation;

import java.lang.reflect.Method;

public class BridgeTest {
    public static void main(String[] args) throws Exception{
        Class<MapperAnnotationBuilder> mapperAnnotationBuilderClass = MapperAnnotationBuilder.class;
        Method method = mapperAnnotationBuilderClass.getDeclaredMethod("parse");
        System.out.println(method.isBridge());
    }
}
