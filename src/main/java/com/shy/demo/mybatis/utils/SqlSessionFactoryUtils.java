package com.shy.demo.mybatis.utils;

import org.apache.ibatis.io.Resources;
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
public class SqlSessionFactoryUtils {
    private static SqlSessionFactory sqlSessionFactory;
    private static String resource = "/mybatis_conf.xml";

    public static synchronized SqlSessionFactory getSqlSessionFactory() {
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            if(sqlSessionFactory == null){
                sqlSessionFactory =  new SqlSessionFactoryBuilder().build(inputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }
}
