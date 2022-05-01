package controller;

import javax.swing.*;
import model.*;
import view.*;

public class NewLivre {

	Magasin m;
	Livre l;
	int s;
	public int status;

	public NewLivre(Magasin m, JTextField titre,JTextField auteur, JTextField editeur, JTextField date, JTextField prix, JTextField categorie, JTextField resume, JTextField stock) {
		float p = 0;
		try {
		      p = Float.parseFloat(prix.getText());
		      s = Integer.parseInt(stock.getText());
		} catch (Exception e) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Valeur invalide dans Prix ou Stock. Veuillez réessayer.", "Erreur", 2);
		}
		l = new Livre(titre.getText(), auteur.getText(), editeur.getText(),	date.getText(), categorie.getText(),p,s);
		m.addLivre(l);
		new Fen3_Gest_Liv(m);
		status = 1;
	}
}
