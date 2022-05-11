package controller;

import java.time.LocalDate;

import javax.swing.*;
import model.*;

public class NewLivre {

	Magasin m;
	Livre l;
	int s;
	public int status;
	
	public NewLivre(Magasin m, JTextField titre, JTextField auteur, JTextField editeur, JComboBox<String> jour, JComboBox<String> mois, JTextField annee, JTextField prix, JTextField categorie, JTextField stock) {
		int checksum = 1;
		float p = 0;
		LocalDate d = null;
		if (titre.getText().isEmpty()) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Titre vide. Veuillez saisir un titre.", "Erreur", 2);
		} else if (auteur.getText().isEmpty()) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Auteur vide. Veuillez saisir un auteur.", "Erreur", 2);
		} else if (editeur.getText().isEmpty()) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "\u00C9diteur vide. Veuillez saisir un \u00C9diteur.", "Erreur", 2);
		} else if (annee.getText().isEmpty()) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Ann\u00E9e vide. Veuillez saisir une ann\u00E9e.", "Erreur", 2);
		} else if (prix.getText().isEmpty()) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Prix vide. Veuillez saisir un prix.", "Erreur", 2);
		} else if (categorie.getText().isEmpty()) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Catï¿½gorie vide. Veuillez saisir une cat\u00E9gorie.", "Erreur", 2);
		} else if (stock.getText().isEmpty()) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Stock vide. Veuillez saisir une quantit\u00E9 en stock.", "Erreur", 2);
		} else {
			try {
				p = Float.parseFloat(prix.getText());
			    System.out.println(p);
			} catch (NumberFormatException e) {
				JFrame a = new JFrame();
			    JOptionPane.showMessageDialog(a, "Valeur invalide dans Prix. Veuillez r\u00E9essayer.\n(Pour les valeurs d\u00E9cimales, utilisez un point.)", "Erreur", 2);
			    checksum = -1;
			}
			if(checksum > 0) {
				try {
				    s = Integer.parseInt(stock.getText());
				} catch (NumberFormatException e) {
					JFrame a = new JFrame();
				    JOptionPane.showMessageDialog(a, "Valeur invalide dans Stock. Veuillez r\u00E9essayer.", "Erreur", 2);
				    checksum = -1;
				}
			}
			if(checksum > 0) {
				try {
					if(Integer.parseInt(annee.getText()) <= LocalDate.now().getYear()) {
					    d = LocalDate.of(Integer.parseInt(annee.getText()), mois.getSelectedIndex() + 1, jour.getSelectedIndex() + 1);
					} else {
						JFrame a = new JFrame();
						JOptionPane.showMessageDialog(a, "L'année saisie n'est pas valide. Veuillez r\u00E9essayer.", "Erreur", 2);
						checksum = -1;
					}
				} catch (Exception e) {
					JFrame a = new JFrame();
				    JOptionPane.showMessageDialog(a, "Date invalide. Veuillez r\u00E9essayer.", "Erreur", 2);
				    checksum = -1;
				}
			}
			if(checksum > 0) {
				l = new Livre(titre.getText(), auteur.getText(), editeur.getText(), d, categorie.getText(), p, s);
				m.addLivre(l);
				status = 1;
			}
		}
	}
}