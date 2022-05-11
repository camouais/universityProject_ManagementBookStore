package controller;

import java.util.Set;
import model.*;

public class ListFacture {
	Object[] list;
	String[] tab;
	
	public ListFacture(Magasin m, Set<Livre> liv) {
		list = liv.toArray();
		tab = new String[list.length];
		for(int i = 0; i < list.length; i++) {
			String s = (((Livre) list[i]).getId() + " - \"" 
					+ ((Livre) list[i]).getTitre() 
					+ "\" - " + ((Livre) list[i]).getAuteur())
					+ "\" - " + ((Livre) list[i]).getAuteur();
				tab[i] = s;
		}
	}
	
	public String[] getList() {
		return tab;
	}
}
