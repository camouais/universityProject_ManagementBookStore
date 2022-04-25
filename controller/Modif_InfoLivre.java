package controller;

import java.awt.event.*;
import javax.swing.*;

import model.*;
import view.*;

public class Modif_InfoLivre {
    public Modif_InfoLivre
    (Magasin m, Livre l, JTextField titre,JTextField auteur, JTextField editeur,JTextField prix, JTextField categorie) {
    	l.setTitre(titre.getText());
		l.setAuteur(auteur.getText());
		l.setEditeur(editeur.getText());
		l.setPrix(Float.parseFloat(prix.getText()));
		l.setCategorie(categorie.getText());
    }
}
