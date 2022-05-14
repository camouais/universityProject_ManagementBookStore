package controller;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

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
		} else if (salaire.getText().isEmpty()) {
			JFrame a = new JFrame();
			JOptionPane.showMessageDialog(a, "Aucun salaire renseign�. Veuillez en renseigner un.", "Erreur", 2);
		} else if (fonction.getText().isEmpty()) {
			JFrame a = new JFrame();
			JOptionPane.showMessageDialog(a, "Aucune fonction renseign�e. Veuillez en renseigner une.", "Erreur", 2);
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
				try {
					FileOutputStream fout = new FileOutputStream("src/data/m_" + m.getNom() + "/data.txt");
					ObjectOutputStream out = new ObjectOutputStream(fout);
					out.writeObject(m);    
					out.flush();
					out.close();
				} catch(Exception ex) {
					System.out.println(e);
				}
				status = 1;
			}
		}
	}
}