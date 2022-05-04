package controller;

import java.util.Set;

import model.*;

public class ListEmploye {
	Object[] list;
	String[] tab;
	
	public ListEmploye(Magasin m, Set<Employe> e) {
		if(e != null) {
			list = e.toArray();
			tab = new String[list.length];
			for(int i = 0; i < list.length; i++) {
				String s = (((Employe)list[i]).getId()+" - " + ((Employe)list[i]).getNom() + " " + ((Employe)list[i]).getPrenom() + " - " + ((Employe)list[i]).getFonction());
				tab[i] = s;
			}
		}
	}
	
	public String[] getList() {
		return tab;
	}
}