package com.parivente.beans;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Article {
	private Integer id;
	private String nom;
	private String lien;
	private String description;
	private float prix;
	private HttpServletRequest request;

	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLien() {
		return lien;
	}
	public void setLien(String lien) {
		this.lien = lien;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	String FILENAME = new String ("C:\\Users\\Administrateur\\Desktop\\Formation_POE\\ParisVentes\\WebContent\\articles.txt");
	Bdd bdd = new Bdd (FILENAME); //creer la classe bdd pour utiliser readfile, et lui donner l'attribut filename

	
	
	public Article createArticleBySplitLine(String line) { 
		Article article = new Article();
		String[] arr = null;
		arr = line.split("\\|");
		article.id = this.stringToInteger(arr[0]);
		article.nom = arr[1];
		article.lien = arr[2];
		article.description = arr[3];
		try { article.prix=Float.parseFloat(arr[4]);			
		}
		catch (Exception e) {
			System.out.println("Attention probleme de Variable de prix en Float");
		}
		System.out.println(article.id + article.nom );
		return article;
	}
	
	
	
	public Integer stringToInteger (String str) {
		Integer i = new Integer(0);
		try { 
			i = Integer.parseInt(str);
		}
		catch (NumberFormatException e) {
			System.out.println("Erreur de type String et Integer pour ID");
		}
		return i;
	}
		
	
	public ArrayList<Article> tousLesArticles(List<String> listbdd) {
		ArrayList<Article> listArt = new ArrayList<Article>();
				for (String line : listbdd) {
					Article article = this.createArticleBySplitLine(line);
							listArt.add(article);
				} 
				return listArt;
		}
	
	public Article unSeulArticle(List<String> listbdd , Integer id) {
		Article articleSimple = new Article();
		for (String line : listbdd) {
			articleSimple = this.createArticleBySplitLine(line);
				if (articleSimple.getId() == id) {
					return articleSimple;
				} else {
					System.out.println("Id de l'article inexistant");
				}
			} 
		return articleSimple;
	}
	
	
}
