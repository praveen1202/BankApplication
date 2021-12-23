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

    public static void searchUser(){        //for increasing the custID so that it remains unique
        try{
            int custID = 0;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appBank", "sample", "sample");

            String query = "select * from Customer";

            PreparedStatement preparedStmt = con.prepareStatement(query);


            ResultSet rs = preparedStmt.executeQuery();
            while(rs.next()){          //cursor is placed before the word,
                custID = rs.getInt(1);
            }
            Globals.custID = custID + 1;
        }  catch(Exception e){
            System.out.println(e);
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
        String query = "SELECT * FROM Transaction WHERE AcctNo = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1,Globals.ctmr.acctNo);
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
            System.out.println(e);
            //have to put some exception handler like log in a file
        }
    }

    public static void storeUser(){
        try{
            int acctNo,balance,custID;
            String name,password;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appBank", "sample", "sample");
            String query = "SELECT * FROM Customer WHERE CustID = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1,Globals.custID++);

            ResultSet rs = stmt.executeQuery();
            rs.next();
            custID = rs.getInt(1);
            acctNo = rs.getInt(2);
            name = rs.getString(3);
            password = rs.getString(4);
            balance = rs.getInt(5);

            Customer ctmr = new Customer(custID,name,acctNo,balance,password);

            Globals.ctmr = ctmr;
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}