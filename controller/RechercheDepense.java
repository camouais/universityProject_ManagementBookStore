package controller;

import java.util.*;
import javax.swing.*;
import model.*;

public class RechercheDepense {
	
	Set<Depense> a;
	String desc;
	public RechercheDepense(Magasin m, JTextField arg, String c) {
		a = new HashSet<Depense>();
		if( c.equals("Description")|| 
			c.equals("id dépense") || 
			c.equals("id employe") || 
			c.equals("nom employe")|| 
			c.equals("date")) 
		{
			String rechterm = arg.getText();
			if(rechterm.equals("")) {
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, "Recherche vide. Veuillez écrire un terme de recherche.", "Erreur", 2);
			} else {
				for(int i = 0; i < m.listDep.size(); i++) {
					if(c =="Description") {
						desc = ((Depense) m.listDep.toArray()[i]).getDescription();
					} 
					else if(c =="id dépense") {
						desc = String.valueOf(((Depense) m.listDep.toArray()[i]).getId());
					} 
					else if(c =="id employe") {
						desc = String.valueOf(((Depense) m.listDep.toArray()[i]).getEmp().getId());
					} 
					else if(c =="nom employe") {
						desc = (((Depense) m.listDep.toArray()[i]).getEmp().getNom());
					} 
					else if(c =="date") {
						desc = (((Depense) m.listDep.toArray()[i]).getDate()).toString();
					}
					int minlength = Math.min(desc.length(), rechterm.length());
					if(rechterm.toLowerCase().equals(desc.substring(0,minlength).toLowerCase())) {
						a.add((Depense) m.listDep.toArray()[i]);
					}
				}
			}
		} else {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Aucun filtre sélectionné. Veuillez sélectionner un filtre.", "Erreur", 2);
		}
	}
	
	public Set<Depense> getList() {
		return a;
	}
}