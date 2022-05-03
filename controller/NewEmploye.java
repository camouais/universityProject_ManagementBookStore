package controller;

import javax.swing.*;

import java.time.LocalDate;
import java.util.*;
import model.*;
import view.*;

public class NewEmploye {

	Magasin m;
	Employe e;
	public int status = 0;

	public NewEmploye(Magasin m, JTextField nom, JTextField prenom, JTextField sexe, JTextField salaire, JTextField fonction, JTextField adresse, JTextField mail, JTextField tel, JComboBox jour, JComboBox mois, JTextField annee) {
		float tempSalaire = 0;
		int checksum = 1;
		LocalDate dateTemp = null;
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
		} else if (salaire.getText().isEmpty()) {
			JFrame a = new JFrame();
			JOptionPane.showMessageDialog(a, "Aucun salaire renseigné. Veuillez en renseigner un.", "Erreur", 2);
		} else {
			if(checksum > 0) {
				try {
					if(1910 <= Integer.parseInt(annee.getText()) && Integer.parseInt(annee.getText()) <= 2010) {
					    dateTemp = LocalDate.of(Integer.parseInt(annee.getText()), mois.getSelectedIndex() + 1, jour.getSelectedIndex() + 1);
					} else {
						JFrame a = new JFrame();
						JOptionPane.showMessageDialog(a, "Veuillez saisir une année comprise entre 1910 et 2010.", "Erreur", 2);
						checksum = -1;
					}
				} catch (Exception e) {
					JFrame a = new JFrame();
				    JOptionPane.showMessageDialog(a, "Date invalide. Veuillez réessayer.", "Erreur", 2);
				    checksum = -1;
				}
			}
			if(checksum > 0) {
				try {
				    tempSalaire = Float.parseFloat(salaire.getText());
				} catch (Exception e) {
					JFrame a = new JFrame();
				    JOptionPane.showMessageDialog(a, "Valeur invalide dans Salaire", "Erreur", 2);
				    checksum = -1;
				}
			}
			if(checksum > 0) {
				e = new Employe(nom.getText(), prenom.getText(), tempSalaire, fonction.getText(), adresse.getText(), mail.getText(), tel.getText(), dateTemp);
				m.addEmp(e);
				new Fen4_Gest_MagEmp(m);
				status = 1;
			}
		}
	}
}
