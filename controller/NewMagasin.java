package controller;

import java.time.*;
import java.util.*;
import javax.swing.*;
import model.*;
import view.*;

public class NewMagasin {
	
	public int status;
	
	public NewMagasin(JTextField n, JPasswordField mdp) {
    	
		Employe e_0 = new Employe("Alfred", "Jo", 4521, "Caissier", "5 Rue des Sangliers", "Alfred.Jo@gmail.com", "06352192");
		Employe e_1 = new Employe("Tulipe", "William", 1234, "Responsable", "23 Rue des Sangliers", "Tulipe.William@gmail.com", "09318995");
		Employe e_2 = new Employe("Armand", "Sarah", 2687, "Caissier", "6 Rue des Sangliers", "Armand.Sarah@gmail.com", "06357196");
		Employe e_3 = new Employe("Van", "Jean", 3214, "Vendeur", "11 Rue de la Tour Eiffel", "Van.Jean@gmail.com", "063367195");
		Employe e_4 = new Employe("Djisk", "Lili", 5425, "Vendeur", "45 Avenue des Chevaleries", "Djisk.Lili@gmail.com", "09364136");
		Employe e_5 = new Employe("Wo", "Serena", 10001, "Responsable", "78 Rue des Savants", "Wo.Serena@gmail.com", "06546775");
		
		Livre liv1 = new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", "Folio Junior", null, "Littérature pour enfants", 4.87f, 16);
		Livre liv2 = new Livre("Paroles", "Jacques Prévert", "Folio", null, "Calligraphe", 3.14f, 32);
		Livre liv3 = new Livre("Candide", "Voltaire", "Poche", null, "Classiques & Patrimoine", 2.85f, 24);
		Livre liv4 = new Livre("Antigone", "Jean Anouilh", "Poche", null, "Pièce de théâtre", 6.10f, 21);
		Livre liv5 = new Livre("La Promesse de l'aube", "Romain Gary", "Folio Junior", null, "Autobiographie", 8.70f, 7);
		
		Client cl1 = new Client("Dia", "Cameron", "30 Avenue du Parc", "0676412933", "Cameron.Dia@gmail.com", "Homme", LocalDate.of(1995, 07, 18));
		Client cl2 = new Client("Ba", "Margot", "55 Avenue des Champs-Élysées", "0605486270", "BaMargot@hotmail.fr", "Femme", LocalDate.of(1995, 07, 18));
		Client cl3 = new Client("Philipe", "Victor", "87 Rue Victor Hugo", "0627266238", "phiVi@gmail.com", "Homme", LocalDate.of(1995, 07, 18));
		Client cl4 = new Client("Anderson", "Jean", "1 Rue Saint-Rustique", "0608539386", "Anderson.Jean@hotmail.fr", "Homme", LocalDate.of(1995, 07, 18));
		Client cl5 = new Client("Du Château", "Romain", "22 Rue Oberkampf", "0698255138", "Romain.DuCH@gmail.com", "Homme", LocalDate.of(1995, 07, 18));
		
		Livre[] arr1 = { liv1, liv2 };
		Vector<Livre> v1 = new Vector<Livre>(Arrays.asList(arr1));
		Commande com1 = new Commande("12-01-2022",cl1,v1);
		
		Livre[] arr2 = { liv1, liv2, liv3 };
		Vector<Livre> v2 = new Vector<Livre>(Arrays.asList(arr2));
		Commande com2 = new Commande("12-01-2022",cl2,v2); 
		
		Livre[] arr3 = { liv1 };
		Vector<Livre> v3 = new Vector<Livre>(Arrays.asList(arr3));
		Commande com3 = new Commande("12-01-2022",cl3,v3); 
		
		Livre[] arr4 = { liv2, liv4 };
		Vector<Livre> v4 = new Vector<Livre>(Arrays.asList(arr4));
		Commande com4 = new Commande("12-01-2022",cl4,v4);
		
		Livre[] arr5 = { liv1, liv2, liv4, liv5 };
		Vector<Livre> v5 = new Vector<Livre>(Arrays.asList(arr5));
		Commande com5 = new Commande("12-01-2022",cl5,v5); 
		
		if(n.getText().equals("")) {
			JFrame a = new JFrame();
			JOptionPane.showMessageDialog(a, "Nom vide. Veuillez saisir un nom.", "Erreur", 2);
   		} else if(new String(mdp.getPassword()).isEmpty()) {
   			JFrame a = new JFrame();
   			JOptionPane.showMessageDialog(a, "Mot de passe vide. Veuillez saisir un mot de passe.", "Erreur", 2);
   		} else {
   			Magasin m = new Magasin(n.getText(), new String(mdp.getPassword()));
   			
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
   			
   			m.addCom(com1);
   			m.addCom(com2);
   			m.addCom(com3);
   			m.addCom(com4);
   			m.addCom(com5);
   			
   			new Fen1(m);
   			status = 1;
   		}
	}
}	