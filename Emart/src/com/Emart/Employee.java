package com.Emart;

import java.util.Scanner;
import java.util.*;
public class Employee extends LoginEmart {
	Scanner in=new Scanner(System.in); 
	private int id;
      private String name;
      private int salary;
      private int holidaystaken;
      private int hreq;
      private int holidaysremaining=10;
      final static int holidaysallowed=10;
      private static ArrayList<Bill>regular=new ArrayList<Bill>();
      private static ArrayList<Bill>normal=new ArrayList<Bill>();
      private static ArrayList<Payment> rp=new ArrayList<Payment>();
      private static ArrayList<Payment> np=new ArrayList<Payment>();
      static float discount =0.01f;
      String reply;
      public int getHreq() {
		return hreq;
	}
	public void setHreq(int hreq) {
		this.hreq = hreq;
	}

	
     
      public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getHolidaystaken() {
		return holidaystaken;
	}
	public void setHolidaystaken(int n) {
		this.holidaystaken=n+getHreq();
		
	}
	
	public int getHolidaysremaining() {
		return holidaysremaining;
	}
	public void setHolidaysremaining(int n) {
		this.holidaysremaining=holidaysremaining-getHolidaystaken();
		
	}
	
	public int getHolidaysallowed() {
		return holidaysallowed;
	}
	public static ArrayList<Bill> getRegular() {
		return regular;
	}
	public static void setRegular(ArrayList<Bill> regular) {
		Employee.regular = regular;
	}
	public static ArrayList<Bill> getNormal() {
		return normal;
	}
	public static void setNormal(ArrayList<Bill> normal) {
		Employee.normal = normal;
	}
	public static ArrayList<Payment> getRp() {
		return rp;
	}
	public static void setRp(ArrayList<Payment> rp) {
		Employee.rp = rp;
	}
	public static ArrayList<Payment> getNp() {
		return np;
	}
	public static void setNp(ArrayList<Payment> np) {
		Employee.np = np;
	}
	
	public Employee() {
    	  
      }
    public Employee(int id,String name,int salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
        this.holidaystaken=0;
        this.holidaysremaining=10;
        
    }


	
	
	public void viewMydetails() {
		System.out.println("PLEASE ENTER THE USERNAME");
   		name=in.nextLine();
   		System.out.println("PLEASE ENTER THE PASSWORD");
   		id=in.nextInt();
	  
		if(id==Eadministrator.getA().get(id-1).id&&name==Eadministrator.getA().get(id-1).name) {
			   System.out.println("WELCOME "+Eadministrator.getA().get(id-1).name);
			   System.out.println( "\n Press 1 : TO VIEW YOUR DETAILS"+
                                   "\n Press 2 : EXIT");
 
			                                                        
			
		}
		else {
			System.out.println("INVALID USERNAME or ID");
		}
		
	}

	
	public void loginEmart () {
	
		System.out.println("Enter your name");
		String username=in.nextLine();
		System.out.println("Enter your id");
		int id=in.nextInt();
	 
		for(int i=0;i<Eadministrator.getA().size();i++) {
		if(id==Eadministrator.getA().get(i).id&&username.equals(Eadministrator.getA().get(i).name)) {
		    System.out.println("WELCOME"+" "+Eadministrator.getA().get(i).name);
		    System.out.println("PLEASE SELECT ANYONE OF THE OPTION GIVEN BELOW");
   			System.out.println("\n PRESS 1 : TO SEE YOUR DETAILS"+
		                       "\n PRESS 2 : TO APPLY FOR HOLIDAY"+
   					           "\n PRESS 3 : To generate bill"+
		                       "\n PRESS 4 : To update Payment records"+
   					           "\n PRESS 5 : To view Payment records"+
		                       "\n PRESS 6 : To deliver items,to update payment records,to update bill records"+
   					           "\n PRESS 7: EXIT ");
	
			
			boolean empexit=false;
			
			while(!empexit) {
				System.out.println("Enter your choice");
				int empcommand=in.nextInt();
				switch(empcommand) {
				case 1:
					viewempdetails();
					break;
				case 2:
					requestleave(Eadministrator.getA().get(i));
					break;
				case 3:
					Generatebill();
					break;
				case 4:
					paymentUpdate();
					break;
				case 5:
					viewPaymentrecord();
					break;
				case 6:
					paymentrecordReupdate();
				break;	
					
				
				case 7:
			    empexit=true;
				System.out.println("You have exited the employee login");
					break;
				
					default:
						System.out.println( "PLEASE ENETER VALID COMMAND");
				}
			}
   		
   					           
		}
		else {
			System.out.println("Invalid id or username");
		}
		}
			 
	         	
	}
     public void requestleave(Employee a) {
     System.out.println("Please enter the number of holidays that you would like to take");
     int hols=in.nextInt();
     String s="yes";
     String n="no";
     
	
	if ( Eadministrator.getA().get(id).getHolidaysremaining()==0) {
		System.out.println("You don't have sufficient holidays remaing");
		System.out.println("But if you still want to take a holiday amount of Rs 1000 will be deducted");
		System.out.println("\n Type yes if you want to continue with request"+
		                   "\n Type no if you want to discontinue with request");
		 reply=in.nextLine();

		
		
	} 
	else {
		System.out.println("Requested for " + hols + "days");
		setHreq(hols);
		setHolidaystaken(getHreq());
		Eadministrator.getA().get(id).setHolidaystaken(getHreq());		
		Eadministrator.getA().get(id).setHolidaysremaining(getHolidaystaken());

	}
	
	

}
      public void viewempdetails(){
	System.out.println("\nName                 : "+Eadministrator.getA().get(id).name+
			           "\nSalary               : "+Eadministrator.getA().get(id).salary+
			           "\nHoliday Remaining    : "+Eadministrator.getA().get(id).getHolidaysremaining()+
			           "\nHolidays Taken       : "+Eadministrator.getA().get(id).getHolidaystaken());
       }
               
      public int deductsalary(Employee a) {
	         final int deductsalary=1000;
	         salary=salary-deductsalary;
    	  return salary;
    	  
    	  
    	  
           }
      @SuppressWarnings("deprecation")
	public void Generatebill() {
    	  Date a=new Date();
    	 if(Customer.getO().size()>0) {
    	  for(int i=0;i<CompanyLogin.getC().size();i++) {
    		  for(int j=0;j<Customer.getO().size();j++) {
    		  if(Customer.getO().get(j).getOrdercustid()==CompanyLogin.getC().get(i).getCustid())
    	  if(CompanyLogin.getC().get(i).getPurchasepoints()>=3) {
    	  regular.add(new Bill(a.getDate(),a.getMonth(),a.getYear(),Customer.getO().get(j).getOrdercustid(),CompanyLogin.getC().get(i).getCustName(),discount,Customer.getO().get(j).getOrderId(),Customer.getO().get(j).getOrderedprice()));
    	    System.out.println("Bill generated for prime customers");
    	  }
    	  else {
    		 normal.add(new Bill(a.getDate(),a.getMonth(),a.getYear(),Customer.getO().get(j).getOrdercustid(),CompanyLogin.getC().get(i).getCustName(),Customer.getO().get(j).getOrderId(),Customer.getO().get(j).getOrderedprice()));
    	  System.out.println("Bill generated for normal customers");
    	  }
    	  }
    	  }
    	 }
    	 else {
    		 System.out.println("There are no orders yet!!!");
    	 }
    	  }
      
      public static int discountpriced(int cash) {
    	  int discountedprice=(int) (discount*cash);
    	  return discountedprice;
      }
	
	public static void paymentUpdate() {
		if(normal.size()>0) {
			for(int i=0;i<CompanyLogin.getC().size();i++) {
				for(int j=0;j<normal.size();j++) {
					if(CompanyLogin.getC().get(i).getCustid()==normal.get(j).getBcustid()) {
						np.add(new Payment(CompanyLogin.getC().get(i).getCustid(),Customer.sumCash( Customer.getO().get(j).getOrdercustid()),CompanyLogin.getC().get(i).getCustName()));
					}
				}
			}
		}
		else if(regular.size()>0) {
			for(int i=0;i<CompanyLogin.getC().size();i++) {
				for(int j=0;j<regular.size();j++) {
					for(int k=0;k<1;k++) {
					if(CompanyLogin.getC().get(i).getCustid()==normal.get(j).getBcustid()) {
						rp.add(new Payment(CompanyLogin.getC().get(i).getCustid(),discountpriced(Customer.sumCash(Customer.getO().get(j).getOrdercustid())),CompanyLogin.getC().get(i).getCustName()));
						
					}
					}
				}
			}
		}
	}

	
	public static void viewPaymentrecord() {
		if(np.size()>0) {
			System.out.println("NORMAL CUSTOMER PAYMENT RECORDS");
			for(int i=0;i<np.size();i++) {
				
				System.out.println("\nName       : "+np.get(i).getCustname()+
						           "\nCustid     : "+np.get(i).getPcustid()+
						           "\nDue Amount : "+np.get(i).getPay());
				
			}
			}
		else {
		System.out.println("None of the normal customers has ordered");
		}
		
		if(rp.size()>0) {
			System.out.println(" REGULAR CUSTOMER PAYMENT RECORDS");
          for(int i=0;i<np.size();i++) {
				
				System.out.println("\nName       : "+rp.get(i).getCustname()+
						           "\nCustid     : "+rp.get(i).getPcustid()+
						           "\nDue Amount : "+rp.get(i).getPay());
				
			}
		}
		else {
			System.out.println("None of the regular customers has ordered");
		}
	}
	public void paymentrecordReupdate() {
	 for(int i=0;i<np.size();i++){
		 if(np.get(i).getPay()==0){
			 for(int j=0;j<normal.size();j++){
				 if(np.get(i).getPcustid()==normal.get(j).getBcustid()){
					 normal.remove(j);
					 for(int z=0;z<Customer.getO().size();z++){
						 if(np.get(i).getPcustid()==Customer.getO().get(z).getOrdercustid()){
							 Customer.getO().get(z).setDeliverystatus("Delivered");
							 Customer.getO().get(z).setPaymentstatus("Paid");						 }
					 }

				 }
			 }
			np.remove(i); 
		 }
	 }
		
	 for(int i=0;i<rp.size();i++){
		if(rp.get(i).getPay()==0){
			for(int j=0;j<regular.size();j++){
				if(rp.get(i).getPcustid()==regular.get(j).getBcustid()){
					regular.remove(j);
					for(int z=0;z<Customer.getO().size();z++){
						if(rp.get(i).getPcustid()==Customer.getO().get(z).getOrdercustid()){
							Customer.getO().get(z).setDeliverystatus("Delivered");
							Customer.getO().get(z).setPaymentstatus("Paid");						 }
					}


				}
			}
		   rp.remove(i); 
		}
	}

	}

}
