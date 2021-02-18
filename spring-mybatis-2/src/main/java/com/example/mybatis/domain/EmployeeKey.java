package com.example.mybatis.domain;

import java.io.Serializable;

public class EmployeeKey implements Serializable {
    private Integer id;

    private String lastname;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}