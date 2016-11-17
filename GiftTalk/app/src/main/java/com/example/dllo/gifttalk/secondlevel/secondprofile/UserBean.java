package com.example.dllo.gifttalk.secondlevel.secondprofile;

import java.util.ArrayList;

import cn.bmob.v3.BmobUser;

/**
 * Created by dllo on 16/11/17.
 */
public class UserBean extends BmobUser{
    private ArrayList<String> collect;
    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public ArrayList<String> getCollect() {
        return collect;
    }

    public void setCollect(ArrayList<String> collect) {
        this.collect = collect;
    }
}
