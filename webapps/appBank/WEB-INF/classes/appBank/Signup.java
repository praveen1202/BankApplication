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

        String name = req.getParameter("name");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");

        PrintWriter out = res.getWriter();

        if(password2.equals(password1)){
            ReadData.searchUser();      //appends custID so that it becomes unique
            DataStore.createUser(name,password1);   //creates user and stores it in database
            ReadData.storeUser();   //stores customer locally in Globals class
            HttpSession session = req.getSession();
            session.setAttribute("name",Globals.ctmr.name);
            res.sendRedirect("features.jsp"); 
        }
        else {
            out.println("Password Incorrect");
        }
    }
}