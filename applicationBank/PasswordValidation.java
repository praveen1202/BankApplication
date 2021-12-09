package applicationBank;

import java.util.*;
import java.util.regex.*;


public class PasswordValidation{			

	public static String validatePwd() {		//comes from authentication class

		Scanner sc = Globals.sc;

		System.out.println("Enter Password: ");
		String passwd = sc.next();
		System.out.println("Re-type Password: ");
		String rePasswd = sc.next();
		if(passwd.equals(rePasswd)){
			Pattern pattern = Pattern.compile(".*(?=(.*[a-z]){2})(?=(.*\\d){2})(?=(.*[A-Z]){2})");
			Matcher matcher = pattern.matcher(passwd);
			boolean match = matcher.find();
			if(match){
				return Encryption.encrypt(passwd);
			}
		}
		return "";
	}
}