package appBank;

import java.sql.*;
public class DataStore{
	public static void writeTransaction(Transaction transactionDetails){
		try{
			// Customer ctmr = Globals.ctmr;
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appBank", "sample", "sample");
            

            String query = "INSERT INTO Transaction(AcctNo,Amount,TransID,TransType)" + "VALUES (?,?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            // String query2 = "INSERT INTO "
            preparedStmt.setInt(1,transactionDetails.acctNo);
            preparedStmt.setInt(2,transactionDetails.amt);
            preparedStmt.setInt(3,Globals.transactNum);		//need to change the transact Num value --temporarily set to global
            preparedStmt.setString(4,transactionDetails.mode);

            preparedStmt.execute(); //executes the query statement
		}catch(ClassNotFoundException | SQLException e){
			System.err.println("Got an exception!");
      		System.err.println(e.getMessage());
		}
	}
}