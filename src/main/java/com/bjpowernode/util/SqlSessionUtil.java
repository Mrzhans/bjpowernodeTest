package com.bjpowernode.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    private static SqlSessionFactory factory = null;

    private SqlSessionUtil(){

    }
    static {
        String resource = "mybatis-config.xml";
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream(resource);
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ThreadLocal<SqlSession> t = new ThreadLocal<>();
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = t.get();
        if (factory != null && sqlSession == null){
            sqlSession = factory.openSession();
            t.set(sqlSession);
        }
        return sqlSession;
    }

    public static void myClose(SqlSession session){
        if (session != null){
            session.close();
            //重要一定要写
            t.remove();
        }
    }
}
