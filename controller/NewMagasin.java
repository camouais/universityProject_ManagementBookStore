package controller;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import model.*;
import view.*;

public class NewMagasin {
    public Magasin magasin;
    JTextField nom;
    
    public NewMagasin(JTextField n) {
    	if(n.getText().equals("")) {
    		System.out.println("name is empty"); //debug
    		Fen0 a = new Fen0();
    		a.setVisible(true); // Passer par une variable est visiblement nécessaire, new Fen0() n'est pas suffisant
    	} else {
	        this.nom = n;
	        System.out.println(n.getText());
	        magasin = new Magasin("name is " + nom.getText()); //debug
	        new Fen1(magasin);
    	}
    }
}
