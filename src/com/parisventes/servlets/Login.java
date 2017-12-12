package com.parisventes.servlets;

import java.io.IOException;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String amil = request.getParameter("mail");
//		Cookie [] cookies = request.getCookies();
//		response.addCookie(new Cookie("mail","email" ));

		HttpSession session = request.getSession(true);
		System.out.println(session.getAttribute("email"));
		Integer agee = new Integer(0);
		try {
			agee = Integer.parseInt(request.getParameter("age"));
			}
		catch (NumberFormatException e) {
			System.out.println("ce nest pas un Integer");
		}
		request.setAttribute("faux", "ce nest pas un Integer");
		
		request.setAttribute("ageee", agee);
		System.out.println(request.getParameter("age"));

		
		String [] str = {"Van", "chairat", "sam","jojo" , "toto"};
		request.setAttribute("tab", str);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("mail");
//		Cookie emailcookie = new Cookie ("mail", email);
//		response.addCookie (emailcookie);
//		System.out.println(emailcookie);
		
		String passe = request.getParameter("pass");
//		Cookie passcookie = new Cookie ("pass", passe);
//		response.addCookie (passcookie);
//		System.out.println(passcookie);

		HttpSession session = request.getSession(true);
		session.setAttribute("email",email);
		session.setAttribute("pass",passe);
		//session.invalidate();
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

}
