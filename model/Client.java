package model;

import java.io.*;
import java.util.*;

public class Client implements Serializable {
	
    // Attributs

    public static int totalC;
    private int id;
    private String nom;
    private String prenom;
    private String mail;
    private String tel;
    private Date dateCreationCompte;
    private Date dateNaiss;
    private String adresse;
    private int age;
    private String sexe;
    public Vector<Commande> listCom = new Vector<Commande>();
    
    // Constructeur

    public Client(String n, String p, String ad, String t, String am, String s) {
    	nom = n;
    	prenom = p;
    	sexe = s;
    	mail = am;
    	tel = t;
    	dateCreationCompte = new Date(System.currentTimeMillis());
    	adresse = ad;
    	totalC++;
    	id = totalC;
    }
    
    public Client() {
    	totalC = 0;
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
    	return age;
    }
    
    public void setAge(int a) {
    	age = a;
    }
    
    public String getSexe() {
    	return sexe;
    }
    
    public void setSexe(String a) {
    	sexe = a;
    }
    
    public Date getDateCC() {
    	return dateCreationCompte;
    }
    
    public Date getDateNaissance() {
    	return dateNaiss;
    }
    
    public void setDateNaissance(Date a) {
    	dateNaiss = a;
    }
} 
    
