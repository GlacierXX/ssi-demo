package com.shy.demo.mybatis.action;

import com.opensymphony.xwork2.ActionSupport;

import com.shy.demo.mybatis.bean.Province;
import com.shy.demo.mybatis.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Glacier
 * Date: 14-6-18
 * Time: 下午4:42
 * To change this template use File | Settings | File Templates.
 */
public class QueryProvinceAction extends ActionSupport {
    private SqlSession sqlSession;
    private List<Province> provinceList;

    @Action(value = "/queryProvince/init", results = {@Result(name = "success", location = "/view/mybatis/Province.ftl")})
    public String init() throws Exception {
        try {
            SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            provinceList = sqlSession.selectList("queryProvince.getProvinceInfo");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return SUCCESS;
    }

    public List<Province> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<Province> provinceList) {
        this.provinceList = provinceList;
    }
}
