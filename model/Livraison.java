package model;

import java.util.*;

public class Livraison extends Commande  {
	
	// Attributs
	
    public String livra_etat;
    public Magasin magasin;
    public Employe livreur;
    public Date dateLiv;
    public float prixLiv=0;
    
    // Constructeurs
    
    public Livraison(Date dA, Client c, int id,String mdp, Magasin m, Employe l, Date dl) {
    	super(dA,c,mdp,id);
    	magasin = m;
    	livreur = l;
    	dateLiv = dl;
	}
    
	public int updateDateLiv(Date d) {
		if(!d.equals(dateLiv)) {
			dateLiv = d;
    		return 0;
    	}
    	return -1;
    }
    
    public int updateEtat(String e) {
    	if(!e.equals(livra_etat)) {
    		livra_etat = e;
    		return 0;
    	}
    	return -1;
    }
    
    
    public int editLivreur(Employe l) {
    	if(!l.equals(livreur)) {
    		livreur = l;
    		return 0;
    	}
    	return -1;
    }
}
