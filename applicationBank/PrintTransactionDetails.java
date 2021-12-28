package applicationBank;

import java.util.*;

public class PrintTransactionDetails {

	Customer ctmr;

	PrintTransactionDetails(Customer ctmr){
		this.ctmr = ctmr;
	}

	Customer getCustomer(){
		return this.ctmr;
	}

	public void print(){

		Customer ctmr = getCustomer();
		System.out.println();
		System.out.println("\t\tAccount Statement");
		System.out.println("\t\t Name : " + ctmr.name);
		System.out.println("\t\tAccount No : " + ctmr.acctNo);
		System.out.println("\t\tCustomer Id : " + ctmr.custID);
		System.out.println("TransID\tTransType\t\t\tAmount\tBalance");
		int id = 1;

		
		
		for(Transaction iter : ctmr.transactDetails){
			System.out.println(id++ + "\t" + iter.mode + "\t\t\t" + iter.amt + "\t" + iter.balance);  //have to recheck
		}

	}
}