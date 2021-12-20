package appBank;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*; 
import jakarta.servlet.*;
import java.io.*;
import java.util.*;


@WebServlet("/JSP/auth")
// have to add annotation or configure it in XML

public class Authenticate extends HttpServlet{
    
    // public static Customer[] arr = new Customer[10];
    // static {
    //     arr[0] = new Customer(11,"praveen",110,10000,"12345");
    //     arr[1] = new Customer(12,"praveen",111,20000,"12346");
    // }


    @Override
    public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{


        int custID = Integer.parseInt(req.getParameter("custID").toString());
        // String name = req.getParameter("name").toString();
        String password = req.getParameter("password").toString();
        PrintWriter out = res.getWriter();
        
        // ReadData.searchUser(custID,password);
        // out.println("name : " + Globals.ctmr.name + "password : " + Globals.ctmr.encryptedPwd + "Balance : " + Globals.ctmr.balance + "Account No : " + Globals.ctmr.acctNo);

        if(ReadData.searchUser(custID,password)){
            ReadData.readTransact();        //read and stores transactionDetails
            HttpSession session = req.getSession();
            session.setAttribute("name",Globals.ctmr.name);
            res.sendRedirect("features.jsp");
        }
        else {
            res.sendRedirect("login.jsp");
        }



        // for(int i = 0; i < arr.length; i++){
        //     out.println(arr[i].name+ " " +arr[i].encryptedPwd+ " " + arr[i].balance);
        // }

        // out.println(name + " " + password);
        // // out.println(arr[0].name.equals(name));
        // try{
        //     int flag = 0;
        // for(int i = 0; i < 2;i++){

        //     if(arr[i].name.equals(name) && arr[i].encryptedPwd.equals(password)){

        //         HttpSession session = req.getSession();
        //         Globals.ctmr = arr[i];
        //         session.setAttribute("name",name);
        //         res.sendRedirect("features.jsp");
        //     }
        // }
        // if (flag == 0){
        //     out.println("Invalid Username/password");
        // }
        // } catch(Exception e){
        //     out.println(e);
        // }


        
        // req.setAttribute("lab",name);
    	
    	// RequestDispatcher rd = req.getRequestDispatcher("features.jsp");
    	// rd.forward(req,res);
    }
}
