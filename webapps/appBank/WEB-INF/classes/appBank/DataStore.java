package appBank;

import java.sql.*;
public class DataStore{
	public static void writeTransaction(Transaction transactionDetails){
		try{
			// Customer ctmr = Globals.ctmr;
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
}