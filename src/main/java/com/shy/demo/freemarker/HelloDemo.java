package com.shy.demo.freemarker;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created with IntelliJ IDEA.
 * User: Glacier
 * Date: 14-6-18
 * Time: 上午11:02
 * To change this template use File | Settings | File Templates.
 */
public class HelloDemo extends ActionSupport{
    private String name = "Glacier";

    public String execute() throws Exception {
        return SUCCESS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
