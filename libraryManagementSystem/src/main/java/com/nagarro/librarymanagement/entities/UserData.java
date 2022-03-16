package com.nagarro.librarymanagement.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userdata")
public class UserData {
	@Id
	String userid;
	String password;
	
	public String getUserId() {
		return userid;
	}
	
	public void setUserId(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserData [userid=" + userid + ", password=" + password + "]";
	}

}
