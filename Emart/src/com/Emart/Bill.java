package com.Emart;

public class Bill {
	private int billdate;
	private int billmonth;
	private int billyear;
	private long bcustid;
	private String bcustname;
	private float discount;
	private long orderid;
	private int orderPrice;
	private int Paycash;
	
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public int getPaycash() {
		return Paycash;
	}
	public void setPaycash(int paycash) {
		Paycash = paycash;
	}
	public int getBilldate() {
		return billdate;
	}
	public void setBilldate(int billdate) {
		this.billdate = billdate;
	}
	public int getBillmonth() {
		return billmonth;
	}
	public void setBillmonth(int billmonth) {
		this.billmonth = billmonth;
	}
	public int getBillyear() {
		return billyear;
	}
	public void setBillyear(int billyear) {
		this.billyear = billyear;
	}
	public long getBcustid() {
		return bcustid;
	}
	public void setBcustid(long bcustid) {
		this.bcustid = bcustid;
	}
	public String getBcustname() {
		return bcustname;
	}
	public void setBcustname(String bcustname) {
		this.bcustname = bcustname;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public long getOrderid() {
		return orderid;
	}
	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}
	
	public Bill(int billdate,int billmonth,int billyear,long bcustid,String bcustname,float discount,long orderid,int orderprice) {
		this.billmonth=billmonth;
		this.billyear=billyear;
		this.billdate=billdate;
		this.billmonth=billmonth;
		this.billyear=billyear;
		this.bcustid=bcustid;
		this.bcustname=bcustname;
		this.discount=discount;
		this.orderid=orderid;
		this.orderPrice=orderprice;
		
	}
	public Bill(int billdate,int billmonth,int billyear,long bcustid,String bcustname,long orderid,int orderPrice) {
		this.billmonth=billmonth;
		this.billyear=billyear;
		this.billdate=billdate;
		this.billmonth=billmonth;
		this.billyear=billyear;
		this.bcustid=bcustid;
		this.bcustname=bcustname;
		this.orderPrice=orderPrice;
		
		this.orderid=orderid;
	
	}
	
}
