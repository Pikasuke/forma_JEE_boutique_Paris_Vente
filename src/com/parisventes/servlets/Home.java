package com.parisventes.servlets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parivente.beans.Article;
import com.parivente.beans.Bdd;


@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Home() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String FILENAME = new String ("C:\\Users\\Administrateur\\Desktop\\Formation_POE\\ParisVentes\\WebContent\\articles.txt");
		Bdd bdd = new Bdd (FILENAME); //creer la classe bdd pour utiliser readfile, et lui donner l'attribut filename
		Article article = new Article();
		article.setRequest(request);
		request.setAttribute("listArticle", article.tousLesArticles(bdd.readFile()));
		
		//request.setAttribute("stringHtml",readFile2(request));
	this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request,response);
	}
	
	
//	public String readFile2(HttpServletRequest request) {
//		String listArtHtlm = new String();
//				for (String line : bdd.readFile()) {
//					String[] arr =null;
//							arr = line.split("\\|");
//							String html = "<div><article><h4>";
//							html = html + arr[1]+"</h4><figure><a id=\"";
//							html = html + arr[0]+"\" href=\""+request.getContextPath()+"/article?id=";
//							html = html + arr[0]+"\"><img src=\""+request.getContextPath()+"/img/";
//							html = html + arr[2]+"\" alt=\"";
//							html = html + arr[3]+"\"></a><figcaption>";
//							html = html + arr[3]+"</figcaption></figure><span>";
//							html = html + arr[4]+"€ </span></article></div>";
//					listArtHtlm = listArtHtlm + html;
//					System.out.println(listArtHtlm);
//				} 
//				return listArtHtlm;
	//	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
