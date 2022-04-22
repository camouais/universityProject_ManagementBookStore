package model;

import java.io.Serializable;
import java.util.*;

public class Commande implements Serializable {
	
	// Attributs
	
	public static int totalCom;
	private int id;
	private Date dateAchat;
	private String modePaiement;
	private Client client;
	public Set<Livre> listLivres;
	
	// Constructeur
	
	public Commande(Date dA, Client c, String mdp) {
		dateAchat= dA;
		modePaiement = mdp;
		client=c;
		id = totalCom;
		totalCom++;
	}
	
	public void addLivre(Livre l) {
		listLivres.add(l);
	}
	
	public float getPrixTotal() {
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
    
    public Date getDateAchat() {
    	return dateAchat;
    }
    
    public void setNom(Date a) {
    	dateAchat = a;
    }
    
    public String getModePaiement() {
    	return modePaiement;
    }
    
    public void setModePaiement(String a) {
    	modePaiement = a;
    }
    
    public Client getClient() {
    	return client;
    }
    
    public void setClient(Client a) {
    	client = a;
    }
}
