package controller;

import java.util.*;
import java.time.*;
import java.time.format.*;
import javax.swing.*;
import model.*;
import view.*;

public class ModifInfoDepense {
	
	public int status = 0;
	
    public ModifInfoDepense(Magasin m, Depense dep, JTextField i,JTextField n,JTextField pr, JComboBox<String> desc, JTextField cout, JComboBox jour, JComboBox mois, JTextField annee) {
    	LocalDate d = null;
    	int checksum = 1;
    	int g = -1;
        float p = -1;
        Employe emp = m.rchEmpINP(Integer.parseInt(i.getText()), n.getText(), pr.getText());
        try {
              p = Float.parseFloat(cout.getText());
              g = Integer.parseInt(i.getText());
        } catch (Exception e) {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Valeur invalide dans l'id ou cout. Veuillez réessayer.", "Erreur", 2);
            checksum--;
        }
        if(checksum > 0) {
	        if(emp == null) {
	            JFrame b = new JFrame();
	            JOptionPane.showMessageDialog( b, "L'employé n'existe pas dans la liste des employés.", "Erreur", 2);
	            checksum--;
	        }
        }
        if(checksum > 0) {
			try {
				if(2000 <= Integer.parseInt(annee.getText()) && Integer.parseInt(annee.getText()) <= 2022) {
				    d = LocalDate.of(Integer.parseInt(annee.getText()), mois.getSelectedIndex() + 1, jour.getSelectedIndex() + 1);
				} else {
					JFrame a = new JFrame();
					JOptionPane.showMessageDialog(a, "Veuillez saisir une année comprise entre 2000 et 2022.", "Erreur", 2);
					checksum = -1;
				}
			} catch (Exception e) {
				JFrame a = new JFrame();
			    JOptionPane.showMessageDialog(a, "Date invalide. Veuillez réessayer.", "Erreur", 2);
			    checksum = -1;
			}
		}
        if(checksum > 0) {
        	try {
        		if(g != -1) {
        			dep.setEmploye(emp);
        			dep.setCout(p);
        			dep.setDate(d);
        			dep.setDescription(desc.getSelectedItem().toString());
        		} else {
        			checksum--;
        		}
        	} catch(Exception e) {
        		checksum--;
        	}
        }
        
        if(checksum > 0) {
        	status = 1;
        }
        
    }
}
