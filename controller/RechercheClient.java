package controller;

import java.util.*;
import javax.swing.*;
import model.*;

public class RechercheClient {
	Set<Client> a;

	String s;

	public RechercheClient(Magasin m, JTextField arg, String f) {
		a = new HashSet<Client>();
		if(		f==("Nom")|| 
				f==("Prenom") || 
				f.equals("id client") || 
				f==("Adresse")|| 
				f.equals("Date Naissance")||
				f==("Age")||
				f==("Sexe")||
				f==("Date compte")||
				f==("Téléphone")||
				f==("Mail")
				) {
		String rechterm = arg.getText();
		if(rechterm.equals("")) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Recherche vide. Veuillez écrire un terme de recherche.", "Erreur", 2);
		} else {
			for(int i = 0; i < m.listClient.size(); i++) {

			if(f =="Nom") {
				s = ((Client) m.listClient.toArray()[i]).getNom();
			}
			else if(f =="Prenom") {
				s = (((Client) m.listClient.toArray()[i]).getPrenom());
			}
			else if(f =="id client") {
				s = String.valueOf(((Client) m.listClient.toArray()[i]).getId());
			}
			else if(f =="Adresse") {
				s = (((Client) m.listClient.toArray()[i]).getAdresse());
			}
			else if(f =="Date Naissance") {
				s = (((Client) m.listClient.toArray()[i]).getDateNaissance()).toString();
			}
			else if(f =="Age") {
				s = (String.valueOf(((Client) m.listLivre.toArray()[i]).getAge()));
			}
			else if(f =="Sexe") {
				s = (((Client) m.listClient.toArray()[i]).getSexe());
			}
			else if(f =="Date compte") {
				s = (((Client) m.listClient.toArray()[i]).getDateCC()).toString();
			}
			else if(f =="Téléphone") {
				s = ((((Client) m.listClient.toArray()[i]).getTel()));
			}
			else if(f =="Mail") {
				s = (((Client) m.listClient.toArray()[i]).getMail());
			}
				int minlength = Math.min(s.length(), rechterm.length());
				if(rechterm.toLowerCase().equals(s.substring(0,minlength).toLowerCase())) {
					a.add((Client) m.listClient.toArray()[i]);

				}
			}
		}}
		else {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Recherche vide. Veuillez sélectionner un filtre.", "Erreur", 2);

		}
	}
	public Set<Client> getList() {
		return a;
	}
}