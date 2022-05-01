package controller;

import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

import javax.swing.*;
import model.*;
import view.*;
public class NewLivre {

	Magasin m;
	Livre l;


	public NewLivre(Magasin m, JTextField titre,JTextField auteur,
			JTextField editeur, JTextField date, JTextField prix, JTextField categorie, JTextField resume)  {
		float p = 0;
		try {
		      p = Float.parseFloat(prix.getText());
		} catch (Exception e) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Valeur invalide dans prix", "Erreur", 2);
		}
		l = new Livre(titre.getText(), auteur.getText(), editeur.getText(),
				date.getText(), categorie.getText(),Float.parseFloat(prix.getText()));
		m.addLivre(l);
		new Fen3_Gest_Liv(m);
	}
}
