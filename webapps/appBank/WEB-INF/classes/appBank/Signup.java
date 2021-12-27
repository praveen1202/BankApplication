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

        String name = req.getParameter("name");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");

        PrintWriter out = res.getWriter();

        if(password2.equals(password1)){
            int custID = ReadData.searchUser();      //appends custID so that it becomes unique
            DataStore.createUser(custID,name,password1);   //creates user and stores it in database
            //stores customer locally in Globals class

            Customer ctmr = ReadData.storeUser(custID);   
            Globals.cstmrList.put(sessionID,ctmr);
            session.setAttribute("name",ctmr.name);
            session.setAttribute("custID",ctmr.custID);
            res.sendRedirect("features.jsp"); 
        }
        else {
            out.println("Passwords Doesn't Match");
            res.sendRedirect("signup.jsp");          //have to find a way to display inside signup.jsp
        }
    }
}