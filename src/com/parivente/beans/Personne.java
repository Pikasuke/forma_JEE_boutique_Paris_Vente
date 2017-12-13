package com.parivente.beans;

import java.util.ArrayList;
import java.util.List;

public class Personne {
	private Integer id;
	private String prenom;
	private String nom;
	private String mail;
	private String tel;
	private String mdp;
	

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer setId() {
		return id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	
	String PATH = new String ("C:\\Users\\Administrateur\\Desktop\\Formation_POE\\ParisVentes\\WebContent\\personne.txt");
	Bdd bddPersonne = new Bdd (PATH); //creer la classe bdd pour utiliser readfile, et lui donner l'attribut filename
	
	public Personne listStrPersToOnePers (String str) {
		Personne personne = new Personne();
		String[] tab = null;
		tab = str.split("\\|");
		try { 
			personne.id= Integer.parseInt(tab[0]);
		}
		catch (Exception e) {
			System.out.println("Vérifier l'Id dans la base de donnée de Personne");
		}
		personne.prenom = tab[1];
		personne.nom = tab[2];
		personne.mail = tab[3];
		personne.tel = tab[4];
		personne.mdp = tab[5];
		
		return personne;
	}
	
	
	public ArrayList<Personne> listStrPersToArrayListPers (List<String> listStrPers) {
		ArrayList<Personne> arrayListPers = new ArrayList<Personne>();
		for (String stockUneSeuleLigne : listStrPers) {
			Personne pers = this.listStrPersToOnePers(stockUneSeuleLigne);
			arrayListPers.add(pers);
		}
		return arrayListPers;
	}
	
	
}



