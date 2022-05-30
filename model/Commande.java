package model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;

public class Commande implements Serializable {
	
	// Attributs
	
	private static final long serialVersionUID = 1L;
	private int id;
	private LocalDate dateAchat;
	private Client client;
	public Vector<Livre> listLivres;
	
	// Constructeur
	
	public Commande(int id, LocalDate dA, Client c, Vector<Livre> l) {
		dateAchat = dA;
		client = c;
		listLivres = l;
		this.id = id;
	}
	
	
	
	public Vector<Livre> getLivres(){
		return listLivres;
	}
	
	
	public String getPrixTotal() {
		DecimalFormat df = new DecimalFormat("#.##");
		Object[] arrayLivres = listLivres.toArray();
		float prixCount = 0;
		for(int i = 0; i < arrayLivres.length; i++) {
			prixCount += ((Livre) arrayLivres[i]).getPrix();
		}
		return df.format(prixCount);
	}
	
	public float getPrixTotal2() {
		Object[] arrayLivres = listLivres.toArray();
		float prixCount = 0;
		for(int i = 0; i < arrayLivres.length; i++) {
			prixCount += ((Livre) arrayLivres[i]).getPrix();
		}
		return prixCount;
	}
	
	
    public int getId() {
    	return id;
    }
    
    public LocalDate getDateAchat() {
    	return dateAchat;
    }
    
    
    public Client getClient() {
    	return client;
    }
    
}