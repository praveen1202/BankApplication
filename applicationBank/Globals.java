package applicationBank;

import java.util.*;

public class Globals{
	
	public static Scanner sc = new Scanner(System.in);
	public static HashMap<Integer,Customer> cstmrList = new HashMap<Integer,Customer>();		//hashmap for customer

	public static boolean checkID(int Id){
		if(cstmrList.containsKey(Id)){
			return true;
		}
		return false;
	}  

}