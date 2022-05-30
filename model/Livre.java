package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Livre implements Serializable {
	
	private static final long serialVersionUID = 1L;
    private int id;
    private String titre;
    private String auteur;
    private String editeur;
    private LocalDate dateParution;
    private int qtStock;
    private int qtEntree;
    private String categorie;
    private float prix;

    // Constructeur
    
    public Livre(int id, String titre, String auteur, String editeur, LocalDate dateParution, String categorie, float prix, int qtStock) {
    	this.titre = titre;
    	this.auteur = auteur;
    	this.editeur = editeur;
    	this.dateParution = dateParution;
    	this.categorie = categorie;
    	this.prix = prix;
    	qtEntree = qtStock;
    	this.qtStock = qtEntree;
    	this.id = id;
    }
    
    // M�thodes
    public int getId() {
    	return id;
    }
    
    public void setId(int i) {
    	id = i;
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
    
    public LocalDate getDateParution() {
    	return dateParution;
    }
    
    public void setDateParution(LocalDate t) {
    	dateParution = t;
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
    
    public int getQtEntree() {
    	return qtEntree;
    }
    
    public int getStock() {
    	return qtStock;
    }
    
    public void setStock(int s) {
		if(s > 0) {
			qtEntree += s;
		}
		qtStock = s;
	}
    
    public void decStock(int s) {
    	qtStock -= s;
    }
    
    public int qtSortie() {
    	return qtEntree - qtStock;
    }
}