package com.parisventes.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parivente.beans.Article;
import com.parivente.beans.Bdd;

/**
 * Servlet implementation class article
 */
@WebServlet("/article")
public class articles extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public articles() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer articleId = toInt(request.getParameter("id"));
		System.out.println(articleId);

		
		Article article = new Article();//creer la classe Article pour utiliser split et touLesArticles
		article.setRequest(request);
		Bdd bdd = new Bdd (FILENAME); //creer la classe bdd pour utiliser readfile, et lui donner l'attribut filename
		request.setAttribute("ArticleSimple", article.unSeulArticle(bdd.readFile(), articleId));
		
		System.out.println(article.unSeulArticle(bdd.readFile(), articleId));
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/article.jsp").forward(request, response);
	}

	public Integer toInt(String xx) {
		Integer intr = new Integer (0);
		try {
			intr = Integer.parseInt(xx);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Veuillez entrer un String svp");
		}
		return intr;
	}

	String FILENAME = new String(
			"C:\\Users\\Administrateur\\Desktop\\Formation_POE\\ParisVentes\\WebContent\\articles.txt");
	Bdd bdd = new Bdd (FILENAME); //creer la classe bdd pour utiliser readfile, et lui donner l'attribut filename
	Article article = new Article();
	
	
	//public String chooseArt(HttpServletRequest request, Integer id) {
//		String htmlArticleSimple = new String();
//		for (String line : bdd.readFile()) {
//				article.splitLine(line);
//				if (article.getId() == id) {
//					String html = "<div><article><h4>";
//					html = html + article.getNom() + "</h4><figure><img src=\"" + request.getContextPath() + "/img/";
//					html = html + article.getNom() + "\" alt=\"";
//					html = html + article.getDescription() + "\"><figcaption>";
//					html = html + article.getLien() + "</figcaption></figure><span>";
//					html = html + article.getPrix() + "€ </span></article></div>";
//					htmlArticleSimple = html;
//					System.out.println(htmlArticleSimple);
//					return htmlArticleSimple;
//				} else {
//					htmlArticleSimple = "Id de l'article inexistant";
//					System.out.println(htmlArticleSimple);
//				}
//			} 
//		return htmlArticleSimple;
//	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
