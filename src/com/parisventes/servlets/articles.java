package com.parisventes.servlets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		request.setAttribute("htmlArticleSimple", chooseArt(request, articleId));

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

	public String chooseArt(HttpServletRequest request, Integer id) {
		String htmlArticleSimple = new String();
		try {
			List<String> allLines = Files.readAllLines(Paths.get(FILENAME));
			for (String line : allLines) {
				String[] arr = null;
				arr = line.split("\\|");
				if (toInt(arr[0]) == id) {
					String html = "<div><article><h4>";
					html = html + arr[1] + "</h4><figure><img src=\"" + request.getContextPath() + "/img/";
					html = html + arr[2] + "\" alt=\"";
					html = html + arr[3] + "\"><figcaption>";
					html = html + arr[3] + "</figcaption></figure><span>";
					html = html + arr[4] + "€ </span></article></div>";
					htmlArticleSimple = html;
					System.out.println(htmlArticleSimple);
					return htmlArticleSimple;
				} else {
					htmlArticleSimple = "Id de l'article inexistant";
					System.out.println(htmlArticleSimple);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return htmlArticleSimple;
	}

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
