package controller;

import javax.swing.*;
import model.*;
import view.*;

public class NewClient {
	
	Magasin m;
	Client c;
	JTextField nom;
	JTextField prenom;
	JTextField adresse;
	JTextField dateN;
	JTextField tel;
	JTextField mail;
	JTextField sexe;
	
	public NewClient(Magasin m, JTextField nom, JTextField prenom, JTextField adresse, JTextField tel, JTextField mail, JComboBox<String> sexe) {
		c = new Client(nom.getText(), prenom.getText(), adresse.getText(), tel.getText(), mail.getText(), (String) sexe.getSelectedItem());
		System.out.println("Client créé avec les attributs suivants :");
		System.out.println("Nom = " + c.getNom());
		System.out.println("Prénom = " + c.getPrenom());
		System.out.println("Adresse = " + c.getAdresse());
		System.out.println("Téléphone = " + c.getTel());
		System.out.println("Mail = " + c.getMail());
		System.out.println("Sexe = " + c.getSexe());
		m.addCli(c);
		new Fen4_Ach_DoAch(m,c);
	}
}
