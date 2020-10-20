package com.cs.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/*
工具类
* */
public class MybatisUtil {

    static SqlSessionFactory ssf;

    static {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            ssf = builder.build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //创建SqlSession对象
    public static SqlSession createSqlSession() {
        return ssf.openSession();
    }

    //关闭资源
    public static void closeSqlSession(SqlSession sqlSession) {
        sqlSession.close();
    }

}
