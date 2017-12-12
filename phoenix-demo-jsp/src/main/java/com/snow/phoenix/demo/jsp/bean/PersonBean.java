package com.snow.phoenix.demo.jsp.bean;/*
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/12/11          FXY        Created
 **********************************************
 */


import java.io.Serializable;

/**
 * Person模型
 */
public class PersonBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "PersonBean{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
