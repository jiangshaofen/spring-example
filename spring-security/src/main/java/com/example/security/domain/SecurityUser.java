package com.example.security.domain;

import java.io.Serializable;
import java.util.Date;

public class SecurityUser implements Serializable {
    private String uid;

    private String username;

    private String password;

    private Integer benabled;

    private String role;

    private String phone;

    private Date createdate;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}