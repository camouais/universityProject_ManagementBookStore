package model;

import java.util.*;

public class Client {
	
    // Attributs
	
    public String nom;
    public String prenom;
    public String mail;
    public String tel;
    public Date dateCreationCompte;
    public Date dateNaiss;
    public String adresse;
    public String age;
    public String sexe;
    public Set<Commande> listCom;
    public int idClient;
    
    // Constructeur

    public Client(String p, String n, String s, Date dn, String ad, int id) {
    	nom = n;
    	prenom = p;
    	sexe = s;
    	dateNaiss = dn;
    	dateCreationCompte = new Date(System.currentTimeMillis());
    	adresse = ad;
    	idClient = id;
    }
  
    // Méthodes
    
    // Ajouter / Mettre à jour une adresse mail
    
    public void updMail(String m) {
    	mail = m;
    }
    
    // Ajouter / Mettre à jour un numéro de téléphone
    
    public void updTel(String t) {
    	tel = t;
    }
    
    public String getName() {
    	return (prenom + " " + nom);
    }
} 
    
