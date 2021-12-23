package appBank;

import java.util.*;

public class Customer{
	
	int custID,acctNo,balance,transctNum;
	String name,password;
	List<Transaction> transactDetails = new ArrayList<>(); 							//transaction details

	Customer () {						//to set Globals.ctmr into null

	}

	Customer(int custID,String name,int acctNo,int balance,String password){
		this.custID = custID;
		this.acctNo = acctNo;
		this.name = name;
		this.balance = balance;
		this.password= password;
		this.transctNum = 1;
	}


}