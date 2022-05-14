package controller;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;
import model.Magasin;

public class Modif_InfoMag {
	
	public int status = 0;
    public Modif_InfoMag(Magasin m, JTextField nom, JTextField adresse, JPasswordField mdp, JTextField lien, JTextField tel, JComboBox<String> jour, JComboBox<String> mois, JTextField annee) {
    	if(nom.getText().equals("")) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Champ \"Nom\" vide.", "Erreur", 2);
    	} else if(adresse.getText().equals("")) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Champ \"Adresse\" vide.", "Erreur", 2);
    	} else if(mdp.getPassword().length == 0) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Champ \"Mot de passe\" vide.", "Erreur", 2);
    	} else if(lien.getText().equals("")) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Champ \"Lien\" vide.", "Erreur", 2);
    	} else if(tel.getText().equals("")) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Champ \"T�l�phone\" vide.", "Erreur", 2);
    	} else if(annee.getText().equals("")) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Champ \"Ann�e\" vide.", "Erreur", 2);
    	}
		try {
			FileOutputStream fout = new FileOutputStream("src/data/m_" + m.getNom() + "/data.txt");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(m);    
			out.flush();
			out.close();
		} catch(Exception e) {
			System.out.println(e);
		}
    	
    }
}