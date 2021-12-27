package appBank;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*; 
import jakarta.servlet.*;
import java.io.*;

@WebServlet("/JSP/transactdetails/*")
// have to add annotation or configure it in XML

public class ReadTransaction extends HttpServlet{		//response the request by plain text(by PrinterWriter)
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {

		PrintWriter out = res.getWriter();

		HttpSession session = req.getSession();
		String sessionID = req.getSession().getId();
		Customer ctmr = Globals.cstmrList.get(sessionID);

		for(Transaction iter : ctmr.transactDetails){
			out.write(iter.transID + "," + iter.transType +","+ iter.amt + "," + iter.balance+"\n"); 
		}
		res.setContentType("text/plain");
	}
}