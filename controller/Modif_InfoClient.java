package controller;

import javax.swing.*;
import model.*;

public class Modif_InfoClient {
	public Modif_InfoClient
		(Magasin m, Client e, JTextField nom, JTextField prenom,  
				JTextField adresse, JTextField mail, JTextField tel) {
			 e.setNom(nom.getText());
			 e.setPrenom(prenom.getText());
			 e.setAdresse(adresse.getText());
			 e.setMail(mail.getText());
			 e.setTel(tel.getText());
	}
}