package com.Emart;
import java.util.*;
public class Item {
	Scanner scan =new Scanner(System.in);
	 public long itemid ;
     public String itemname;
     public int itemquantity;
     public  int itemprice;
     public String itemtype;
     
     public Item(long itemid,String itemname,int itemquantity,int itemprice,String itemtype) {
    	this.itemid=itemid;
    	this.itemname=itemname;
    	this.itemprice=itemprice;
    	this.itemquantity=itemquantity;
    	this.itemtype=itemtype;
     }

	public long getItemid() {
		return itemid;
	}

	public void setItemid(long itemid) {
		this.itemid = itemid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public int getItemquantity() {
		return itemquantity;
	}

	public void setItemquantity(int n) {
		itemquantity = itemquantity+n;
	}

	public int getItemprice() {
		return itemprice;
	}

	public void setItemprice(int itemprice) {
		this.itemprice = itemprice;
	}

	public String getItemtype() {
		return itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	} 
     
     
     
     
     
     
    
      
      
    
}
