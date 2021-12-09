package applicationBank; 

import java.util.*;

public class Features {
	static int flag = 0;

	Customer ctmr;
	Scanner sc = Globals.sc;
	Features(Customer ctmr){
		this.ctmr = ctmr;
	}

	Customer getCustomer(){
		return this.ctmr;
	}

	public void facilities(){

		Customer ctmr = getCustomer();
		ReadData entry = new ReadData(ctmr);
		while(true){
			System.out.println();
			System.out.println("1 Atmwithdrawal");
			System.out.println("2 AtmCashDeposit");
			System.out.println("3 MoneyTransfer");
			System.out.println("Sign Out");

			int choice = sc.nextInt();
			
			switch(choice){
				case 1:
					entry.withDraw();
					break;
				case 2:
					entry.deposit();
					break;
				case 3:
					entry.neft();
					break;
				default:
					flag = 1;
					System.out.println("Signing Out");
					break;

			}
			if (flag == 1) {
				break;
			}

		}
	}
}