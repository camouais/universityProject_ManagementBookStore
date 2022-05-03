package model;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
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
    private LocalDate dateNaiss;
    private String adresse;
    private int age;
    private String sexe;
    public Vector<Commande> listCom = new Vector<Commande>();
    
    // Constructeur

    public Client(String n, String p, String ad, String t, String am, String s, LocalDate dn) {
    	nom = n;
    	prenom = p;
    	sexe = s;
    	mail = am;
    	tel = t;
    	dateCreationCompte = new Date(System.currentTimeMillis());
    	dateNaiss = dn;
    	adresse = ad;
    	totalC++;
    	id = totalC;
    }
    

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
    
    // M�thodes
    
    // Ajouter / Mettre � jour une adresse mail
    
    public void updMail(String m) {
    	mail = m;
    }
    
    // Ajouter / Mettre � jour un num�ro de t�l�phone
    
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
    
    public LocalDate getDateNaissance() {
    	return dateNaiss;
    }
    
    public void setDateNaissance(LocalDate a) {
    	dateNaiss = a;
    }
    
    public int age() {
    	LocalDate curDate = LocalDate.now();
    	return Period.between(dateNaiss, curDate).getYears();
    }
    
    
    
} 
    