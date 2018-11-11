package org.apache.ibatis.autoconstructor;

import org.apache.ibatis.binding.MapperProxy;

import java.lang.reflect.Method;

public class MethodTest {
    public static void main(String[] args) throws Exception{
        Class<MapperProxy> mapperProxyClass = MapperProxy.class;
        Method cachedMapperMethod = mapperProxyClass.getDeclaredMethod("cachedMapperMethod", Method.class);
        Class<?> declaringClass = cachedMapperMethod.getDeclaringClass();
        System.out.println(declaringClass);
//        boolean isSelected=a==b;
        //MethodTest INSTANCE=new MethodTest();
    }
}
