package controller;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;
import model.*;

public class Modif_InfoClient {
	public Modif_InfoClient
		(Magasin m, Client e, JTextField nom, JTextField prenom, JTextField adresse, JTextField mail, JTextField tel) {
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
		} catch(Exception ex) {
			System.out.println(e);
		}
	}
}