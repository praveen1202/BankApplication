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

        try{
            int custID = Integer.parseInt(req.getParameter("custID").toString());       
            String password = req.getParameter("password").toString();
            Customer ctmr = ReadData.searchUser(custID,password);

            if (ctmr != null){
               
                HttpSession session = req.getSession();
                session.setAttribute("name",ctmr.name);
                session.setAttribute("custID",custID);
                String sessionID = req.getSession().getId();
                Globals.cstmrList.put(sessionID,ctmr);
                
                res.sendRedirect("features.jsp");

                ReadData.readTransact(ctmr); //take custID after finish editing        //read transaction details and stores it in local for display

            }
            else {
                req.setAttribute("message","Invalid password/User ID");
                req.getRequestDispatcher("login.jsp").forward(req,res);
                // res.sendRedirect("login.jsp");
            }
        } catch(Exception e){
            req.setAttribute("message","Invalid password/User ID");
            req.getRequestDispatcher("login.jsp").forward(req,res);
        }
        
        
    }
}
