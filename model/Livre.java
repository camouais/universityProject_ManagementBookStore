package model;

import java.io.Serializable;
import java.util.*;

public class Livre implements Serializable {
	
	// Attributs
    public static int totalLivre;
	
    public Set<Commande> listCom;
    public String titre;
    public String auteur;
    public String editeur;
    public Date dateParution;
    private String resume;
    public float prix;
    public int id;
    public String categorie;
    public Set<String> l_format;
    public Set<String> l_trad;
    
    // Constructeur
    
    public Livre(String t, String a, String e, Date d, String c, float p) {
    	titre = t;
    	auteur = a;
    	editeur = e;
    	dateParution = d;
    	categorie = c;
    	prix = p;
    	id = totalLivre;
    	totalLivre++;
    }
    
    // Méthodes
    
    public String getTitre() {
    	return titre;
    }
    
    public void setTitre(String t) {
    	titre = t;
    }
    
    public String getAuteur() {
    	return auteur;
    }
    
    public void setAuteur(String t) {
    	auteur = t;
    }
    
    public String getEditeur() {
    	return editeur;
    }
    
    public void setEditeur(String t) {
    	editeur = t;
    }
    
    public Date getDateParution() {
    	return dateParution;
    }
    
    public void setDateParution(Date t) {
    	dateParution = t;
    }
    
    public String getResume() {
    	return resume;
    }
    
    public void setResume(String t) {
    	resume = t;
    }
    
    public float getPrix() {
    	return prix;
    }
    
    public void setPrix(Float p) {
    	prix = p;
    }
    
    public String getCategorie() {
    	return categorie;
    }
    
    public void setCategorie(String c) {
    	categorie = c;
    }
    
}