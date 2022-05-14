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
		File dir = new File("src/data/m_" + nom);
		if(!dir.exists()) {
			System.out.println("Nom non-existant");
			checksum--;
		}
		File f = new File(dir, "data.txt");
		checksum = 1;
		if(nom.equals("")) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Saisie erronnée. Veuillez écrire un nom de magasin.", "Erreur", 2);
		} else if (mdp.equals("")) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Saisie erronnée. Veuillez écrire un mot de passe.", "Erreur", 2);
		} else {
			if(dir.listFiles() == null) {
				checksum--;
			}
			if(checksum > 0) {
		        try {
		        	for (File file : dir.listFiles()) {
	    				if(f.exists()) {
	    					ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
	    					Magasin mtemp = (Magasin)in.readObject();
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
			        }
					if(checksum < 0) {
					}
			    } catch (Exception e) {
			        System.out.println(e.getMessage());
			    }
			}
		}
	}
	
	public Magasin getMagasin() {
		return a;
	}
}