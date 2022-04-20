package model;

import java.util.*;

public class Client {
	
    // Attributs

    public static int totalC;
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

    public Client(String n, String p, String ad, String t, String am, String s) {
    	nom = n;
    	prenom = p;
    	sexe = s;
    	tel = t;
    	dateCreationCompte = new Date(System.currentTimeMillis());
    	adresse = ad;
    	totalC++;
    	idClient = totalC;
    }
    
    public Client() {
    	totalC = 0;
    }
    
    // MÃ©thodes
    
    // Ajouter / Mettre Ã  jour une adresse mail
    
    public void updMail(String m) {
    	mail = m;
    }
    
    // Ajouter / Mettre Ã  jour un numÃ©ro de tÃ©lÃ©phone
    
    public void updTel(String t) {
    	tel = t;
    }
    
    public String getName() {
    	return (prenom + " " + nom);
    }
} 
    
