package controller;

import java.util.*;
import javax.swing.*;
import model.*;

public class RechercheEmploye {
	Set<Employe> a;

	String s;
	
	public RechercheEmploye(Magasin m, JTextField arg, String f) {
		a = new HashSet<Employe>();
		if(		f==("Nom")|| 
				f==("Prenom") || 
				f.equals("id employe") || 
				f==("Adresse")|| 
				f.equals("Date Naissance")||
				f==("Age")||
				f==("Sexe")||
				f==("Fonction")||
				f==("Téléphone")||
				f==("Mail")
				) {
			String rechterm = arg.getText();
			if(rechterm.equals("")) {
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, "Recherche vide. Veuillez �crire un terme de recherche.", "Erreur", 2);
			} else {
				for(int i = 0; i < m.listEmp.size(); i++) {
					
				if(f =="Nom") {
					s = ((Employe) m.listEmp.toArray()[i]).getNom();
				}
				else if(f =="Prenom") {
					s = (((Employe) m.listEmp.toArray()[i]).getPrenom());
				}
				else if(f =="id employe") {
					s = String.valueOf(((Employe) m.listEmp.toArray()[i]).getId());
				}
				else if(f =="Adresse") {
					s = (((Employe) m.listEmp.toArray()[i]).getAdresse());
				}
				else if(f =="Date Naissance") {
					s = (((Employe) m.listEmp.toArray()[i]).getDateNaissance()).toString();
				}
				else if(f =="Age") {
					s = (String.valueOf(((Employe) m.listEmp.toArray()[i]).getAge()));
				}
				else if(f =="Sexe") {
					s = (((Employe) m.listEmp.toArray()[i]).getSexe());
				}
				else if(f =="Fonction") {
					s = (((Employe) m.listEmp.toArray()[i]).getFonction());
				}
				else if(f =="Salaire") {
					s = String.valueOf(((Employe) m.listEmp.toArray()[i]).getSalaire());
				}
				else if(f =="Téléphone") {
					s = ((((Employe) m.listEmp.toArray()[i]).getTel()));
				}
				else if(f =="Mail") {
					s = (((Employe) m.listEmp.toArray()[i]).getMail());
				}
					int minlength = Math.min(s.length(), rechterm.length());
					if(rechterm.toLowerCase().equals(s.substring(0,minlength).toLowerCase())) {
						a.add((Employe) m.listEmp.toArray()[i]);
					
					}
				}
			}
		}
	}
	public Set<Employe> getList() {
		return a;
	}
}
