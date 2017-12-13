package com.parisventes.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parivente.beans.Article;
import com.parivente.beans.Bdd;
import com.parivente.beans.Personne;

/**
 * Servlet implementation class Personnes
 */
@WebServlet("/Personnes")
public class Personnes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Personnes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		

		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String PATH = new String ("C:\\Users\\Administrateur\\Desktop\\Formation_POE\\ParisVentes\\WebContent\\personne.txt");
		Bdd bddPersonne = new Bdd (PATH); //creer la classe bdd pour utiliser readfile, et lui donner l'attribut filename
		Personne personne = new Personne();
		List<String> listStrPersonne = bddPersonne.readFile();
		ArrayList<Personne> arrListPers = personne.listStrPersToArrayListPers(listStrPersonne);
			
		
			String email = request.getParameter("mail");
			String mdp = request.getParameter("pass");
			Boolean logger = (false);
			
		for (Personne p : arrListPers) {
			if ( email.equals(personne.getMail()) && mdp.equals(personne.getMdp()) ) {
				HttpSession session = request.getSession(true);
					logger = true;
					session.setAttribute("email",email);
					session.setAttribute("logger",logger);
				} else {
					System.out.println("erreur login pass");
				}
			}
		this.getServletContext().getRequestDispatcher("/WEB-INF/personne.jsp").forward(request,response);
		
		doGet(request, response);
	}

}
