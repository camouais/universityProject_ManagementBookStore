package controller;

import java.io.*;
import javax.swing.*;
import model.*;

public class NewMagasin {
	
	public int status;
	Magasin m;
	
	public NewMagasin(JTextField n, JPasswordField mdp, JTextField adr) {
		int checksum = 1;
		File maindir = new File("src/data");
		String dirname;
		String filename;
		
		if(n.getText().equals("")) {
			JFrame a = new JFrame();
			JOptionPane.showMessageDialog(a, "Nom vide. Veuillez saisir un nom.", "Erreur", 2);
			checksum--;
   		} else if(new String(mdp.getPassword()).isEmpty()) {
   			JFrame a = new JFrame();
   			JOptionPane.showMessageDialog(a, "Mot de passe vide. Veuillez saisir un mot de passe.", "Erreur", 2);
			checksum--;
		} else if(n.getText().contains(" ")) {
   			JFrame a = new JFrame();
   			JOptionPane.showMessageDialog(a, "Merci de ne pas utiliser d'espace dans le nom du magasin.", "Erreur", 2);
			checksum--;
		} else if(new String(mdp.getPassword()).contains(" ")) {
   			JFrame a = new JFrame();
   			JOptionPane.showMessageDialog(a, "Merci de ne pas utiliser d'espace dans le mot de passe.", "Erreur", 2);
			checksum--;
		} else {
			m = new Magasin(n.getText(), new String(mdp.getPassword()));
			if(!adr.getText().isEmpty()) {
				m.setAdresse(adr.getText());
			}
   		}
		// Serialization
		if(checksum > 0) {
			try {
				dirname = "m_" + n.getText();
				filename = "data.txt";
				if(!maindir.exists()) {
					maindir.mkdir();
				}
				File newDir = new File(maindir, dirname);
				File TextFile = new File(newDir, filename);
				if (!newDir.exists()) {
					newDir.mkdirs();
					if (!TextFile.exists()) {
						TextFile.createNewFile();
					}
				} else {
		   			JFrame a = new JFrame();
		   			JOptionPane.showMessageDialog(a, "Ce nom de magasin existe déjà. Merci d'en choisir un autre.", "Erreur", 2);
					checksum--;
				}
				if(checksum > 0) {
					FileOutputStream fout = new FileOutputStream(maindir + "/" + dirname + "/" + filename);
					ObjectOutputStream out = new ObjectOutputStream(fout);
					out.writeObject(m);    
					out.flush();
					out.close();
					fout.flush();
					fout.close();
					status = 1;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	public Magasin getMagasin() {
		return m;
	}
}	