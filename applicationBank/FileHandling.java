package applicationBank;

import java.io.*;
import java.util.*;

public class FileHandling{
											
	public static void readFile(){										//for intial customers

		try{
	            FileReader file = new FileReader("/home/local/ZOHOCORP/praveen-pt4650/Documents/BankApplication/database/db_text.txt");
	            BufferedReader sfile = new BufferedReader(file);
	     
	            String currLine;

	            
	            while((currLine = sfile.readLine()) != null){

                    Customer ctmr = new Customer(currLine.split(" "));
                    Globals.cstmrList.put(ctmr.custID,ctmr);
                
	            }
	        }
	         
        catch(IOException except) {except.printStackTrace();}
    }


    public static void writeTransaction(int custID,Transaction detail){			//comes from storeTransaction class,BankCharges

    	try{

        	FileWriter file;
        	file = new FileWriter("transactionDetails/custID"+custID+".txt",true);
        	BufferedWriter write = new BufferedWriter(file);

			write.write(detail.tID + "," + detail.mode + "," + detail.amt + "," + detail.balance);
            write.newLine();
            write.close();
    	}
    	catch (IOException except){
            except.printStackTrace();
        }
    }

    public static void readTransaction(Customer ctmr){							//comes for printTransaction Details
    	try{
	            FileReader file = new FileReader("/home/local/ZOHOCORP/praveen-pt4650/Documents/BankApplication/transactionDetails/custID"+ctmr.custID+".txt");
	            	BufferedReader sfile = new BufferedReader(file);
	     
		            String currLine;

		            
		          	
		            while((currLine = sfile.readLine()) != null){

	                    Transaction transactionDetails = new Transaction(currLine.split(","));
	                    ctmr.transactDetails.add(transactionDetails);
	                    
		            }
	            
	        }
	         
        catch(IOException except) {except.printStackTrace();}

    }

    public static boolean checkIfFileExists(int custID){
    	File file = new File("/home/local/ZOHOCORP/praveen-pt4650/Documents/BankApplication/database/transactionDetails/custID"+custID+".txt");
    	if(file.exists()){
    		return true;
    	}
    	return false;
    }

    public static void writeFile(Customer ctmr){		//write new user into file
    	try{

        	FileWriter file;
        	file = new FileWriter("database/db_text.txt",true);
        	BufferedWriter write = new BufferedWriter(file);
			write.write(ctmr.custID+" "+ctmr.acctNo+" "+ctmr.name+" "+ctmr.balance+" "+ctmr.encryptedPwd);
			write.newLine();
            write.close();
    	}
    	catch (IOException except){
            except.printStackTrace();
        }
    }
}