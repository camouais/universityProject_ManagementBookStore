package controller;

import javax.swing.*;
import java.util.*;
import model.*;
import view.*;

public class NewEmploye {

	Magasin m;
	Employe e;

	public NewEmploye(Magasin m, JTextField nom, JTextField prenom, JTextField sexe, JTextField salaire, JTextField fonction, 
			JTextField adresse, JTextField mail, JTextField tel) {
		float tempSalaire = 0;
		try {
		      tempSalaire = Float.parseFloat(salaire.getText());
		} catch (Exception e) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Valeur invalide dans Salaire", "Erreur", 2);
		}
		
		e = new Employe(nom.getText(), prenom.getText(), tempSalaire, fonction.getText(), adresse.getText(), mail.getText(), tel.getText());
		m.addEmp(e);
		new Fen4_Gest_MagEmp(m);
	}
}