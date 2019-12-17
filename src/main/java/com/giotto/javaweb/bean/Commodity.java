package com.giotto.javaweb.bean;

public class Commodity {
	
	private long comid;
	private String comname;
	private long ownmanid;
	private String details;
	private String comtype;
	private long price;
	
	public long getComid()
	{
		return this.comid;
	}
	public long getOwnmanid()
	{
		return this.ownmanid;
	}
	public long getPrice()
	{
		return this.price;
	}
	
	public String getComname()
	{
		return this.comname;
	}
	public String getComtype()
	{
		return this.comtype;
	}
	public String getDetails()
	{
		return this.details;
	}
	public void setComid(long i)
	{
		this.comid=i;
	}
	public void setOwnmanid(long i)
	{
		this.ownmanid=i;
	}
	public void setPrice(long i)
	{
		this.price=i;
	}
	public void setComname(String r)
	{
		this.comname=r;
	}
	public void setDetails(String r)
	{
		this.details=r;
	}
	public void setComtype(String r)
	{
		this.comtype=r;
	}
}
