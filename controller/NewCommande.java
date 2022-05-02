package controller;

import java.util.*;
import java.time.*;
import java.time.format.*;
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
			fin.add(m.rchLivre(temp2[i]));
		}
		
		c = new Commande((new Date(System.currentTimeMillis()).toInstant()
				.atOffset(ZoneOffset.UTC)
				.format( DateTimeFormatter.ofPattern("dd-MM-yyyy"))), cli, fin);
		status = 1;
		new Fen5_Ach_Fact(m, cli, c);
	}
	
	public Vector<String> buildSet(JList<String> list) {
		Vector<String> temp = new Vector<String>();
		for(int i = 0; i < list.getModel().getSize();i++) {
            temp.add((String.valueOf(list.getModel().getElementAt(i)).split("\"")[1]));
        }
		return temp;
	}
}