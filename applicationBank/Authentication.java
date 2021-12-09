package applicationBank; 

import java.util.*;

public class Authentication{
    


	public static void authenticate(){             //showing error dec 7 12:00pm

        Scanner sc = Globals.sc;

		System.out.println("Authentication Required!");
        System.out.println("Enter id: ");
        int id = sc.nextInt();
        System.out.println("Enter Password: ");
        String passwd = sc.next();

        if(Globals.cstmrList.containsKey(id)){                 //checks if id is present in database
            Customer ctmr = Globals.cstmrList.get(id);

            String encryptedPwd = Encryption.encrypt(passwd);      //calling Ecrypt class

            if(ctmr.encryptedPwd.equals(encryptedPwd)){
                Features feature = new Features(ctmr);
                feature.facilities();                   //Calling Facilities
            }
            else{
                System.out.println("Invalid Password");
            }
        }         
        else{
            System.out.println("Invalid Id");
        }

    }

    public static void newUser(){
        //create newUser
        Scanner sc = Globals.sc;

        System.out.println("Enter Name:");
        String name = sc.next();

        String encryptedPwd = PasswordValidation.validatePwd();

        if (encryptedPwd != ""){
            Customer ctmr = NewCustomer.createProfile(name,encryptedPwd);
            //store into customer
            Features feature = new Features(ctmr);
            feature.facilities();

        }
        else{
            System.out.println("Atleast 2 Capital Letters,2 small letters and 2 numbers should be present in the password!");
        }
        
        
    }
}