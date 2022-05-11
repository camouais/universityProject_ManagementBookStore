package controller;

import java.util.*;
import javax.swing.*;
import model.*;

public class RechercheLivre {
	
	Set<Livre> a;

	String s;
	public RechercheLivre(Magasin m, JTextField arg, String f) {
		a = new HashSet<Livre>();
		if(		f.equals("Cat\u00E9gorie") || 
				f.equals("Titre") || 
				f.equals("ID Livre") || 
				f.equals("Auteur") || 
				f.equals("Date de parution") ||
				f.equals("\u00C9diteur")
				) {
			String rechterm = arg.getText();
			if(rechterm.equals("")) {
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, "Recherche vide. Veuillez \u00E9crire un terme de recherche.", "Erreur", 2);
			} else {
				for(int i = 0; i < m.listLivre.size(); i++) {
					if(f.equals("Cat\u00E9gorie")) {
						s = ((Livre) m.listLivre.toArray()[i]).getCategorie();
					} else if(f.equals("Titre")) {
						s = (((Livre) m.listLivre.toArray()[i]).getTitre());
					} else if(f.equals("Auteur")) {
						s = (((Livre) m.listLivre.toArray()[i]).getAuteur());
					} else if(f.equals("\u00C9diteur")) {
						s = (((Livre) m.listLivre.toArray()[i]).getEditeur());
					} else if(f.equals("Date de parution")) {
						s = (((Livre) m.listLivre.toArray()[i]).getDateParution()).toString();
					} else if(f.equals("ID Livre")) {
						s = (String.valueOf(((Livre) m.listLivre.toArray()[i]).getId()));
					}
					int minlength = Math.min(s.length(), rechterm.length());
					if(rechterm.toLowerCase().equals(s.substring(0,minlength).toLowerCase())) {
						a.add((Livre) m.listLivre.toArray()[i]);
					}
				}
			}
		}
	}
	
	public Set<Livre> getList() {
		return a;
	}
}