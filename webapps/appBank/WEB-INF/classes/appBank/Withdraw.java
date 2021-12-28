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
		int amt;


		try{
			amt = Integer.parseInt(req.getParameter("amt"));

			if(Account.debitAmt(ctmr,amt)){
				try{
					StoreTransaction.store(ctmr,"WithDrawal",amt);			//stores the transaction in local arraylist of customer
					
					res.sendRedirect("transaction.jsp");
				}
				catch(Exception e){
					res.sendRedirect("login.jsp");
				}
				
			}
			else{
				req.setAttribute("withDrawMessage","Invalid Entry/Low Balance");
				req.getRequestDispatcher("features.jsp").forward(req,res);
			}
		} 
		catch(Exception e){
			req.setAttribute("withDrawMessage","Please Enter Valid Amount");
			req.getRequestDispatcher("features.jsp").forward(req,res);
		}	
	}

}