package com.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 工具类，可以得到SqlSession
 */
public class MybatisUtils {
    //会话工厂
    private static SqlSessionFactory sqlSessionFactory;


    static {
        try {
            //指定资源文件、配置文件
            String resource = "mybatis-config.xml";
            //获取到配置文件对应的流InputStream
            InputStream inputStream = Resources.getResourceAsStream(resource);

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //方法返回SqlSession对象会话
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

}
