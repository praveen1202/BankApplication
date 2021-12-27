package appBank;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*; 
import jakarta.servlet.*;
import java.io.*;

@WebServlet("/JSP/withdraw")
// have to add annotation or configure it in XML

public class Withdraw extends HttpServlet{			//request comes from features.jsp
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {

		HttpSession session = req.getSession();
		String sessionID = req.getSession().getId();
		Customer ctmr = Globals.cstmrList.get(sessionID);

		PrintWriter out = res.getWriter();

		// HttpSession session = req.getSession();
		// Customer ctmr = Globals.ctmr;

		int amt = Integer.parseInt(req.getParameter("amt"));
		

		if(Account.debitAmt(ctmr,amt)){
			// ctmr.balance -= amt;
			// out.write("Success");
			// out.write("Current Balance:" + ctmr.balance);
			StoreTransaction.store(ctmr,"WithDrawal",amt);			//stores the transaction in local arraylist of customer
			res.sendRedirect("transaction.jsp");
			}
		else{
			out.println("Invalid Entry/Low Balance");
		}
		
	}
}