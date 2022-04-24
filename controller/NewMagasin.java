package controller;

import javax.swing.*;
import model.*;
import view.*;

public class NewMagasin {
    
    public NewMagasin(JTextField n) {
    	
    	Employe e_0 = new Employe("Alfred", "Jo", 1090, "Caissier", "5 Rue des Sangliers", "Alfred.Jo@gmail.com", "06352192");
    	Employe e_1 = new Employe("Tulipe", "William", 1090, "Responsable", "23 Rue des Sangliers", "Tulipe.William@gmail.com", "09318995");
    	Employe e_2 = new Employe("Armand", "Sarah", 1090, "Caissier", "6 Rue des Sangliers", "Armand.Sarah@gmail.com", "06357196");
    	Employe e_3 = new Employe("Van", "Jean", 1090, "Vendeur", "11 Rue de la Tour Eiffel", "Van.Jean@gmail.com", "063367195");
    	Employe e_4 = new Employe("Djisk", "Lili", 1090, "Vendeur", "45 Avenue des Chevaleries", "Djisk.Lili@gmail.com", "09364136");
    	Employe e_5 = new Employe("Wo", "Serena", 1090, "Responsable", "78 Rue des Savants", "Wo.Serena@gmail.com", "06546775");
    	
    	if(n.getText().equals("")) {
    		Fen0 a = new Fen0();
    		a.setVisible(true); // Passer par une variable est visiblement nécessaire, new Fen0() n'est pas suffisant
    	} else {
	        System.out.println("Magasin créé avec le nom : " + n.getText());
	        Magasin m = new Magasin(n.getText());
	        m.addEmp(e_0);
	        m.addEmp(e_1);
	        m.addEmp(e_2);
	        m.addEmp(e_3);
	        m.addEmp(e_4);
	        m.addEmp(e_5);
	        new Fen1(m);
    	}
    }
}
