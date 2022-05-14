package controller;

import java.util.Set;

import model.*;

public class ListCommande {
	Object[] list;
	String[] formattedList;
	
	public ListCommande(Magasin m, Set<Commande> c) {
		if(c != null) {
			list = c.toArray();
			formattedList = new String[list.length];
			for(int i = 0; i < list.length; i++) {
				Commande com = (Commande)list[i];
				String b = (com.getId() + " - Prix Total : " + com.getPrixTotal() + " - Client : " + com.getClient().getId() + " (" + com.getClient().getNom() + " " + com.getClient().getPrenom() + ")");
				formattedList[i] = b;
			}
		}
	}
	
	public String[] getList() {
		return formattedList;
	}
}