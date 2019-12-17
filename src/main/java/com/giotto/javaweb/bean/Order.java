package com.giotto.javaweb.bean;

import java.sql.Timestamp;

public class Order {
	
	private long orderid;
	private long comid;
	private long buyerid;
	private long num;
	private long total;
	private String status;
	private Timestamp date;
	private String raddress;
	private String rman;
	private String remail;
	private String rphone;
	private String comname;
	
	public long getOrderid()
	{
		return this.orderid;
	}
	public long getComid()
	{
		return this.comid;
	}
	public long getBuyerid()
	{
		return this.buyerid;
	}
	public long getNum()
	{
		return this.num;
	}
	public long getTotal()
	{
		return this.total;
	}
	public String getStatus()
	{
		return this.status;
	}
	public String getRaddress()
	{
		return this.raddress;
	}
	public String getRman()
	{
		return this.rman;
	}
	public String getRemail()
	{
		return this.remail;
	}
	public String getRphone()
	{
		return this.rphone;
	}
	public String getComname()
	{
		return this.comname;
	}
	public Timestamp getDate()
	{
		return this.date;
	}
	public void setDate(Timestamp t)
	{
		this.date=t;
	}
	public void setOrderid(long i)
	{
		this.orderid=i;
	}
	public void setComid(long i)
	{
		this.comid=i;
	}
	public void setBuyerid(long i)
	{
		this.buyerid=i;
	}
	public void setNum(long i)
	{
		this.num=i;
	}
	public void setTotal(long i)
	{
		this.total=i;
	}
	public void setStatus(String r)
	{
		this.status=r;
	}
	public void setRaddress(String r)
	{
		this.raddress=r;
	}
	public void setRman(String r)
	{
		this.rman=r;
	}
	public void setRemail(String r)
	{
		this.remail=r;
	}
	public void setComname(String r)
	{
		this.comname=r;
	}
	public void setRphone(String r)
	{
		this.rphone=r;
	}
}
