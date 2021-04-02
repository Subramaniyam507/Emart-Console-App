package com.Emart;

public class Payment {
	private String custname;

	private long Pcustid;
    private int pay;
    public Payment(long Pcustid,int pay,String custname) {
    	this.Pcustid=Pcustid;
    	this.pay=pay;
    	this.setCustname(custname);
    }
	public long getPcustid() {
		return Pcustid;
	}
	public void setPcustid(long pcustid) {
		Pcustid = pcustid;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
  
    
}
