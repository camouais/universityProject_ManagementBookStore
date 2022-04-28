package controller;

import java.util.*;
import model.*;

public class ListLivres {
	
	Object[] list;
	String[] formattedList;
	
	public ListLivres(Magasin m, Set<Livre> livres) {
		if(livres != null) {
			list = livres.toArray();
			formattedList = new String[list.length];
			for(int i = 0; i < list.length; i++) {		
				String b = (((Livre) list[i]).getId() + " - \"" + ((Livre) list[i]).getTitre() + "\" - " + ((Livre) list[i]).getAuteur());
				formattedList[i] = b;
			}
		}
	}
	
	public String[] getList() {
		return formattedList;
	}
}
