package model;

import java.util.*;

class Employe {
	
	// Attributs
	
	public String nom;
    public String prenom;
    public float salaire;
    public String fonction;
    private String adresse;
    private String mail;
    private String tel;
    public Magasin magasin;
    public int idEmp; 
    public Set<Livraison> listLiv; 
    
    // Constructeur
    
    public Employe(String n, String p, float s, String f, String a, String ml, String t, Magasin m, int i) {
    	nom = n; 
    	prenom = p;
    	salaire = s;
    	fonction = f;
    	adresse = a;
    	mail = ml;
    	tel = t;	
    	magasin = m;
    	idEmp = i;
    }
    
    // Méthodes
    
	public int updateAdr(String adr) {
		if(adr != adresse) {
			adresse=adr; 
			return 0;
		}
		else {
			return-1;
		}
    }
	
	public int updateSal(float s) {
		if(s != salaire) {
			salaire=s; 
			return 0;
		}
		else {
			return -1;
		}
	}
	
	public int updateFonc(String f) {
		if(f != fonction) {
			fonction =f; 
			return 0;
		}
		else {
			return -1;
		}
	}
	
	public int updateTel(String t) {
		if(t != tel) {
			tel = t; 
			return 0;
		}
		else {
			return -1;
		}
	}
	
	public int updateMail(String ml) {
		if(ml != mail) {
			mail = ml; 
			return 0;
		}
		else {
			return -1;
		}
	}
	
	public int updateMag(Magasin mag) {
		if( mag != magasin) {
			magasin = mag; 
			return 0;
		}
		else {
			return -1;
		}
	}
	
}
