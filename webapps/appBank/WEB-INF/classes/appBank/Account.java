package appBank;

import java.util.*;

public class Account{

	public static boolean debitAmt(Customer ctmr,int amt){

		if(ctmr.balance - amt >= 1000 && amt > 0){
			ctmr.balance -= amt;
		}
		else{
			return false;
		}
		return true;
	}

	public static boolean creditAmt(Customer ctmr,int amt){

		if(amt > 0){
			ctmr.balance += amt;
		}
		else{
			return false;
		}
		return true;
	}
	
}