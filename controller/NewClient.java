package controller;

import java.time.*;

import javax.swing.*;
import model.*;
import view.*;

public class NewClient {
	
	Magasin m;
	Client c;
	public int status;
	JTextField nom;
	JTextField prenom;
	JTextField adresse;
	JTextField dateN;
	JTextField tel;
	JTextField mail;
	JTextField sexe;
	
	public NewClient(Magasin m, JTextField nom, JTextField prenom, JTextField adresse, JTextField tel, JTextField mail, JComboBox<String> sexe, JComboBox jour, JComboBox mois, JTextField annee) {
		if (nom.getText().isEmpty()) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Nom vide. Veuillez saisir un nom.", "Erreur", 2);
		} else if (prenom.getText().isEmpty()) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Prénom vide. Veuillez saisir un prénom.", "Erreur", 2);
		} else if (adresse.getText().isEmpty()) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Adresse vide. Veuillez saisir une adresse.", "Erreur", 2);
		} else if (tel.getText().isEmpty()) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Aucun numéro de téléphone renseigné. Veuillez en renseigner un.", "Erreur", 2);
		} else if (mail.getText().isEmpty()) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Aucune adresse mail renseignée. Veuillez en renseigner une.", "Erreur", 2);
		} else if (annee.getText().isEmpty()) {
			JFrame a = new JFrame();
			JOptionPane.showMessageDialog(a, "Aucune année de naissance renseignée. Veuillez en sélectionner une.", "Erreur", 2);
		} else {
			try {
			      int p = Integer.parseInt(annee.getText());
			      LocalDate dateTemp = LocalDate.of(Integer.parseInt(annee.getText()), Integer.parseInt(String.valueOf(mois.getSelectedIndex() + 1)), Integer.parseInt((String) jour.getSelectedItem()));
			      c = new Client(nom.getText(), prenom.getText(), adresse.getText(), tel.getText(), mail.getText(), (String) sexe.getSelectedItem(), dateTemp);
			      m.addCli(c);
			      new Fen4_Ach_DoAch(m,c);
			      status = 1;
			} catch (Exception e) {
				JFrame a = new JFrame();
			    JOptionPane.showMessageDialog(a, "Valeur invalide dans Année. Veuillez réessayer.", "Erreur", 2);
			}
		}
	}
}