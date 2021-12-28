package appBank;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*; 
import jakarta.servlet.*;
import java.io.*;
import java.util.*;


@WebServlet("/JSP/neft")
// have to add annotation or configure it in XML

public class NeftTransaction extends HttpServlet{      //request comes from login.jsp
    
    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{

        HttpSession session = req.getSession();
        String sessionID = req.getSession().getId();
        
        Customer ctmr = Globals.cstmrList.get(sessionID);
        int acctNo,amt;

        try{
            acctNo = Integer.parseInt(req.getParameter("acctNo"));
            amt = Integer.parseInt(req.getParameter("amt"));

            try {
                Customer recipient = ReadData.searchUser(acctNo);
                
                ReadData.getTransID(recipient);

                if(Account.debitAmt(ctmr,amt)){

                    Account.creditAmt(recipient,amt);
                    
                    StoreTransaction.store(ctmr,"Transfer to " + recipient.acctNo,amt);

                    StoreTransaction.store(recipient,"Transfer From " + ctmr.acctNo,amt);

                    res.sendRedirect("transaction.jsp");
                }
                else{
                    req.setAttribute("neftMessage","Invalid Entry");
                    req.getRequestDispatcher("features.jsp").forward(req,res);
                }
            }
            catch(Exception e){
                req.setAttribute("neftMessage","The user ID " + acctNo + "doesn't exist!");
                req.getRequestDispatcher("features.jsp").forward(req,res);
            }
        }
        catch(Exception e){
            req.setAttribute("neftMessage","Invalid Entry");
            req.getRequestDispatcher("features.jsp").forward(req,res);
        }
    }

}