package controller;

import java.io.*;
import java.util.*;
import javax.swing.*;
import model.*;

public class RechercheMagasin {
	
	public Magasin a;
	String line = null;
    ArrayList<String> fileContents = new ArrayList<>();
	String s;
	public int status;
	int checksum;
	
	public RechercheMagasin(String nom, String mdp) {
		checksum = 1;
		if(nom.equals("")) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Saisie erronnée. Veuillez écrire un nom de magasin.", "Erreur", 2);
		} else if (mdp.equals("")) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Saisie erronnée. Veuillez écrire un mot de passe.", "Erreur", 2);
		} else {
		File dir = new File("src/data/m_" + nom);
		if(!dir.exists()) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Nom de magasin et/ou mot de passe inexistant.\nVeuillez réessayer.", "Erreur", 2);
			checksum--;
		}
		File f = new File(dir, "data.txt");
		if(checksum == 1) {
				if(dir.listFiles() == null) {
					checksum--;
				}
				if(checksum > 0) {
			        try {
		    			if(f.exists()) {
		    				ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
		    				Magasin mtemp = (Magasin)in.readObject();
		    				in.close();
		    				if (mtemp.getPW().equals(mdp)) {
		    					System.out.println("Nom & mot de passe correspondants trouvés !");
		    					a = mtemp;
		    					status = 1;
		    				} else {
		    					JFrame frame = new JFrame();
		    					JOptionPane.showMessageDialog(frame, "Nom de magasin et/ou mot de passe inexistant.\nVeuillez réessayer.", "Erreur", 2);
		    					checksum--;
		    				}
		    			} else {
	    					JFrame frame = new JFrame();
	    					JOptionPane.showMessageDialog(frame, "Nom de magasin et/ou mot de passe inexistant.\nVeuillez réessayer.", "Erreur", 2);
			    		   	checksum--;
				        }
				    } catch (Exception e) {
				        System.out.println(e.getMessage());
				    }
				}
			}
		}
	}
	
	public Magasin getMagasin() {
		return a;
	}
}