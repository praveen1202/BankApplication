package appBank;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*; 
import jakarta.servlet.*;
import java.io.*;

@WebServlet("/JSP/logout")

public class Logout extends HttpServlet{		//logs out the session and invalidate it

	@Override
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {

		HttpSession session = req.getSession();
		session.removeAttribute("name");
		session.removeAttribute("custID");
		Globals.cstmrList.remove(req.getSession().getId());
		session.invalidate();

		res.sendRedirect("login.jsp");
	}
	
}