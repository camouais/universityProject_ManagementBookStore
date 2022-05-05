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
    public NewDepense(Magasin m, JTextField i, JTextField n, JTextField pr, JTextField c, String desc, int jour, String mois, int annee) {
    	LocalDate d = null;
    	int checksum = 1;
        float p = 0.F;
        Employe emp = m.rchEmpINP(Integer.parseInt(i.getText()), n.getText(), pr.getText());
        if (i.getText().isEmpty()) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Titre vide. Veuillez saisir un titre.", "Erreur", 2);
		} else if (n.getText().isEmpty()) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Auteur vide. Veuillez saisir un auteur.", "Erreur", 2);
		} else if (pr.getText().isEmpty()) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "\u00C9diteur vide. Veuillez saisir un \u00C9diteur.", "Erreur", 2);
		} else if (c.getText().isEmpty()) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Ann\u00E9e vide. Veuillez saisir une ann\u00E9e.", "Erreur", 2);
		} else if (desc==null) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "Prix vide. Veuillez saisir un prix.", "Erreur", 2);
		}
		else {
	        try {
	              p = Float.parseFloat(c.getText());
	              g = Integer.parseInt(i.getText());
	        } catch (Exception e) {
	            JFrame f = new JFrame();
	            JOptionPane.showMessageDialog(f, "Valeur invalide dans l'id ou cout. Veuillez r�essayer.", "Erreur", 2);
	            checksum--;
	        }
	        if(checksum > 0) {
		        if(emp == null) {
		            JFrame b = new JFrame();
		            JOptionPane.showMessageDialog( b, "L'employ� n'existe pas dans la liste des employ�s.", "Erreur", 2);
		            checksum--;
		        }
	        }
	        if(checksum > 0) {
				try {
					if(2000 <=annee && annee <= 2022) {
					    d = LocalDate.of(annee, Integer.parseInt(mois) , jour);
					} else {
						JFrame a = new JFrame();
						JOptionPane.showMessageDialog(a, "Veuillez saisir une ann�e comprise entre 2000 et 2022.", "Erreur", 2);
						checksum = -1;
					}
				} catch (Exception e) {
					JFrame a = new JFrame();
				    JOptionPane.showMessageDialog(a, "Date invalide. Veuillez r�essayer.", "Erreur", 2);
				    checksum = -1;
				}
			}
	        if(checksum > 0) {
	        	dep = new Depense(m.rchEmp(Integer.parseInt(i.getText())), desc, Float.parseFloat(c.getText()), d);
			    m.addDepense(dep);
			    status = 1;
		    }
        }
	}
	public NewDepense(Magasin m, JTextField t_Iemploye, JTextField t_Nemploye, JTextField t_Pemploye,
			String selectedItem, JTextField t_cout, int jour, Object object, int parseInt) {
		// TODO Auto-generated constructor stub
	}
}