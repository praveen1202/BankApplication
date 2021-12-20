package appBank;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*; 
import jakarta.servlet.*;
import java.io.*;

@WebServlet("/JSP/transactdetails/*")
// have to add annotation or configure it in XML

public class ReadTransaction extends HttpServlet{
	@Override
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {

		PrintWriter out = res.getWriter();


		for(Transaction iter : Globals.ctmr.transactDetails){
			out.write(iter.transID + "," + iter.transType +","+ iter.amt + "," + iter.balance+"\n"); 
		}
		res.setContentType("text/plain");
	}
}