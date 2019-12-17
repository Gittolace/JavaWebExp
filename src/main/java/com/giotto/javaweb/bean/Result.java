package com.giotto.javaweb.bean;

public class Result<T> {

    //返回信息

    private String msg;

    //数据是否正常请求

    private boolean success;

    //具体返回的数据

    private T detail;

	public void setSuccess(boolean b) {
		// TODO Auto-generated method stub
		this.success=b;
	}

	public void setDetail(T object) {
		// TODO Auto-generated method stub
		this.detail=object;
	}

	public void setMsg(String string) {
		// TODO Auto-generated method stub
		this.msg=string;
	}
	
	public String getMsg() {
		// TODO Auto-generated method stub
		return this.msg;
	}
	public boolean getSuccess() {
		// TODO Auto-generated method stub
		return this.success;
	}
	public T getDetail() {
		// TODO Auto-generated method stub
		return this.detail;
	}
	
	
    //... getter and setter

}

