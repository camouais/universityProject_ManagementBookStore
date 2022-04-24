package controller;

import javax.swing.*;
import model.*;

public class Modif_InfoEmploye {
	
	public Modif_InfoEmploye(Magasin m, Employe e, JTextField nom, JTextField prenom, JTextField salaire, JTextField fonction, 
			JTextField adresse, JTextField mail, JTextField tel) {
		 e.setNom(nom.getText());
		 e.setPrenom(prenom.getText());
		 e.setSalaire(Float.parseFloat(salaire.getText()));
		 e.setFonction(fonction.getText());
		 e.setAdresse(adresse.getText());
		 e.setMail(mail.getText());
		 e.setTel(tel.getText());
	}
}