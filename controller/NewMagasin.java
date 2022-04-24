package controller;

import javax.swing.*;
import model.*;
import view.*;

public class NewMagasin {
    
    public NewMagasin(JTextField n) {
    	
    	Employe e_0 = new Employe("Alfred", "Jo", 4521, "Caissier", "5 Rue des Sangliers", "Alfred.Jo@gmail.com", "06352192");
    	Employe e_1 = new Employe("Tulipe", "William", 1234, "Responsable", "23 Rue des Sangliers", "Tulipe.William@gmail.com", "09318995");
    	Employe e_2 = new Employe("Armand", "Sarah", 2687, "Caissier", "6 Rue des Sangliers", "Armand.Sarah@gmail.com", "06357196");
    	Employe e_3 = new Employe("Van", "Jean", 3214, "Vendeur", "11 Rue de la Tour Eiffel", "Van.Jean@gmail.com", "063367195");
    	Employe e_4 = new Employe("Djisk", "Lili", 5425, "Vendeur", "45 Avenue des Chevaleries", "Djisk.Lili@gmail.com", "09364136");
    	Employe e_5 = new Employe("Wo", "Serena", 10001, "Responsable", "78 Rue des Savants", "Wo.Serena@gmail.com", "06546775");
		
    	
    	
    	Livre liv1 = new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", "Folio Junior", null, "Littérature pour enfants", 4.87f);
		Livre liv2 = new Livre("Paroles", "Jacques Prévert", "Folio", null, "Calligraphe", 3.14F);
		Livre liv3 = new Livre("Candide", "Voltaire", "Poche", null, "Classiques & Patrimoine", 2.85f);
		Livre liv4 = new Livre("Antigone", "Jean Anouilh", "Poche", null, "Pièce de théâtre", 6.10F);
		Livre liv5= new Livre("La Promesse de l'aube", "Romain Gary", "Folio Junior", null, "Autobiographie", 8.70f);
		
		Client cl1 = new Client("Dia", "Cameron", "30 Avenue du Parc", "0676412933", "Cameron.Dia@gmail.com", "Homme" );
		Client cl2 = new Client("Ba", "Margot", "55 Avenue des Champs-Élysées", "0605486270", "BaMargot@hotmail.fr", "Femme");
		Client cl3 = new Client("Philipe", "Victor", "87 Rue Victor Hugo", "0627266238", "phiVi@gmail.com", "Homme");
		Client cl4 = new Client("Anderson", "Jean", "1 Rue Saint-Rustique", "0608539386", "Anderson.Jean@hotmail.fr", "Homme");
		Client cl5= new Client("Du Château", "Romain", "22 Rue Oberkampf", "0698255138", "Romain.DuCH@gmail.com", "Homme");
		
		
		
    	if(n.getText().equals("")) {
    	} else {
	        Magasin m = new Magasin(n.getText());
	        m.addEmp(e_0);
	        m.addEmp(e_1);
	        m.addEmp(e_2);
	        m.addEmp(e_3);
	        m.addEmp(e_4);
	        m.addEmp(e_5);
	        
			m.addLivre(liv1);
			m.addLivre(liv2);
			m.addLivre(liv3);
			m.addLivre(liv4);
			m.addLivre(liv5);
			
			m.addCli(cl1);
			m.addCli(cl2);
			m.addCli(cl3);
			m.addCli(cl4);
			m.addCli(cl5);
			
	        new Fen1(m);
    	}
    }
}
