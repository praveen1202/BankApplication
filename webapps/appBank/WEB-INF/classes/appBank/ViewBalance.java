package appBank;


import org.json.JSONObject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*; 
import jakarta.servlet.*;
import java.io.*;

@WebServlet("/JSP/viewbalance/*")
// have to add annotation or configure it in XML

public class ViewBalance extends HttpServlet{	//request for viewing balance
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {

		HttpSession session = req.getSession();
		String sessionID = req.getSession().getId();
		Customer ctmr = Globals.cstmrList.get(sessionID);

		PrintWriter out = res.getWriter();

		JSONObject object = new JSONObject();
		object.put("Balance",ctmr.balance);
		
		out.write(object.toString());

	}
}

