package controller;

import java.util.*;
import javax.swing.*;
import model.*;
import view.*;

public class NewCommande {
	
	public int status;
	Commande c;
	Vector<Livre> fin;
	
	public NewCommande(Magasin m, Client cli, JList<String> list) {
		
		fin = new Vector<Livre>();
		Vector<String> temp = buildSet(list);
		String[] temp2 = temp.toArray(new String[temp.size()]);

		System.out.println(temp2.length);
		for(int i = 0; i < temp2.length; i++) {
			System.out.println("Ajout 2 : " + m.rchLivre(temp2[i]));
			fin.add(m.rchLivre(temp2[i]));
		}
		
		c = new Commande(new Date(System.currentTimeMillis()), cli, fin);
		
		status = 1;
		new Fen5_Ach_Fact(m, cli, c);
	}
	
	public Vector<String> buildSet(JList<String> list) {
		Vector<String> temp = new Vector<String>();
		for(int i = 0; i < list.getModel().getSize();i++) {
			System.out.println("Ajout de l'élément : " + (i+1) + " - " + ((String.valueOf(list.getModel().getElementAt(i)).split(" ")[2])));
            temp.add((String.valueOf(list.getModel().getElementAt(i)).split(" ")[2]));
        }
		return temp;
	}
}
