package com.example.mybatis.domain;

import java.io.Serializable;

public class Employee implements Serializable {
    @Override
	public String toString() {
		return "Employee [id=" + id + ", lastname=" + lastname + ", gender=" + gender + ", email=" + email + "]";
	}

	private Integer id;

    private String lastname;

    private String gender;

    private String email;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}