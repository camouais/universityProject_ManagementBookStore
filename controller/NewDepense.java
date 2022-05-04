package controller;

import java.util.*;
import java.time.*;
import java.time.format.*;
import javax.swing.*;
import model.*;
import view.*;

public class NewDepense {
    
    public int status;
    Depense dep;

    int g ;
    public NewDepense(Magasin m, JTextField i, JTextField n, JTextField pr, JComboBox<String> desc, JTextField c, JComboBox jour, JComboBox mois, JTextField annee) {
    	LocalDate d = null;
    	int checksum = 1;
        float p = 0;
        Employe emp = m.rchEmpINP(Integer.parseInt(i.getText()), n.getText(), pr.getText());
        try {
              p = Float.parseFloat(c.getText());
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
        	dep = new Depense(m.rchEmp(Integer.parseInt(i.getText())), (String) desc.getSelectedItem(), Float.parseFloat(c.getText()), d);
		    m.addDepense(dep);
		    new Fen6_Gest_Depenses(m);
		    status = 1;
	    }
	}
}