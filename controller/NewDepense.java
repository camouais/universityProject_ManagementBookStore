package controller;

import java.time.*;
import javax.swing.*;
import model.*;

public class NewDepense {
    
    public int status;
    Depense dep;

    int g ;
    public NewDepense(Magasin m, JTextField i, JTextField n, JTextField pr, JTextField c, String desc, JComboBox<String> jour, JComboBox<String> mois, JTextField annee) {
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
	            JOptionPane.showMessageDialog(f, "Valeur invalide dans l'id ou cout. Veuillez r\u00E9essayer.", "Erreur", 2);
	            checksum--;
	        }
	        if(checksum > 0) {
		        if(emp == null) {
		            JFrame b = new JFrame();
		            JOptionPane.showMessageDialog( b, "L'employï¿½ n'existe pas dans la liste des employ\u00E9s.", "Erreur", 2);
		            checksum--;
		        }
	        }
	        if(checksum > 0) {
				try {
					if(2000 <= Integer.parseInt(annee.getText()) && Integer.parseInt(annee.getText()) <= 2022) {
					    d = LocalDate.of(Integer.parseInt(annee.getText()), mois.getSelectedIndex() + 1, jour.getSelectedIndex() + 1);
					} else {
						JFrame a = new JFrame();
						JOptionPane.showMessageDialog(a, "Veuillez saisir une année comprise entre 1910 et 2010.", "Erreur", 2);
						checksum = -1;
					}
				} catch (Exception e) {
					JFrame a = new JFrame();
				    JOptionPane.showMessageDialog(a, "Date invalide. Veuillez réessayer.", "Erreur", 2);
				    checksum = -1;
				}
			}
	        if(checksum > 0) {
	        	dep = new Depense(m.rchEmp(Integer.parseInt(i.getText())), desc, p, d);
			    m.addDepense(dep);
			    status = 1;
		    }
        }
	}
    
    public NewDepense(Magasin m, JTextField i, JTextField n, JTextField pr, JTextField c, String desc) {
    	int checksum = 1;
        float p = 0.F;
        int tempid = 0;
        try {
        	tempid = Integer.parseInt(i.getText());
        } catch(Exception e) {
			JFrame a = new JFrame();
		    JOptionPane.showMessageDialog(a, "ID Employé invalide.", "Erreur", 2);
        	checksum--;
        }
        if(checksum > 0) {
	        Employe emp = m.rchEmpINP(tempid, n.getText(), pr.getText());
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
		            JOptionPane.showMessageDialog(f, "Valeur invalide dans l'id ou cout. Veuillez r\u00E9essayer.", "Erreur", 2);
		            checksum--;
		        }
		        if(checksum > 0) {
			        if(emp == null) {
			            JFrame b = new JFrame();
			            JOptionPane.showMessageDialog( b, "L'employ\u00E9 n'existe pas dans la liste des employ\u00E9s.", "Erreur", 2);
			            checksum--;
			        }
		        }
		        if(checksum > 0) {
		        	dep = new Depense(m.rchEmp(Integer.parseInt(i.getText())), desc, p, LocalDate.now());
				    m.addDepense(dep);
				    status = 1;
			    }
	        }
		}
    }
}