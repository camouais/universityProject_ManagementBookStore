package model;

import java.util.*;

public class Commande  {
	
	// Attributs
	
	public static int totalCom;
	public Date dateAchat;
	public String modePaiement;
	public Magasin mag;
	public int idCom;
	public Client client;
	public Set<Livre> listLivres;
	
	// Constructeur
	
	public Commande(Date dA, Client c, String mdp, int id) {
		dateAchat= dA;
		modePaiement = mdp;
		client=c;
		idCom =id;
		totalCom++;
	}
}
