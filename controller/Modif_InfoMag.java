package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

import javax.swing.*;
import model.Magasin;

public class Modif_InfoMag {
	int checksum = 1;
	public int status = 0;
    public Modif_InfoMag(Magasin m, JTextField nom, JTextField adresse, JPasswordField mdp, JTextField lien, JTextField tel, JComboBox<String> jour, JComboBox<String> mois, JTextField annee) {
    	LocalDate dateTemp = null;
    	if(nom.getText().equals("")) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Champ \"Nom\" vide.", "Erreur", 2);
		    checksum--;
    	} else if(nom.getText().contains(" ")) {
   			JFrame a = new JFrame();
   			JOptionPane.showMessageDialog(a, "Merci de ne pas utiliser d'espace dans le nom du magasin.", "Erreur", 2);
		    checksum--;
		} else if(adresse.getText().equals("")) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Champ \"Adresse\" vide.", "Erreur", 2);
		    checksum--;
    	} else if(mdp.getPassword().length == 0) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Champ \"Mot de passe\" vide.", "Erreur", 2);
		    checksum--;
    	} else if(new String(mdp.getPassword()).contains(" ")) {
   			JFrame a = new JFrame();
   			JOptionPane.showMessageDialog(a, "Merci de ne pas utiliser d'espace dans le mot de passe.", "Erreur", 2);
		    checksum--;
		} else if(lien.getText().equals("")) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Champ \"Lien\" vide.", "Erreur", 2);
		    checksum--;
    	} else if(tel.getText().equals("")) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Champ \"Téléphone\" vide.", "Erreur", 2);
		    checksum--;
    	} else if(annee.getText().equals("")) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Champ \"Année\" vide.", "Erreur", 2);
		    checksum--;
    	}
    	if(checksum > 0) {
			try {
				if(1800 <= Integer.parseInt(annee.getText()) && Integer.parseInt(annee.getText()) <= LocalDate.now().getYear()) {
				    dateTemp = LocalDate.of(Integer.parseInt(annee.getText()), mois.getSelectedIndex() + 1, jour.getSelectedIndex() + 1);
				} else {
					JFrame a = new JFrame();
					JOptionPane.showMessageDialog(a, "Veuillez saisir une année comprise entre 1800 et " + LocalDate.now().getYear(), "Erreur", 2);
					checksum = -1;
				}
			} catch (Exception e) {
				JFrame a = new JFrame();
			    JOptionPane.showMessageDialog(a, "Date invalide. Veuillez réessayer.", "Erreur", 2);
			    checksum = -1;
			}
		}
    	if(checksum > 0) {
	    	String oldName = m.getNom();
	    	m.setNom(nom.getText());
	    	m.setPW(String.valueOf(mdp.getPassword()));
	    	m.setSite(lien.getText());
	    	m.setTel(tel.getText());
	    	m.setAdresse(adresse.getText());
	    	m.setDateC(dateTemp);
			try {
				File temp = new File("src/data/m_" + oldName);
				temp.renameTo(new File("src/data/m_" + m.getNom()));
				FileOutputStream fout = new FileOutputStream("src/data/m_" + m.getNom() + "/data.txt");
				ObjectOutputStream out = new ObjectOutputStream(fout);
				out.writeObject(m);    
				out.flush();
				out.close();
				fout.flush();
				fout.close();
				status = 1;
			} catch(Exception e) {
				System.out.println(e);
			}
    	}
    	
    }
}