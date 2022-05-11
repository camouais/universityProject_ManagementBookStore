package controller;

import java.util.*;
import javax.swing.*;
import model.*;

public class RechercheClient {
	
	Set<Client> a;
	String s;
	
	public RechercheClient(Magasin m, JTextField arg, String f) {
		a = new HashSet<Client>();
		if(		f.equals("Nom")|| 
				f.equals("Pr\u00E9nom") || 
				f.equals("ID Client") || 
				f.equals("Adresse")|| 
				f.equals("Date de naissance")||
				f.equals("\u00C2ge")||
				f.equals("Sexe")||
				f.equals("Date de cr\u00E9ation du compte")||
				f.equals("T\u00E9l\u00E9phone")||
				f.equals("Mail")
				) {
			String rechterm = arg.getText();
			if(rechterm.equals("")) {
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, "Recherche vide. Veuillez \u00E9crire un terme de recherche.", "Erreur", 2);
			} else {
				for(int i = 0; i < m.listClient.size(); i++) {
						
					if(f.equals("Nom")) {
						s = ((Client) m.listClient.toArray()[i]).getNom();
					}
					else if(f.equals("Pr\u00E9nom")) {
						s = (((Client) m.listClient.toArray()[i]).getPrenom());
					}
					else if(f.equals("ID Client")) {
						s = String.valueOf(((Client) m.listClient.toArray()[i]).getId());
					}
					else if(f.equals("Adresse")) {
						s = (((Client) m.listClient.toArray()[i]).getAdresse());
					}
					else if(f.equals("Date de naissance")) {
						s = (((Client) m.listClient.toArray()[i]).getDateNaissance()).toString();
					}
					else if(f.equals("\u00C2ge")) {
						s = (String.valueOf(((Client) m.listClient.toArray()[i]).getAge()));
					}
					else if(f.equals("Sexe")) {
						s = (((Client) m.listClient.toArray()[i]).getSexe());
					}
					else if(f.equals("Date de cr\u00E9ation du compte")) {
						s = (((Client) m.listClient.toArray()[i]).getDateCC()).toString();
					}
					else if(f.equals("T\u00E9l\u00E9phone")) {
						s = ((((Client) m.listClient.toArray()[i]).getTel()));
					}
					else if(f.equals("Mail")) {
						s = (((Client) m.listClient.toArray()[i]).getMail());
					}
					
					int minlength = Math.min(s.length(), rechterm.length());
					if(rechterm.toLowerCase().equals(s.substring(0,minlength).toLowerCase())) {
							a.add((Client) m.listClient.toArray()[i]);
						
					}
				}
			}
		}
	}
	public Set<Client> getList() {
		return a;
	}
}
