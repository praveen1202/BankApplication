package appBank;

import java.sql.*;
public class DataStore{ 
	public static void writeTransaction(Transaction transactionDetails){   //writes transaction into the database
		try{

			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appBank", "sample", "sample");
            

            String query = "INSERT INTO Transaction(AcctNo,Amount,TransID,TransType,Balance)" + "VALUES (?,?,?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            // String query2 = "INSERT INTO "
            preparedStmt.setInt(1,transactionDetails.acctNo);
            preparedStmt.setInt(2,transactionDetails.amt);
            preparedStmt.setInt(3,transactionDetails.transID);		//need to change the transact Num value --temporarily set to global
            preparedStmt.setString(4,transactionDetails.transType);
            preparedStmt.setInt(5,transactionDetails.balance);

            preparedStmt.execute(); //executes the query statement

            String query2 = "UPDATE Customer SET Balance = ? WHERE AcctNo = ?";
            PreparedStatement preparedStmt2 = con.prepareStatement(query2);
            preparedStmt2.setInt(1,transactionDetails.balance);
            preparedStmt2.setInt(2,transactionDetails.acctNo);

            preparedStmt2.execute();
            
		}catch(ClassNotFoundException | SQLException e){
			System.err.println("Got an exception!");
      		System.err.println(e.getMessage());
		}
	}

    public static void createUser(String name,String password){

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appBank", "sample", "sample");

            String query = "INSERT INTO Customer (CustID,Name,Epassword,Balance) VALUES (?,?,?,100)";
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setInt(1,Globals.custID);
            stmt.setString(2,name);
            stmt.setString(3,password);
            stmt.execute();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}