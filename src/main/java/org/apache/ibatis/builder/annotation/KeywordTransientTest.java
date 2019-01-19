package org.apache.ibatis.builder.annotation;

import java.io.*;

/**
 * @author Abraham Qin
 * @since 2019/1/13
 */
public class KeywordTransientTest {

    public static void main(String[] args) throws Exception{
        String path="C:\\Users\\yckj0911\\Desktop\\重庆.sql";
        Rectangle rectangle = new Rectangle(3, 4);
        System.out.println("原始对象："+rectangle);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
        //写入对象
        out.writeObject(rectangle);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
        Rectangle antiSerializableObject = (Rectangle)in.readObject();
        System.out.println("反序列化的对象："+antiSerializableObject);
//        antiSerializableObject.setArea();
        System.out.println("恢复成原始对象："+antiSerializableObject);
    }
}
