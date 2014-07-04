package com.shy.demo.mybatis.action;

import com.opensymphony.xwork2.ActionSupport;
import com.shy.demo.mybatis.DaoUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Glacier
 * Date: 14-6-18
 * Time: 下午4:42
 * To change this template use File | Settings | File Templates.
 */
public class QueryProvince extends ActionSupport {
    private String resource = "/mybatis_conf.xml";
    private SqlSession sqlSession;
    private List<Map> provinceList;

    @Action(value = "/queryProvince/init", results = {@Result(name = "success",location = "/view/mybatis/Province.ftl")})
    public String init() throws Exception {
        try{
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            provinceList = sqlSession.selectList("queryProvince.getProvinceInfo");
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return SUCCESS;
    }

    public List<Map> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<Map> provinceList) {
        this.provinceList = provinceList;
    }
}
