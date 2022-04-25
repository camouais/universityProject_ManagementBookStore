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
			System.out.println("Beginning list construction");
			for(int i = 0; i < list.length; i++) {
				String b = (((Livre) list[i]).id + " - " + ((Livre) list[i]).titre);
				formattedList[i] = b;
				System.out.println(b);
			}
			System.out.println("Ending list construction");
		} else {
		}
	}
	
	public String[] getList() {
		return formattedList;
	}
}
