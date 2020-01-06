package com.easyway.review.module.patter.mvc.model;

/**
 * @author 侯建军 QQ:474664736
 * @time 2020/1/6 10:52
 * @class describe
 */
public class Account {
    private String name;//账号名称
    private int level;//账号等级

    public Account() {
    }

    public Account(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
