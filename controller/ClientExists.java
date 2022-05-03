package controller;

import javax.swing.*;
import model.*;
import view.*;

public class ClientExists {
	
	public Magasin m;
	public int status;
	
	public ClientExists(Magasin m, JTextField n, JTextField p, JTextField mail) {
		Client a = m.rchCli_npmail(n.getText(), p.getText(), mail.getText());
		if(a == null) {
			JFrame b = new JFrame();
			JOptionPane.showMessageDialog( b, "Le client n'existe pas dans la liste de clients.", "Erreur", 2);
		} else {
			status = 1;
			new Fen4_Ach_DoAch(m,a);
		}
	}
}