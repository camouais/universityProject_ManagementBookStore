package controller;

import java.awt.event.*;
import javax.swing.*;

import model.*;
import view.*;

public class Modif_InfoLivre {
    public Modif_InfoLivre (Magasin m, Livre l, JTextField titre, JTextField auteur, JTextField editeur, JTextField prix, JTextField categorie) {
    	if(titre.getText().equals("")) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Champ \"Titre\" vide.", "Erreur", 2);
    	} else if(auteur.getText().equals("")) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Champ \"Auteur\" vide.", "Erreur", 2);
    	} else if(editeur.getText().equals("")) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Champ \"\u00C9diteur\" vide.", "Erreur", 2);
    	} else if(prix.getText().equals("")) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Champ \"Prix\" vide.", "Erreur", 2);
    	} else if(categorie.getText().equals("")) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Champ \"Cat\u00E9gorie\" vide.", "Erreur", 2);
    	} else {
    		l.setTitre(titre.getText());
			l.setAuteur(auteur.getText());
			l.setEditeur(editeur.getText());
			l.setPrix(Float.parseFloat(prix.getText()));
			l.setCategorie(categorie.getText());
    	}
    }
}
