package com.reiuy.entity;

import java.sql.Timestamp;

public class User {
    private String username;
    private String userpwd;
    private Timestamp userlastlogin;
    private Integer userlogincount;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public Timestamp getUserlastlogin() {
        return userlastlogin;
    }

    public void setUserlastlogin(Timestamp userlastlogin) {
        this.userlastlogin = userlastlogin;
    }

    public Integer getUserlogincount() {
        return userlogincount;
    }

    public void setUserlogincount(Integer userlogincount) {
        this.userlogincount = userlogincount;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", userpwd='" + userpwd + '\'' +
                ", userlastlogin=" + userlastlogin +
                ", userlogincount=" + userlogincount +
                '}';
    }
}
