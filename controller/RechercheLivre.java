package controller;

import java.util.*;
import javax.swing.*;
import model.*;

public class RechercheLivre {
	
	Set<Livre> a;

	String s;
	public RechercheLivre(Magasin m, JTextField arg, String f) {
		a = new HashSet<Livre>();
		if(		f==("Categorie")|| 
				f==("Titre") || 
				f.equals("id livre") || 
				f==("Auteur")|| 
				f==("Date")||
				f==("Editeur")
				) {
		String rechterm = arg.getText();
		if(rechterm.equals("")) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Recherche vide. Veuillez écrire un terme de recherche.", "Erreur", 2);
		} else {
			for(int i = 0; i < m.listLivre.size(); i++) {
				
				if(f =="Categorie") {
				s = ((Livre) m.listLivre.toArray()[i]).getCategorie();
			}
			else if(f =="Titre") {
				s = (((Livre) m.listLivre.toArray()[i]).getTitre());
			}
			else if(f =="Auteur") {
				s = (((Livre) m.listLivre.toArray()[i]).getAuteur());
			}
			else if(f =="Editeur") {
				s = (((Livre) m.listLivre.toArray()[i]).getEditeur());
			}else if(f =="date") {
				s = (((Livre) m.listLivre.toArray()[i]).getDateParution()).toString();
			}else if(f =="id livre") {
				s = (String.valueOf(((Livre) m.listLivre.toArray()[i]).getId()));
			}
				int minlength = Math.min(s.length(), rechterm.length());
				if(rechterm.toLowerCase().equals(s.substring(0,minlength).toLowerCase())) {
					a.add((Livre) m.listLivre.toArray()[i]);
				
				}
			}
		}}
		else {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Recherche vide. Veuillez sélectionner un filtre.", "Erreur", 2);
		
		}
		
	}
	
	public Set<Livre> getList() {
		return a;
	}
}