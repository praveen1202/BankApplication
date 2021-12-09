package applicationBank;

import java.util.*;

public class MoneyTransfer{

	Customer ctmr,recipient;
	Scanner sc = Globals.sc;
	int amt;

	MoneyTransfer(Customer ctmr,Customer recipient,int amt){
		this.ctmr = ctmr;
		this.recipient = recipient;
		this.amt = amt;
	}

	public Customer getCustomer(){
		return this.ctmr;
	}

	public Customer getRecipient(){
		return this.recipient;
	}

	public int getAmt(){
		return this.amt = amt;
	}

	public void transfer(){

		Customer ctmr = getCustomer();
		Customer recipient = getRecipient();
		int amt = getAmt();

		Account.debitAmt(ctmr,amt);

		Account.creditAmt(recipient,amt);
	}
}