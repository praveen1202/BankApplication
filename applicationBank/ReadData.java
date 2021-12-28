package applicationBank;

import java.util.*;

public class ReadData{
	Customer ctmr;

	ReadData(Customer ctmr){
		this.ctmr = ctmr;
	}

	Customer getCustomer(){
		return this.ctmr;
	}

	
	public void withDraw(){


		Scanner sc = Globals.sc;
		Customer ctmr = getCustomer();

		System.out.println("Enter Amount to Be Debited: ");
		int amt = sc.nextInt();



		
		boolean flag = Account.debitAmt(ctmr,amt);

		if(flag) {
			String transType = "Withdraw";

			StoreTransaction.store(ctmr,transType,amt);

			if(amt >= 5000){
				BankCharges.operationalCharges(ctmr);
			}
			if(ctmr.transctNum % 10 == 0){
				BankCharges.maintenenceCharges(ctmr);
			}

			PrintTransactionDetails printDetails = new PrintTransactionDetails(ctmr);		//prints transaction details
			printDetails.print();
		}

	}

	public void deposit(){

		Scanner sc = Globals.sc;
		Customer ctmr = getCustomer();

		System.out.println("Enter Amount to be Credited: ");
		int amt = sc.nextInt();
		
		boolean flag = Account.creditAmt(ctmr,amt);

		if(flag){

			String transType = "Deposit ";

			StoreTransaction.store(ctmr,transType,amt);


			if(amt >= 5000){
				BankCharges.operationalCharges(ctmr);
			}
			if(ctmr.transctNum % 10 == 0){
				BankCharges.maintenenceCharges(ctmr);
			}


			PrintTransactionDetails printDetails = new PrintTransactionDetails(ctmr);			//prints transaction details
			printDetails.print();
		}
	}

	public void neft(){

		Scanner sc = Globals.sc;
		Customer ctmr = getCustomer();

		System.out.println("Enter Customer ID of the recipient : ");
		int recipientID = sc.nextInt();

		if(recipientID != ctmr.custID){
			boolean check = Globals.checkID(recipientID);

			if(check){																				//checks if Id is registered as user 

				System.out.println("Enter Amount to Be Transfered : ");
				int amt = sc.nextInt();
				Customer recipient = Globals.cstmrList.get(recipientID);
				

				MoneyTransfer neftTransaction = new MoneyTransfer(ctmr,recipient,amt);
				neftTransaction.transfer();

				String transType = "Transferto" + recipient.acctNo;
				StoreTransaction.store(ctmr,transType,amt);

				transType = "TransferFrom" + ctmr.acctNo;
				StoreTransaction.store(recipient,transType,amt);
				

				

				if(amt >= 5000){
					BankCharges.operationalCharges(ctmr);
				}

				if(ctmr.transctNum % 10 == 0){
					BankCharges.maintenenceCharges(ctmr);
				}

				if(recipient.transctNum % 10 == 0){
					BankCharges.maintenenceCharges(recipient);
				}



				PrintTransactionDetails printDetails = new PrintTransactionDetails(ctmr);			//prints transaction details
				printDetails.print();

			}
			else{
				System.out.println("Invalid Customer ID!");
			}
		}
		else{
			System.out.println("Invalid Customer ID!");
		}

		
	}

}