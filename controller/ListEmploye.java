package controller;

import model.*;

public class ListEmploye {
	Object[] list;
	String[] tab;
	
	public ListEmploye(Magasin m) {
		list = m.listEmp.toArray();
		tab = new String[list.length];
		for(int i = 0; i < list.length; i++) {
			String s = (((Employe)list[i]).getId()+" - " + ((Employe)list[i]).getNom() + " " + ((Employe)list[i]).getPrenom() + " - " + ((Employe)list[i]).getFonction());
			tab[i] = s;
		}
	}
	
	public String[] getListEmp() {
		return tab;
	}
	
	public Employe compare(Employe e1, Employe e2) {
		if (e1.getId()<(e2.getId())) {
			return e1;
		}
		return e2;        	
	}
}