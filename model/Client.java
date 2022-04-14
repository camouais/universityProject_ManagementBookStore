package model;

import java.util.*;

public class Client {
    public String nom;
    public String prenom;
    private Set<String> mail;
    private Set<String> tel;
    public Date dateCreationCompte;
    public Date dateNaiss;
    public String adresse;
    public String sexe;
    public Set<Commande> listCom;
    public int idClient;

    public Client(String p, String n, String s, Date dn ,String m, String t,String ad, int id) {
    	nom = n;
    	prenom = p;
    	sexe = s;
    	dateNaiss = dn; 
    	mail.add(m);
    	tel.add(t); 	
    	dateCreationCompte = new Date(System.currentTimeMillis());
    	adresse = ad;
    	idClient = id;
    }
  
    
    
    //ajouter le mail
    public int addMail(String m) {
    	if(!mail.contains(m)) {
    		mail.add(m);
    		return 0;
    	} else {
    		// si le mail en argument est déjà présent dans le Set
    		return -1;
    	}
    }
    //supprimer le mail
    public int supMail(String m) {
    	if(mail.contains(m)) {
    		mail.remove(m);
    		return 0;
    	} else {
    		// si le mail en argument n'est pas présent dans le Set
    		return -1;
    	}
    }
    //ajouter un téléphone
    public int addTel(String t) {
    	if(!tel.contains(t)) {
    		tel.add(t);
    		return 0;
    	} else {
    		// si le tel en argument est déjà présent dans le Set
    		return -1;
    	}
    }
    //supprimer un téléphone
    public int supTel(String t) {
    	if(tel.contains(t)) {
    		tel.remove(t);
    		return 0;
    	} else {
    		// si le tel en argument n'est pas présent dans le Set
    		return -1;
    	}
    }
    public String getName() {
    	return (prenom + " " + nom);
    }
} 