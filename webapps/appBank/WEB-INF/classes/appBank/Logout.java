package appBank;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*; 
import jakarta.servlet.*;
import java.io.*;

@WebServlet("/JSP/logout")

public class Logout extends HttpServlet{

	@Override
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
		HttpSession session = req.getSession();
		session.removeAttribute("name");
		session.invalidate();
		Globals.ctmr = new Customer();
		res.sendRedirect("login.jsp");

	}
}