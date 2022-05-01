package controller;

import model.Client;
import model.Magasin;

public class ListClient {
	Object[] list;
	String[] formattedList;

	public ListClient(Magasin m) {
		list = m.listClient.toArray();
		formattedList = new String[list.length];
		for(int i = 0; i < list.length; i++) {
			String b = (((Client)list[i]).getId()+ " - " + ((Client)list[i]).getNom() + " " + ((Client)list[i]).getPrenom());
			formattedList[i] = b;
		}
	}

	public String[] getListCli() {
		return formattedList;
	}
}