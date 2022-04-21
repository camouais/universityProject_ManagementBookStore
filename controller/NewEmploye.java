
package controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import model.*;
import view.*;

public class NewEmploye {
	
	Magasin m;
	Employe e;
	String nom;
    String prenom;
    float salaire;
    String fonction;
    String adresse;
    String mail;
    String tel;
    String sexe;
    public Set<Livraison> listLiv; 
	
	public NewEmploye(Magasin m, JTextField nom, JTextField prenom, JTextField salaire, JTextField fonction, 
			JTextField adresse, JTextField mail, JTextField tel) {
		
		e = new Employe(nom.getText(), prenom.getText(), Float.parseFloat(salaire.getText()), 
				fonction.getText(), adresse.getText(), mail.getText(), tel.getText());
		m.addEmp(e);
		new Fen4_Gest_MagEmp(m);
	}
}
