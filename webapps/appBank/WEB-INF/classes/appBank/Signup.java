package appBank;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*; 
import jakarta.servlet.*;
import java.io.*;
import java.util.*;


@WebServlet("/JSP/signup")
// have to add annotation or configure it in XML

public class Signup extends HttpServlet{      //request comes from login.jsp
    

    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{

        HttpSession session = req.getSession();
        String sessionID = req.getSession().getId();

        PrintWriter out = res.getWriter();
        int custID;
        String name,password1,password2;
        Customer ctmr;

        try {
            name = req.getParameter("name");
            password1 = req.getParameter("password1");
            password2 = req.getParameter("password2");

            if(name.equals("") || password1.equals("") || password2.equals("")){                    //have to throw exception for blankspaces 
                throw new Exception();
            }

            if(password2.equals(password1)){

                custID = ReadData.searchUser();      //appends custID so that it becomes unique

                DataStore.createUser(custID,name,password1);   //creates user and stores it in database and thorws exception if the name and password is null

                ctmr = ReadData.storeUser(custID); 

                if(ctmr != null){
                    DataStore.writeTransaction(ctmr.acctNo);    //writes opening balance into transaction database

                    ReadData.readTransact(ctmr);

                    Globals.cstmrList.put(sessionID,ctmr);
                    session.setAttribute("name",ctmr.name);
                    session.setAttribute("custID",ctmr.custID);
                    res.sendRedirect("features.jsp"); 
                }
                
            }
            else {
                req.setAttribute("message","Passwords Doesn't Match");
                req.getRequestDispatcher("signup.jsp").forward(req,res);
            }
        }
        catch(Exception e) {
            req.setAttribute("message","Invalid Entry! Try Again!");
            req.getRequestDispatcher("signup.jsp").forward(req,res);
        }
    }
}