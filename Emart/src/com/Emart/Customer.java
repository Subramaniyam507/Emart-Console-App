package com.Emart;

import java.util.*;

public class Customer {
	private String custName;
    static long nstore=0;
    static long rstore=0;
	private long custid;
	private long orderid;
	private int purchasepoints;
	private long custwallet;
	private String email;
	private String password;
	private int totalinv;
	private int paycash;
	
	public static ArrayList<Order> getO() {
		return o;
	}

	public static void setO(ArrayList<Order> o) {
		Customer.o = o;
	}
	public int getTotalinv() {
		return totalinv;
	}

	public void setTotalinv(int totalinv) {
		this.totalinv = totalinv;
	}

	public int getPaycash() {
		return paycash;
	}

	public void setPaycash(int paycash) {
		this.paycash = paycash;
	}

	private static ArrayList<Order>o=new ArrayList<Order>();
	static Scanner cst=new Scanner(System.in);
	

	public long getCustwallet() {
		return custwallet;
	}

	public void setCustwallet(int n) {
		custwallet = custwallet+n;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	

	public long getCustid() {
		return custid;
	}

	public void setCustid(long custid) {
		this.custid = custid;
	}

	public long getOrderid() {
		return orderid;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}

	public int getPurchasepoints() {
		return purchasepoints;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPurchasepoints(int n) {
		purchasepoints = purchasepoints+n;
	}

	public Customer() {
		
	}
	
    public Customer(long custid,String custName,String email,String password) {
	 this.custid=custid;
	 this.custName=custName;
	 this.custName=custName;
	 this.email=email;
	 this.password=password;
	 
 }
    public void loginEmart () {
    	
		System.out.println("Enter your email");
		String mail=cst.next();
		System.out.println("Enter your password");
	    String pas=cst.next();
	 
		for(int i=0;i<CompanyLogin.getC().size();i++) {
		if(mail.equals(CompanyLogin.getC().get(i).email)&&pas.equals(CompanyLogin.getC().get(i).password)) {
		    System.out.println("WELCOME"+" "+CompanyLogin.getC().get(i).custName);
		    System.out.println("PLEASE SELECT ANYONE OF THE OPTION GIVEN BELOW");
   			System.out.println("\n PRESS 1 : To see your details"+
		                       "\n PRESS 2 : To view items"+
   					           "\n PRESS 3 : To buy items"+
		                       "\n PRESS 4 : To recieve bill"+
		                       "\n PRESS 5 : To add money to the wallet"+
   					           "\n PRESS 6 : To pay cash "+
		                       "\n PRESS 7 : To view order"+
   					           "\n PRESS 8 : To return order"+
   					           "\n PRESS 9 : EXIT ");
		
			
			boolean empexit=false;
			
			while(!empexit) {
				System.out.println("Enter your choice");
				int empcommand=cst.nextInt();
				switch(empcommand) {
				case 1:
					viewDetails(i);
					break;
				case 2:
					viewItems();					
					break;
				case 3:
					OrderItems(i);
					
					break;
				case 4:
					recievebill(CompanyLogin.getC().get(i).getCustid());
					break;
				case 5:
					addWalletmoney(CompanyLogin.getC().get(i));
					break;
				case 6:
					paymoney(i);
					
					break;
				case 7:
					viewOrderStatus(i);
					break;
				case 8:
				   returnOrder(i);
				   break;
				case 9:
				empexit=true;
				System.out.println("You have exited the customer Login");
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
    public void viewDetails(int identification) {
    	System.out.println("\n your details are"+
                           "\n Name              -"+CompanyLogin.getC().get(identification).custName+
    			           "\n Email id          -"+CompanyLogin.getC().get(identification).email+
                           "\n Wallet Money      -"+CompanyLogin.getC().get(identification).getCustwallet()+
    			           "\n Purchase Points   -"+CompanyLogin.getC().get(identification).purchasepoints);
    }
 
   Order zz=new Order();
    public void OrderItems(int identification) {
    	System.out.println("enter the id of the item");
    	int idd=cst.nextInt();
        System.out.println("enter the quantity of item you want to order");
        int qty=cst.nextInt();
        for(int i=0;i<Eadministrator.getB().size();i++) {
        if(idd==Eadministrator.getB().get(i).itemid) {
        	if(Eadministrator.getB().get(i).itemquantity>=qty) {
        		o.add(new Order((long)Math.round(Math.random()*1000),Eadministrator.getB().get(i).itemid,CompanyLogin.getC().get(identification).custid,Eadministrator.getB().get(i).itemname,qty,Eadministrator.getB().get(i).itemprice));
        		System.out.println("\n Thank you for ordering from Emart"+
        		                   "\n Have a nice day");
        		Eadministrator.getB().get(i).setItemquantity(-qty);
        	}
			else{
				System.out.println("the entered quantity is not available");
			}
        }
        else {
        	System.out.println("Sorry for the inconvnience either itemid is incorrect or the item is out of stock");
        }
        }
    }
    public void viewItems() {
    	for(int i=0;i<Eadministrator.getB().size();i++) {
    		System.out.println(   "\nItem id               :   "+Eadministrator.getB().get(i).itemid+
    				              "\nItem Name             :   "+Eadministrator.getB().get(i).itemname+
				                  "\nItem Price            :   "+Eadministrator.getB().get(i).itemprice+
				                  "\nItem quantity         :   "+Eadministrator.getB().get(i).itemquantity+
				                  "\nItem type             :   "+Eadministrator.getB().get(i).itemtype);

    	}
    }
  
    
    public void viewOrderStatus(int identification) {
    	if(o.size()>0){
		for(int i=0;i<o.size();i++){
        if(CompanyLogin.getC().get(identification).custid==o.get(identification).getOrdercustid()) {
    		System.out.println("\n Your Order details are as follows"+
                               "\n Custid             - "+o.get(i).getOrdercustid()+
                               "\n Orderid            - "+o.get(i).getOrderId()+
                               "\n Itemid             - "+o.get(i).getOrderedItemid()+
                               "\n QuantityOrdered    - "+o.get(i).getOrderquantity()+
                               "\n Amount             - "+o.get(i).getOrderedprice()+
    		                   "\n Payment Status     - "+o.get(i).getPaymentstatus()+
    		                   "\n Delivery Status    - "+o.get(i).getDeliverystatus());
    	}
        
    	}
	}
	else{
		System.out.println("You havent ordered anything");
	}
    }

  
     public int addWalletmoney(int identification) {
    	int cashholder=0;
    	System.out.println("Please enter the money you want to add");
    	cashholder=cst.nextInt();
    	String s="yes";
    	
    	System.out.println("Please confirm ");
    	System.out.println("\n Type yes to proceed"+
    	                   "\n Type no to terminate");
    	String check=cst.nextLine();
    	if(check.equalsIgnoreCase(s)) {
    		return cashholder; 
    	}
    	else {
    		return 0;
    	}
    public void returnOrder(int identification) {
    	System.out.println("enter the itemid");
    	long a=cst.nextLong();
    	System.out.println("enter the orderid");
    	long b=cst.nextLong();
		System.out.println("Enter the quantity you want return");
		int c=cst.nextInt();
    	System.out.println("\n Please select your options"+
    	                   "\n Type yes to continue"+
    			           "\n Type no to terminate");
    	cst.nextLine();
    	String checker=cst.nextLine();
		
    	if(checker.equalsIgnoreCase("yes")) {
    		for(int j=0;j<o.size();j++){
				if(o.get(j).getOrderedItemid()==a&&o.get(j).getOrderId()==b&&o.get(j).getOrderquantity()>=c){
				                   if(c==o.get(j).getOrderquantity()){
									for(int i=0;i<Eadministrator.getB().size();i++){
										if(o.get(j).getOrderedItemid()==Eadministrator.getB().get(i).getItemid()){

											Eadministrator.getB().get(i).setItemquantity(c); 
											o.remove(j);
										}
							        }   
								    }
									else if(c<o.get(j).getOrderquantity()){
										for(int k=0;k<Eadministrator.getB().size();k++){
                                            if(o.get(j).getOrderedItemid()==Eadministrator.getB().get(k).getItemid()){
												Eadministrator.getB().get(k).setItemquantity(c);
												o.get(j).setOrderquantity(-c);
											}
										}
									}
				}
			}
	    }
		
    	
    	else {
    		System.out.println("You have terminated the process");
    	}
    	
    }


    public void recievebill(long identification) {
    	
    	if(Employee.getNormal().size()>0||Employee.getRegular().size()>0) {
    		for(int i=0;i<Employee.getNormal().size();i++) {
        		if(identification==Employee.getNormal().get(i).getBcustid()) {
        			nstore=Employee.getNormal().get(i).getBcustid();
        			System.out.println("\n Date - "+Employee.getNormal().get(i).getBilldate()+"/"+Employee.getNormal().get(i).getBillmonth()+"/"+Employee.getNormal().get(i).getBillyear()+
					           "\n Name        - "+Employee.getNormal().get(i).getBcustname()+
					           "\n Custid      - "+Employee.getNormal().get(i).getBcustid()+
					           "\n Orderid     - "+Employee.getNormal().get(i).getOrderid()+
					           "\n Totalcash   - "+Employee.getNormal().get(i).getOrderPrice());
        		}
        		  }
    		for(int i=0;i<Employee.getNp().size();i++) {
    		if(nstore==Employee.getNp().get(i).getPcustid()) {
    			System.out.println("The Grand total is : "+Employee.getNp().get(i).getPay());
    			
    		}}
        		
        		
    		 for(int j=0;j<Employee.getRegular().size();j++) {
            		if(identification==Employee.getRegular().get(j).getBcustid()) {
            			rstore=Employee.getRegular().get(j).getBcustid();
            			System.out.println("\n Date      - "+Employee.getRegular().get(j).getBilldate()+"/"+Employee.getNormal().get(j).getBillmonth()+"/"+Employee.getNormal().get(j).getBillyear()+
				                   "\n Name              - "+Employee.getRegular().get(j).getBcustname()+
				                   "\n Custid            - "+Employee.getRegular().get(j).getBcustid()+
				                   "\n Orderid           - "+Employee.getRegular().get(j).getOrderid()+
				                   "\n Discount offered  - "+"10%"+
				                   "\n Grandtotal        - "+Employee.getRegular().get(j).getOrderPrice());
            			
            		}
        		}
    		 for(int i=0;i<Employee.getRp().size();i++) {
    	    		if(rstore==Employee.getRp().get(i).getPcustid()) {
    	    			System.out.println("The Grand total is : "+Employee.getRp().get(i).getPay());
    	    			
    	    		}}
    		
    		}
    	
    	else {
    		System.out.println("You have not ordered anything to get a bill");
    	}
    	
    }
	

	
    public  static int sumCash(long l) {
    	int casher=0;
    
    	for(int i=0;i<o.size();i++) {
    		if(l==o.get(i).getOrdercustid()) {
    			casher=casher+o.get(i).getOrderedprice()*o.get(i).getOrderquantity();
    		}
    	}
    	return casher;
    	
    }
    public  void paymoney(int identification) {
    	for(int i=0;i<Employee.getNp().size();i++) {
    	if(CompanyLogin.getC().get(identification).getCustid()==Employee.getNp().get(i).getPcustid()) {
    	System.out.println("The amount to be made : "+Employee.getNp().get(i).getPay());
    	System.out.println("\n Type yes to continue"+
    	                    "\n Type no to terminate ");
    	String check="yes";
		cst.nextLine();
    	String con=cst.nextLine();
		if(check.equalsIgnoreCase(con)){

		if(Employee.getNp().get(i).getPay()<=CompanyLogin.getC().get(identification).getCustwallet()){

		 CompanyLogin.getC().get(identification).setCustwallet(-Employee.getNp().get(i).getPay());
		  if(Employee.getNp().get(i).getPay()>300){
			  int points=Employee.getNp().get(i).getPay()/300;
			  CompanyLogin.getC().get(identification).setPurchasepoints(points);
			  System.out.println("You have earned "+CompanyLogin.getC().get(identification).getPurchasepoints());
		  }
		 Employee.getNp().get(i).setPay(0);


		}
		else{

			System.out.println("insufficient balance");
			System.out.println("Please check your wallet");
		}
		
		}
		
		
	}
	else{
		
			System.out.println("You have terminated the process");
	
	}
}
for(int i=0;i<Employee.getRp().size();i++) {
	if(CompanyLogin.getC().get(identification).getCustid()==Employee.getRp().get(i).getPcustid()) {
	System.out.println("The amount to be made : "+Employee.getRp().get(i).getPay());
	System.out.println("\n Type yes to continue"+
						"\n Type no to terminate ");
	String check="yes";
	cst.nextLine();
	String con=cst.nextLine();
	if(check.equalsIgnoreCase(con)){

	if(Employee.getRp().get(i).getPay()<=CompanyLogin.getC().get(identification).getCustwallet()){

	 CompanyLogin.getC().get(identification).setCustwallet(-Employee.getRp().get(i).getPay());
	  if(Employee.getRp().get(i).getPay()>300){
		  int points=Employee.getRp().get(i).getPay()/300;
		  CompanyLogin.getC().get(identification).setPurchasepoints(points);
		  System.out.println("You have earned "+CompanyLogin.getC().get(identification).getPurchasepoints());
	  }
	 Employee.getRp().get(i).setPay(0);


	}
	else{

		System.out.println("insufficient balance");
		System.out.println("Please check your wallet");
	}
	
	}
	
	
}
else{
	
		System.out.println("You have terminated the process");

}
}

}
}
