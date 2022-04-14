package model;

import java.util.*;

public class Livre {
	
	// Attributs
	
    public Set<Commande> listCom;
    public String titre;
    public String auteur;
    public String editeur;
    public Date dateParution;
    private String resume;
    public float prix;
    public int idLivre;
    public String categorie;
    public Set<String> l_format;
    public Set<String> l_trad;
    
    // Constructeur
    
    public Livre(int id, String t, String a, String e, Date d, String c) {
    	idLivre = id;
    	titre = t;
    	auteur = a;
    	editeur = e;
    	dateParution = d;
    	categorie = c;
    }
    
    // Méthodes
    
    public void updTitre(String t) {
    	titre = t;
    }
    
    public void updAuteur(String t) {
    	auteur = t;
    }
    
    public void updEditeur(String t) {
    	editeur = t;
    }
    
    public void updDate(Date t) {
    	dateParution = t;
    }
    
    public void updResume(String t) {
    	resume = t;
    }
    
    public void updPrix(Float p) {
    	prix = p;
    }
    
    public void updCat(String c) {
    	categorie = c;
    }
    
    public String getResume() {
    	return resume;
    }
}