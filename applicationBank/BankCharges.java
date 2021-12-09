package applicationBank;

public class BankCharges{
	public static void operationalCharges(Customer ctmr){

		AtmFacilities.debitAmt(ctmr,10);
		Transaction details = new Transaction(0,"OprtionlCharges",10,ctmr.balance);
		ctmr.transactDetails.add(details);

		FileHandling.writeTransaction(ctmr.custID,details);
		
		
	}

	public static void maintenenceCharges(Customer ctmr){
		
		AtmFacilities.debitAmt(ctmr,100);
		Transaction details = new Transaction(0,"MaintenenceCharges",100,ctmr.balance);
		ctmr.transactDetails.add(details);
		
		FileHandling.writeTransaction(ctmr.custID,details);
	}
}