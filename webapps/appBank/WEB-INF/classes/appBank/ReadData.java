package appBank;

import java.sql.*;

class ReadData{
	public static boolean searchUser(int custID,String password){  //searches user on database 
		try{
            int acctNo,balance;
            String name;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appBank", "sample", "sample");


            String query = "select * from Customer WHERE CustID = ? AND Epassword = ? ";

            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1,custID);
            preparedStmt.setString(2,password);
            ResultSet rs = preparedStmt.executeQuery();
            rs.next();			//cursor is placed before the word,
        	acctNo = rs.getInt(2);
        	name = rs.getString(3);
            balance = rs.getInt(5);
            

            Customer ctmr = new Customer(custID,name,acctNo,balance,password);
            Globals.ctmr = ctmr;


            return true;
            
        }
        catch(Exception ex){
        	return false;
        }
	}

    public static void readTransact(){      //reads transaction from database and stores in customer.transactDetails
        try{

        int acctNo,amt,balance;
        String transType;
        int transID = 1;
        Customer ctmr = Globals.ctmr;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appBank", "sample", "sample");
        String query = "SELECT * FROM Transaction";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        ResultSet rs = preparedStmt.executeQuery();
        while(rs.next()){
            acctNo = rs.getInt(1);
            transID = rs.getInt(2);
            transType = rs.getString(3);
            amt = rs.getInt(4);
            balance = rs.getInt(5);

            Transaction transaction = new Transaction(acctNo,transID,transType,amt,balance);
            ctmr.transactDetails.add(transaction);
        }
        ctmr.transctNum = transID+1;
        }
        catch(Exception e){
            //have to put some exception handler like log in a file
        }
    }
}