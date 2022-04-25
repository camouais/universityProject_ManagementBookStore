package controller;

	import javax.swing.*;
	import model.*;
	import view.*;

public class NewClient_Gest {
	
		Magasin m;
		Client c;
		public int status;
		JTextField nom;
		JTextField prenom;
		JTextField adresse;
		JTextField dateN;
		JTextField tel;
		JTextField mail;
		JTextField sexe;
		
		public NewClient_Gest(Magasin m, JTextField nom, JTextField prenom, JTextField adresse, JTextField tel, JTextField mail, JComboBox<String> sexe) {
			if (nom.getText().isEmpty()) {
				JFrame a = new JFrame();
			    JOptionPane.showMessageDialog(a, "Nom vide. Veuillez saisir un nom.", "Erreur", 2);
			} else if (prenom.getText().isEmpty()) {
				JFrame a = new JFrame();
			    JOptionPane.showMessageDialog(a, "Pr�nom vide. Veuillez saisir un pr�nom.", "Erreur", 2);
			} else if (adresse.getText().isEmpty()) {
				JFrame a = new JFrame();
			    JOptionPane.showMessageDialog(a, "Adresse vide. Veuillez saisir une adresse.", "Erreur", 2);
			} else if (tel.getText().isEmpty()) {
				JFrame a = new JFrame();
			    JOptionPane.showMessageDialog(a, "Aucun num�ro de t�l�phone renseign�. Veuillez en renseigner un.", "Erreur", 2);
			} else if (mail.getText().isEmpty()) {
				JFrame a = new JFrame();
			    JOptionPane.showMessageDialog(a, "Aucune adresse mail renseign�e. Veuillez en renseigner une.", "Erreur", 2);
			} else {
				c = new Client(nom.getText(), prenom.getText(), adresse.getText(), tel.getText(), mail.getText(), (String) sexe.getSelectedItem());
				
				m.addCli(c);
				new Fen3_Gest_Cli(m);
				status = 1;
			}
		
	}
}
