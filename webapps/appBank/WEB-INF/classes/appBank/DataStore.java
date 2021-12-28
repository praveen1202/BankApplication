package appBank;

import java.sql.*;
public class DataStore{ 
	public static void writeTransaction(Transaction transactionDetails) throws Exception{   //writes transaction into the database
		try{

			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appBank", "sample", "sample");
            

            String query = "INSERT INTO Transaction(AcctNo,Amount,TransID,TransType,Balance)" + "VALUES (?,?,?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1,transactionDetails.acctNo);
            preparedStmt.setInt(2,transactionDetails.amt);
            preparedStmt.setInt(3,transactionDetails.transID);		
            preparedStmt.setString(4,transactionDetails.transType);
            preparedStmt.setInt(5,transactionDetails.balance);

            preparedStmt.execute(); //executes the query statement

            String query2 = "UPDATE Customer SET Balance = ? WHERE AcctNo = ?";
            PreparedStatement preparedStmt2 = con.prepareStatement(query2);
            preparedStmt2.setInt(1,transactionDetails.balance);
            preparedStmt2.setInt(2,transactionDetails.acctNo);

            preparedStmt2.execute();
            
		}catch(ClassNotFoundException | SQLException e){

			throw new Exception(); //throws error if user not found in database
		}
	}

    public static void writeTransaction(int acctNo) throws Exception{
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appBank", "sample", "sample");
            

            String query = "INSERT INTO Transaction(AcctNo,Amount,TransID,TransType,Balance)" + "VALUES (?,?,?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1,acctNo);
            preparedStmt.setInt(2,10000);
            preparedStmt.setInt(3,1);      
            preparedStmt.setString(4,"Opening ");
            preparedStmt.setInt(5,10000);

            preparedStmt.execute(); //executes the query statement

            String query2 = "UPDATE Customer SET Balance = ? WHERE AcctNo = ?";
            PreparedStatement preparedStmt2 = con.prepareStatement(query2);
            preparedStmt2.setInt(1,10000);
            preparedStmt2.setInt(2,acctNo);

            preparedStmt2.execute();
            
        } 
        catch(ClassNotFoundException | SQLException e){

            throw new Exception(); //throws error if user not found in database
        }
    }

    public static void createUser(int custID,String name,String password) throws Exception{

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appBank", "sample", "sample");

            String query = "INSERT INTO Customer (CustID,Name,Epassword,Balance) VALUES (?,?,?,10000)";
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setInt(1,custID);
            stmt.setString(2,name);
            stmt.setString(3,password);
            stmt.execute();

        }
        catch(Exception e){
            throw new Exception();
        }
    }
}