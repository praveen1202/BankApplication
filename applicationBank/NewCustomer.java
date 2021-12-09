package applicationBank;

public class NewCustomer{
	static int acctNo = 20000;
	static int custID = 100;
	static int balance = 10000;

	public static Customer createProfile(String name,String encryptedPwd){  //comes from authentication
		Customer ctmr = new Customer(custID,name,acctNo,balance,encryptedPwd);
		acctNo += 100;
		custID += 10;
		
		FileHandling.writeFile(ctmr);
		return ctmr;
	}
}