package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

public class Livre implements Serializable {
	
	// Attributs
    public static int totalLivre;
	
    private String titre;
    private String auteur;
    private String editeur;
    private Date dateParution;
    private String resume;
    private float prix;
    private int id;
    private String categorie;
    public Set<String> l_format;
    public Set<String> l_trad;
    public Set<Commande> listCom;

    // Constructeur
    
    public Livre(String titre, String auteur, String editeur, Date dateParution, String categorie, float prix) {
    	this.titre = titre;
    	this.auteur = auteur;
    	this.editeur = editeur;
    	this.dateParution = dateParution;
    	this.categorie = categorie;
    	this.prix = prix;
    	id = totalLivre;
    	totalLivre++;
    }
    
    // M�thodes

	public int getId() {
		return id;
	}
    
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
