package appBank;

import java.sql.*;

class ReadData{
	public static Customer searchUser(int custID,String password){  //searches user on database 
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

            return ctmr;
            
        }
        catch(Exception ex){
        	return null;
        }
	}

    public static Customer searchUser(int acctNo) throws Exception{
        try{
            int custID,balance;
            String name;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appBank", "sample", "sample");
            String query = "SELECT * FROM Customer WHERE AcctNo = ?";
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setInt(1,acctNo);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            custID = rs.getInt(1);
            name = rs.getString(3);
            balance = rs.getInt(5);

            Customer recipient = new Customer(custID,acctNo,name,balance);
            // Globals.recipient = recipient;
            return recipient;
        }
        catch(Exception e){
            throw new Exception();
        }
    }

    public static int searchUser(){        //for increasing the custID so that it remains unique
        try{
            int custID = 0;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appBank", "sample", "sample");

            String query = "select MAX(CustID) from Customer";

            PreparedStatement preparedStmt = con.prepareStatement(query);


            ResultSet rs = preparedStmt.executeQuery();
            if(rs.next()){          //cursor is placed before the word,
                custID = rs.getInt(1);
            }
            return ++custID;
        }  
        catch(Exception e){
            return 1;
        }
    }


    public static void readTransact(Customer ctmr) throws Exception{      //reads transaction from database and stores in customer.transactDetails
        try{

        int acctNo,amt,balance;
        String transType;
        int transID = 1;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appBank", "sample", "sample");
        String query = "SELECT * FROM Transaction WHERE AcctNo = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1,ctmr.acctNo);
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
            throw new Exception();
        }
    }

    public static void getTransID(Customer recipient) throws Exception{      //gets the maximum of transID for recipient
        try{
            int transID;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appBank", "sample", "sample");
            String query = "SELECT MAX(TransID) FROM Transaction WHERE AcctNo = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1,recipient.acctNo);

            ResultSet rs = preparedStmt.executeQuery();
            if(rs.next()){
                recipient.transctNum = rs.getInt(1);
                recipient.transctNum++;

            }
        } 
        catch(Exception e){
            throw new Exception();
        }
    }



    public static Customer storeUser(int custID){
        try{
            int acctNo,balance;
            String name,password;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appBank", "sample", "sample");
            String query = "SELECT * FROM Customer WHERE CustID = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1,custID++);

            ResultSet rs = stmt.executeQuery();
            rs.next();
            custID = rs.getInt(1);
            acctNo = rs.getInt(2);
            name = rs.getString(3);
            password = rs.getString(4);
            balance = rs.getInt(5);

            Customer ctmr = new Customer(custID,name,acctNo,balance,password);

            return ctmr;

        } 
        catch (Exception e) {
            return null;
        }
    }
}