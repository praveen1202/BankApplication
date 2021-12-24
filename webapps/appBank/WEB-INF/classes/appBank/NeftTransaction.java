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
    public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{


        int acctNo = Integer.parseInt(req.getParameter("acctNo"));
        int amt = Integer.parseInt(req.getParameter("amt"));

        PrintWriter out = res.getWriter();

        if(ReadData.searchUser(acctNo)){
            ReadData.readTransact(Globals.recipient);

            if(Account.debitAmt(Globals.ctmr,amt)){
                Account.creditAmt(Globals.recipient,amt);

                StoreTransaction.store(Globals.ctmr,"Transfer to " + Globals.recipient.acctNo,amt);

                StoreTransaction.store(Globals.recipient,
                    "Transfer From " + Globals.ctmr.acctNo,amt);
                res.sendRedirect("features.jsp");
            }
            else{
                out.write("Low Account Balance/Invalid Amount Entered");
            }

        }
        
        

    }
}