package com.shy.demo.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Glacier
 * Date: 14-6-18
 * Time: 下午4:23
 * To change this template use File | Settings | File Templates.
 */
public class DaoUtils {
    private static SqlSession sqlSession;
    private static String resource = "/mybatis_conf.xml";

    public static SqlSession getDao() {
        try{
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            return sqlSession = sqlSessionFactory.openSession();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return sqlSession;
    }
}
