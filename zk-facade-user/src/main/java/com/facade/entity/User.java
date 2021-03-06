package com.facade.entity;

import com.common.entity.DataEntity;

public class User extends DataEntity<User> {



	/**
	 * 
	 */
	private static final long serialVersionUID = -322708613264044559L;

	private String userName;

    private String password;

    private Integer age;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

	
}