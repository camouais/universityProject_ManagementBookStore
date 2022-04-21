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
	
	public NewClient(Magasin m, JTextField nom, JTextField prenom, JTextField adresse, JTextField tel, JTextField mail, JTextField sexe) {
		c = new Client(nom.getText(), prenom.getText(), adresse.getText(), tel.getText(), mail.getText(), sexe.getText());
		System.out.println("Client créé avec les attributs suivants : \nNom = " + c.getNom());
		m.addCli(c);
		new Fen4_Ach_DoAch(m,c);
	}
}
