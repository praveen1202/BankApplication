package applicationBank;

import java.util.*;

public class Transaction{
	//stores transaction
	int tID,amt,balance;
	String mode;
	Transaction(int tID,String mode,int amt,int balance)
	{
		this.tID = tID;
		this.amt = amt;
		this.mode = mode;
		this.balance = balance;
	}

	Transaction(String mode,int amt,int balance){
		this.amt = amt;
		this.mode = mode;
		this.balance = balance;
	}
	
	Transaction(String[] arr){
		this.tID = Integer.parseInt(arr[0].trim());
		this.amt = Integer.parseInt(arr[2].trim());
		this.mode = arr[1];
		this.balance = Integer.parseInt(arr[3].trim());
	}
}