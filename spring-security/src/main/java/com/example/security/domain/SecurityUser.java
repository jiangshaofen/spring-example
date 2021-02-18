package com.example.security.domain;

import java.io.Serializable;
import java.util.Date;

public class SecurityUser implements Serializable {
    private String uid;

    private String username;

    private String password;

    private Integer benabled;

    private String sphone;

    private Date dcreatedate;

    private static final long serialVersionUID = 1L;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getBenabled() {
        return benabled;
    }

    public void setBenabled(Integer benabled) {
        this.benabled = benabled;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public Date getDcreatedate() {
        return dcreatedate;
    }

    public void setDcreatedate(Date dcreatedate) {
        this.dcreatedate = dcreatedate;
    }
}