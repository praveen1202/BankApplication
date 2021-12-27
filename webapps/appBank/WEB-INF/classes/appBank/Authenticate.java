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
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{


        int custID = Integer.parseInt(req.getParameter("custID").toString());       
        String password = req.getParameter("password").toString();
        // PrintWriter out = res.getWriter();
        
        Customer ctmr = ReadData.searchUser(custID,password);

        if (ctmr != null){
           
            HttpSession session = req.getSession();
            session.setAttribute("name",ctmr.name);
            session.setAttribute("custID",custID);
            String sessionID = req.getSession().getId();
            Globals.cstmrList.put(sessionID,ctmr);
            
            res.sendRedirect("features.jsp");
            // Customer ctmr1 = Globals.cstmrList.get(sessionID);
            // Globals.ctmr = ctmr1;
            ReadData.readTransact(ctmr); //take custID after finish editing        //read transaction details and stores it in local for display

        }

        // if(ReadData.searchUser(custID,password)){       //passes the credentials to readData.java
            // ReadData.readTransact();        //read and stores transactionDetails
            // HttpSession session = req.getSession();
            // session.setAttribute("name",Globals.ctmr.name);
            // session.setAttribute("custID",Globals.ctmr.custID);
            // String id = req.getSession().getId();
            // out.println(id);
            // req.getRequestDispatcher("features.jsp").include(req,res);
            // res.sendRedirect("features.jsp");       //redirects to features.jsp
        // }
        else {
            res.sendRedirect("login.jsp");
        }
    }
}
