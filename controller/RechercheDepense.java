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
			c.equals("ID Dépense") || 
			c.equals("ID Employe") || 
			c.equals("Nom Employé")|| 
			c.equals("Date")) 
		{
			String rechterm = arg.getText();
			if(rechterm.equals("")) {
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, "Recherche vide. Veuillez \u00E9crire un terme de recherche.", "Erreur", 2);
			} else {
				for(int i = 0; i < m.listDep.size(); i++) {
					if(c =="Description") {
						desc = ((Depense) m.listDep.toArray()[i]).getDescription();
					} 
					else if(c =="id dÃ©pense") {
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
		}
	}
	
	public Set<Depense> getList() {
		return a;
	}
}