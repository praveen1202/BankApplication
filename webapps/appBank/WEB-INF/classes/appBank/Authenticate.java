package appBank;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*; 
import jakarta.servlet.*;
import java.io.*;
import java.util.*;


@WebServlet("/JSP/auth")
// have to add annotation or configure it in XML

public class Authenticate extends HttpServlet{      //request comes from login.jsp
    

    @Override
    public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{


        int custID = Integer.parseInt(req.getParameter("custID").toString());       
        String password = req.getParameter("password").toString();
        PrintWriter out = res.getWriter();
        

        if(ReadData.searchUser(custID,password)){       //passes the credentials to readData.java
            ReadData.readTransact();        //read and stores transactionDetails
            HttpSession session = req.getSession();
            session.setAttribute("name",Globals.ctmr.name);
            res.sendRedirect("features.jsp");       //redirects to features.jsp
        }
        else {
            res.sendRedirect("login.jsp");
        }
    }
}
