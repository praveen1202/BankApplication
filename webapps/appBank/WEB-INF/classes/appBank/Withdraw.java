package appBank;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*; 
import jakarta.servlet.*;
import java.io.*;

@WebServlet("/JSP/withDraw")
// have to add annotation or configure it in XML

public class Withdraw extends HttpServlet{
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
			StoreTransaction.store(ctmr,"WithDrawal",amt);
			res.sendRedirect("transaction.jsp");
			//temporarily put in out.println()
			// for(Transaction iter : Globals.ctmr.transactDetails){
			// out.println(iter.transID + "," + iter.transType +","+ iter.amt + "," + iter.balance+"\n"); 
		// }
		}
		else{
			out.println("Invalid Entry/Low Balance");
		}
		
	}
}