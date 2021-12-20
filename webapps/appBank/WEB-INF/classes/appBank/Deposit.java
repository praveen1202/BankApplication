package appBank;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*; 
import jakarta.servlet.*;
import java.io.*;

@WebServlet("/JSP/deposit")
// have to add annotation or configure it in XML

public class Deposit extends HttpServlet{
	@Override
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {

		PrintWriter out = res.getWriter();
		// HttpSession session = req.getSession();
		Customer ctmr = Globals.ctmr;

		int amt = Integer.parseInt(req.getParameter("amt"));
		if(amt > 0){
			ctmr.balance += amt;
			StoreTransaction.store(ctmr,"Deposit",amt);
			res.sendRedirect("transaction.jsp");
		}
		else{
			out.println("Invalid Amount Entered!");
		}
	}
}