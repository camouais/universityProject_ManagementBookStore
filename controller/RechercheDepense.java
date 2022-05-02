package controller;

import java.util.*;
import javax.swing.*;
import model.*;

public class RechercheDepense {
    
    Set<Depense> a;
    
    public RechercheDepense(Magasin m, JTextField arg) {
        a = new HashSet<Depense>();
        String rechterm = arg.getText();
        if(rechterm.equals("")) {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Recherche vide. Veuillez �crire un terme de recherche.", "Erreur", 2);
			System.out.println("check 1");
        } else {
            for(int i = 0; i < m.listDep.size(); i++) {
				System.out.println("check 2");
                String desc = ((Depense) m.listDep.toArray()[i]).getDescription();
                int minlength = Math.min(desc.length(), rechterm.length());
                if(rechterm.toLowerCase().equals(desc.substring(0,minlength).toLowerCase())) {
    				System.out.println("check 3 " + (m.listDep.toArray()[i]));
                    a.add((Depense) m.listDep.toArray()[i]);
                }
            }
        }
    }
    
    public Set<Depense> getList() {
        return a;
    }
}