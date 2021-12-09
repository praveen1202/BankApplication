package applicationBank;


public class StoreTransaction{
	public static void store(Customer ctmr,String transType,int amt){
		Transaction detailForCustomer = new Transaction(ctmr.transctNum,transType,amt,ctmr.balance);
		ctmr.transctNum++;												//increase transaction num
		ctmr.transactDetails.add(detailForCustomer);

		FileHandling.writeTransaction(ctmr.custID,detailForCustomer);
	}
}