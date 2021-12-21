package appBank;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*; 
import jakarta.servlet.*;
import java.io.*;

@WebServlet("/JSP/withdraw/*")
// have to add annotation or configure it in XML

public class Withdraw extends HttpServlet{			//request comes from features.jsp
	@Override
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {

		PrintWriter out = res.getWriter();
		// HttpSession session = req.getSession();
		Customer ctmr = Globals.ctmr;

		int amt = Integer.parseInt(req.getParameter("amt"));
		

		if(ctmr.balance - amt >= 1000 && amt > 0){
			ctmr.balance -= amt;
			out.println("Success");
			out.println("Current Balance:" + ctmr.balance);
			StoreTransaction.store(ctmr,"WithDrawal",amt);			//stores the transaction in local arraylist of customer
			}
		else{
			out.println("Invalid Entry/Low Balance");
		}
		
	}
}