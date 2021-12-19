package appBank;

import java.util.*;

public class Customer{
	
	int custID,acctNo,balance,transctNum;
	String name,encryptedPwd;
	// List<Transaction> transactDetails = new ArrayList<>(); 							//transaction details
	boolean readTransactFlag;
	
	// Customer(String[] arr){
	// 	this.custID = Integer.parseInt(arr[0].trim());						//parseInt method is used to convert string to int
	// 	this.acctNo = Integer.parseInt(arr[1].trim());
	// 	this.name = arr[2];
	// 	this.balance = Integer.parseInt(arr[3].trim());
	// 	this.encryptedPwd= arr[4];
	// 	this.transctNum = 1;
	// 	this.readTransactFlag = FileHandling.checkIfFileExists(this.custID);

	// }

	Customer(int custID,String name,int acctNo,int balance,String encryptedPwd){
		this.custID = custID;
		this.acctNo = acctNo;
		this.name = name;
		this.balance = balance;
		this.encryptedPwd = encryptedPwd;
		this.readTransactFlag = false;
	}


}