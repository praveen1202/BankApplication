package applicationBank; 

import java.util.*;

public class Bank{

	static int flag;
	
	public static void logIn(){

		Scanner sc = Globals.sc;

		FileHandling.readFile();	//stores file of customers stored in txt file(have to write file also())

		while(true){
			System.out.println();
			System.out.println("1 Log In:");
			System.out.println("2 New User");
			System.out.println("Exit");
			int choice = sc.nextInt();
			switch(choice){
				case 1:
				Authentication.authenticate();
				break;
				case 2:
				Authentication.newUser();
				break;
				default:
				flag = 1;
				break;
			}
			if(flag == 1) {
				break;
			}
		}

	}
}