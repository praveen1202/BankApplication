package appBank;

import java.sql.*;

class ReadData{
	public static boolean searchUser(int custID,String password){
		try{
            int acctNo;
            int balance = 10000;
            String name;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appBank", "sample", "sample");


            String query = "select * from Customer WHERE CustID = ? AND Epassword = ? ";

            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1,custID);
            preparedStmt.setString(2,password);
            ResultSet rs = preparedStmt.executeQuery();
            rs.next();			//this is usually before fist result
        	acctNo = rs.getInt(2);
        	name = rs.getString(3);


            String query2 = "SELECT Balance FROM Balance WHERE AcctNo= ? ";
            PreparedStatement preparedStmt1 = con.prepareStatement(query2);

            preparedStmt1.setInt(1,acctNo);
            ResultSet rs1 = preparedStmt1.executeQuery();
            if(rs1.next()){
            	balance = rs1.getInt(1);
            }
            // rs1.next();
            

            Customer ctmr = new Customer(custID,name,acctNo,balance,password);
            Globals.ctmr = ctmr;


            return true;
            
        }
        catch(Exception ex){
        	// String e = ex.toString();
         //    return e;
        	return false;
        }
	}
}