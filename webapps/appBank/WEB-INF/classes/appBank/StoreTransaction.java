package appBank;


public class StoreTransaction{

	public static void store(Customer ctmr,String transType,int amt) throws Exception{

		Transaction detailForCustomer = new Transaction(ctmr.acctNo,ctmr.transctNum,transType,amt,ctmr.balance);											//increase transaction num
		ctmr.transctNum++;
		ctmr.transactDetails.add(detailForCustomer);

		try {
			DataStore.writeTransaction(detailForCustomer);		//writes the transaction into the database			
		}
		catch(Exception e){
			throw new Exception();
		}
	}
	
}