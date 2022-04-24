package model;

import java.io.Serializable;
import java.util.*;

public class Commande implements Serializable {
	
	// Attributs
	
	public static int totalCom;
	private int id;
	private Date dateAchat;
	private Client client;
	public Vector<Livre> listLivres;
	
	// Constructeur
	
	public Commande(Date dA, Client c, Vector<Livre> l) {
		dateAchat = dA;
		client = c;
		listLivres = l;
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
    
    public Client getClient() {
    	return client;
    }
    
    public void setClient(Client a) {
    	client = a;
    }
}
