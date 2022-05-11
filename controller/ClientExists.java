package controller;

import javax.swing.*;
import model.*;

public class ClientExists {
	
	Client a;
	public int status;
	
	public ClientExists(Magasin m, JTextField n, JTextField p, JTextField mail) {
		Client a = m.rchCli_npmail(n.getText(), p.getText(), mail.getText());
		if(a == null) {
			JFrame b = new JFrame();
			JOptionPane.showMessageDialog(b, "Le client n'existe pas dans la liste de clients.", "Erreur", 2);
		} else {
			status = 1;
		}
	}
	
	public Client getClient() {
		return a;
	}
}