package controller;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.*;
import javax.swing.*;
import model.*;

public class NewClient {
	
	Client c;
	public int status;
	
	public NewClient(Magasin m, JTextField nom, JTextField prenom, JTextField adresse, JTextField tel, JTextField mail, JComboBox<String> sexe, JComboBox<String> jour, JComboBox<String> mois, JTextField annee) {
		int checksum = 1;
		LocalDate dateTemp = null;
		if (nom.getText().isEmpty()) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Nom vide. Veuillez saisir un nom.", "Erreur", 2);
		} else if (prenom.getText().isEmpty()) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Pr�nom vide. Veuillez saisir un pr�nom.", "Erreur", 2);
		} else if (adresse.getText().isEmpty()) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Adresse vide. Veuillez saisir une adresse.", "Erreur", 2);
		} else if (tel.getText().isEmpty()) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Aucun num�ro de t�l�phone renseign�. Veuillez en renseigner un.", "Erreur", 2);
		} else if (mail.getText().isEmpty()) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Aucune adresse mail renseign�e. Veuillez en renseigner une.", "Erreur", 2);
		} else if (annee.getText().isEmpty()) {
			JFrame a = new JFrame();
			JOptionPane.showMessageDialog(a, "Aucune ann�e de naissance renseign�e. Veuillez en s�lectionner une.", "Erreur", 2);
		} else {
			if(checksum > 0) {
				try {
					if(1910 <= Integer.parseInt(annee.getText()) && Integer.parseInt(annee.getText()) <= 2010) {
					    dateTemp = LocalDate.of(Integer.parseInt(annee.getText()), mois.getSelectedIndex() + 1, jour.getSelectedIndex() + 1);
					} else {
						JFrame a = new JFrame();
						JOptionPane.showMessageDialog(a, "Veuillez saisir une ann�e comprise entre 1910 et 2010.", "Erreur", 2);
						checksum = -1;
					}
				} catch (Exception e) {
					JFrame a = new JFrame();
				    JOptionPane.showMessageDialog(a, "Date invalide. Veuillez r�essayer.", "Erreur", 2);
				    checksum = -1;
				}
			}
			if (checksum > 0) {
		      c = new Client(m.getTCli() + 1, nom.getText(), prenom.getText(), adresse.getText(), tel.getText(), mail.getText(), (String) sexe.getSelectedItem(), dateTemp);
		      m.addCli(c);
				try {
					FileOutputStream fout = new FileOutputStream("src/data/m_" + m.getNom() + "/data.txt");
					ObjectOutputStream out = new ObjectOutputStream(fout);
					out.writeObject(m);    
					out.flush();
					out.close();
					fout.flush();
					fout.close();
				} catch(Exception e) {
					System.out.println(e);
				}
		      status = 1;
			}
		}
	}
	public Client getClient() {
		return c;
	}
} 