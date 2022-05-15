package model;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// Attributs=
    private int id;
    private String nom;
    private String prenom;
    private String mail;
    private String tel;
    private LocalDate dateCreationCompte;
    private LocalDate dateNaiss;
    private String adresse;
    private String sexe;
    public Vector<Commande> listCom = new Vector<Commande>();
    
    // Constructeur

    public Client(int id, String n, String p, String ad, String t, String am, String s, LocalDate dn) {
    	nom = n;
    	prenom = p;
    	sexe = s;
    	mail = am;
    	tel = t;
    	dateCreationCompte = LocalDate.now();
    	dateNaiss = dn;
    	adresse = ad;
    	this.id = id;
    }
    
    // Méthodes
    
    public int getId() {
    	return id;
    }
    
    public String getNom() {
    	return nom;
    }
    
    public void setNom(String a) {
    	nom = a;
    }
    
    public String getPrenom() {
    	return prenom;
    }
    
    public void setPrenom(String a) {
    	prenom = a;
    }
    
    public String getMail() {
    	return mail;
    }
    
    public void setMail(String a) {
    	mail = a;
    }
    
    public String getTel() {
    	return tel;
    }
    
    public void setTel(String a) {
    	tel = a;
    }
    
    public String getAdresse() {
    	return adresse;
    }
    
    public void setAdresse(String a) {
    	adresse = a;
    }
    
    public int getAge() {
    	LocalDate curDate = LocalDate.now();
    	return Period.between(dateNaiss, curDate).getYears();
    }
    
    public String getSexe() {
    	return sexe;
    }
    
    public void setSexe(String a) {
    	sexe = a;
    }
    
    public LocalDate getDateCC() {
    	return dateCreationCompte;
    }
    
    public LocalDate getDateNaissance() {
    	return dateNaiss;
    }
    
    public void setDateNaissance(LocalDate a) {
    	dateNaiss = a;
    }
} 
    