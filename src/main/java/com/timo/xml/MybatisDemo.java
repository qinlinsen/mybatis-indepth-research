package com.timo.xml;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Abraham Qin
 * @since 2019/3/27
 */
public class MybatisDemo {
    public static void main(String[] args) {
        try {
            String resource="com/timo/xml/mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            List<Object> objects = sqlSession.selectList("selectUserList");
                if (objects !=null && objects.size()>0) {
                for (int i = 0; i < objects.size(); i++) {
                    Object o =  objects.get(i);
                    System.out.println(o);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
