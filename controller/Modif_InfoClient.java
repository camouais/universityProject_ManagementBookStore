package controller;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;
import model.*;

public class Modif_InfoClient {
	
	public int status = 0;
	
	public Modif_InfoClient
		(Magasin m, Client e, JTextField nom, JTextField prenom, JTextField adresse, JTextField mail, JTextField tel) {
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
		} else {
			e.setNom(nom.getText());
			e.setPrenom(prenom.getText());
			e.setAdresse(adresse.getText());
			e.setMail(mail.getText());
			e.setTel(tel.getText());
			try {
				FileOutputStream fout = new FileOutputStream("src/data/m_" + m.getNom() + "/data.txt");
				ObjectOutputStream out = new ObjectOutputStream(fout);
				out.writeObject(m);    
				out.flush();
				out.close();
				fout.flush();
				fout.close();
				status = 1;
			} catch(Exception ex) {
				System.out.println(e);
			}
		}
	}
}