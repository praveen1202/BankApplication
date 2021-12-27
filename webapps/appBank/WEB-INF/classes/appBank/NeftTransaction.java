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

        int acctNo = Integer.parseInt(req.getParameter("acctNo"));
        int amt = Integer.parseInt(req.getParameter("amt"));

        PrintWriter out = res.getWriter();

        Customer recipient = ReadData.searchUser(acctNo);

        if (recipient != null){
            ReadData.getTransID(recipient);
            if(Account.debitAmt(ctmr,amt)){
                Account.creditAmt(recipient,amt);
                StoreTransaction.store(ctmr,"Transfer to " + recipient.acctNo,amt);

                StoreTransaction.store(recipient,
                    "Transfer From " + ctmr.acctNo,amt);
                res.sendRedirect("transaction.jsp");
            }
            else{
                out.write("Low Account Balance/Invalid Amount Entered");
            }
        }
        else{
            //what happens if recipient AcctNo is not found in database?
        }   



        // if(ReadData.searchUser(acctNo)){
        //     ReadData.readTransact(Globals.recipient);

        //     if(Account.debitAmt(Globals.ctmr,amt)){
        //         Account.creditAmt(Globals.recipient,amt);

        //         StoreTransaction.store(Globals.ctmr,"Transfer to " + Globals.recipient.acctNo,amt);

        //         StoreTransaction.store(Globals.recipient,
        //             "Transfer From " + Globals.ctmr.acctNo,amt);
        //         res.sendRedirect("transaction.jsp");
        //     }
        //     else{
        //         out.write("Low Account Balance/Invalid Amount Entered");
        //     }

        // }
        
        

    }
}