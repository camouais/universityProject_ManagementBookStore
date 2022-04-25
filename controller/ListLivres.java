package controller;

import model.*;

public class ListLivres {
	
	Object[] list;
	String[] formattedList;
	
	public ListLivres(Magasin m) {
		list = m.listLivre.toArray();
		formattedList = new String[list.length];
		System.out.println("Beginning list construction");
		for(int i = 0; i < list.length; i++) {
			String b = (((Livre) list[i]).id + " - " + ((Livre) list[i]).getTitre() + " - " + ((Livre) list[i]).getAuteur() );
			formattedList[i] = b;
			System.out.println(b);
		}
		System.out.println("Ending list construction");
	}
	
	public String[] getList() {
		return formattedList;
	}
}
