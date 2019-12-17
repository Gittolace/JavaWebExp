package com.giotto.javaweb.bean;

//用户信息

public class User {

private Long userid;

private String username;

private String password;

private String usertype;


public String getUsername() {
	// TODO Auto-generated method stub
	return this.username;
}

public String getPassword() {
	// TODO Auto-generated method stub
	return this.password;
}

public Long getUserid() {
	// TODO Auto-generated method stub
	return this.userid;
}

public String getUsertype(){
	return this.usertype;
}

public void setUsertype(String p) {
	this.usertype=p;
}

public void setUserid(Long userId) {
	// TODO Auto-generated method stub
	this.userid=userId;
}

public void setUsername(String str) {
	// TODO Auto-generated method stub
	this.username=str;
}
public void setPassword(String str) {
	// TODO Auto-generated method stub
	this.password=str;
}


//... getter and setter

}