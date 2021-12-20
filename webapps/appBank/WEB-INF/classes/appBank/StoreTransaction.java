package appBank;


public class StoreTransaction{
	public static void store(Customer ctmr,String transType,int amt){
		Transaction detailForCustomer = new Transaction(ctmr.acctNo,transType,amt,ctmr.balance);
		ctmr.transctNum++;												//increase transaction num
		ctmr.transactDetails.add(detailForCustomer);

		DataStore.writeTransaction(detailForCustomer);
		//storing in database

	}
}