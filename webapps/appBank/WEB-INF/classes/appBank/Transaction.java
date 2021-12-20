package appBank;

import java.util.*;

public class Transaction{
	//stores transaction
	int acctNo,amt,balance,transID;
	String transType;
	Transaction(int acctNo,int transID,String transType,int amt,int balance)
	{
		this.acctNo = acctNo;
		this.amt = amt;
		this.transType = transType;
		this.balance = balance;
		this.transID = transID;
	}
}