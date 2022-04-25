package controller;

import java.util.*;
import javax.swing.*;
import model.*;

public class RechercheLivre {
	
	Set<Livre> a;
	
	public RechercheLivre(Magasin m, JTextField arg) {
		a = new HashSet<Livre>();
		String rechterm = arg.getText();
		if(rechterm.equals("")) {
			JFrame frame = new JFrame();
		    JOptionPane.showMessageDialog(frame, "Recherche vide. Veuillez écrire un terme de recherche.", "Erreur", 2);
		} else {
			for(int i = 0; i < m.listLivre.size(); i++) {
				String titre = ((Livre) m.listLivre.toArray()[i]).getTitre();
				int minlength = Math.min(titre.length(), rechterm.length());
				if(rechterm.toLowerCase().equals(titre.substring(0,minlength).toLowerCase())) {
					System.out.println(((Livre) m.listLivre.toArray()[i]).getTitre() + " correspond à " + rechterm);
					a.add((Livre) m.listLivre.toArray()[i]);
				}
			}
		}
	}
	
	public Set<Livre> getList() {
		for(int i = 0; i < a.size(); i++) {
			System.out.println(a.toArray()[i].toString() + " ajouté dans a");
		}
		return a;
	}
}
