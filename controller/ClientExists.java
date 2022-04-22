package controller;

import javax.swing.*;
import model.*;
import view.*;

public class ClientExists {
	
	public ClientExists(Magasin m, JTextField n, JTextField p, JTextField mail) {
		Client a = m.rchCli(n.getText(), p.getText(), mail.getText());
		if(a == null) {
			System.out.println("Le client n'existe pas dans le Set<Client> du magasin");
			JFrame b = new JFrame();
			JOptionPane.showMessageDialog( b, "Le client n'existe pas dans la liste de clients.", "Erreur", 2);
			new Fen3_Ach_ExistC(m);
		}
	}
}
