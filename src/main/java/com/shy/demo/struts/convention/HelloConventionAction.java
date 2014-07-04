package com.shy.demo.struts.convention;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;


/**
 * Created with IntelliJ IDEA.
 * User: Glacier
 * Date: 14-6-18
 * Time: 上午11:32
 * To change this template use File | Settings | File Templates.
 */
public class HelloConventionAction extends ActionSupport {
    private String name = "Convention";

    @Action(value = "/helloConvention/init", results = {@Result(name = "success", location = "/view/freemarker/convention.ftl")})
    public String init() throws Exception {
        return SUCCESS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
