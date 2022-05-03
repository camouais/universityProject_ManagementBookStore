package controller;

import javax.swing.*;
import model.*;

public class Modif_InfoEmploye {
	
	public int status = 0;

	public Modif_InfoEmploye(Magasin m, Employe e, JTextField nom, JTextField prenom, JTextField salaire, JTextField fonction, 
			JTextField adresse, JTextField mail, JTextField tel) {
		int checksum = 1;
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
		} else if (salaire.getText().isEmpty()) {
			JFrame a = new JFrame();
			JOptionPane.showMessageDialog(a, "Aucun salaire renseigné. Veuillez en renseigner un.", "Erreur", 2);
		} else if (fonction.getText().isEmpty()) {
			JFrame a = new JFrame();
			JOptionPane.showMessageDialog(a, "Aucune fonction renseignée. Veuillez en renseigner une.", "Erreur", 2);
		} else {
			try {
			    e.setSalaire(Float.parseFloat(salaire.getText()));
			} catch (Exception ee) {
				JFrame a = new JFrame();
			    JOptionPane.showMessageDialog(a, "Valeur invalide dans Salaire", "Erreur", 2);
			    checksum = -1;
			}
			if(checksum > 0) {
				e.setNom(nom.getText());
				e.setPrenom(prenom.getText());
				e.setAdresse(adresse.getText());
				e.setTel(tel.getText());
				e.setMail(mail.getText());
				e.setSalaire(Float.parseFloat(salaire.getText()));
				e.setFonction(fonction.getText());
				status = 1;
			}
		}
	}
}
