package appBank;


public class StoreTransaction{
	public static void store(Customer ctmr,String transType,int amt){
		Transaction detailForCustomer = new Transaction(ctmr.acctNo,ctmr.transctNum,transType,amt,ctmr.balance);											//increase transaction num
		ctmr.transctNum++;
		ctmr.transactDetails.add(detailForCustomer);

		DataStore.writeTransaction(detailForCustomer);
		//storing in database

	}
}