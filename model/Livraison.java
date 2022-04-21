package model;

import java.util.*;

public class Livraison extends Commande  {
	
	// Attributs
	
    public String etat;
    public Employe livreur;
    public Date dateLiv;
    public float prixLiv = 0;
    
    // Constructeurs
    
    public Livraison(Date dA, Client c, String mdp, Magasin m, Employe l, Date dl) {
    	super(dA,c,mdp);
    	livreur = l;
    	dateLiv = dl;
	}
    
    public String getEtat() {
    	return etat;
    }
    
    public void setEtat(String a) {
    	etat = a;
    }
    
    public Date getDateLiv() {
    	return dateLiv;
    }
    
    public void setDateLiv(Date a) {
    	dateLiv = a;
    }
    
    public float getPrixLiv() {
    	return prixLiv;
    }
    
    public void setPrixLiv(int a) {
    	prixLiv = a;
    }
}
