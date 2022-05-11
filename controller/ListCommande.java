package controller;

import java.util.Set;

import model.*;

public class ListCommande {
	Object[] list;
	String[] formattedList;
	
	public ListCommande(Magasin m, Set<Commande> c) {
		if(c!=null) {
		list = c.toArray();
		formattedList = new String[list.length];
		for(int i = 0; i < list.length; i++) {
			String b = (((Commande)list[i]).getId()+" - Prix Total : "+ 
						(((Commande)list[i]).getPrixTotal()+" - Client : " + 
						((Commande)list[i]).getClient().getId() + "  "+ 
						((Commande)list[i]).getClient().getNom()+ "  "+ 
						((Commande)list[i]).getClient().getPrenom()));
			formattedList[i] = b;
		}
		}
	}
	
	public String[] getList() {
		return formattedList;
	}
}