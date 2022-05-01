package model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class Commande  {
	
	// Attributs
	
	public static int totalCom;
	
	private int id;
	private String dateAchat;
	private Client client;
	public Vector<Livre> listLivres;
	
	// Constructeur
	
	public Commande(String dA, Client c, Vector<Livre> l) {
		dateAchat = dA;
		client = c;
		listLivres = l;
		id = totalCom;
		totalCom++;
	}
	
	
	
	public void addLivre(Livre l) {
		listLivres.add(l);
	}
	
	public Vector<Livre> getAchat(Client c){
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
    
    public String getDateAchat() {
    	return dateAchat;
    }
    
    public void setNom(String a) {
    	dateAchat = a;
    }
    
    public Client getClient() {
    	return client;
    }
    
    public void setClient(Client a) {
    	client = a;
    }
}
