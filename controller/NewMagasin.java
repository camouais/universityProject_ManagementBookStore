package controller;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import model.*;
import view.*;

public class NewMagasin {
    
    public NewMagasin(JTextField n) {
    	if(n.getText().equals("")) {
    		Fen0 a = new Fen0();
    		a.setVisible(true); // Passer par une variable est visiblement nécessaire, new Fen0() n'est pas suffisant
    	} else {
	        System.out.println("name is " + n.getText());
	        Magasin m = new Magasin(n.getText());
	        new Fen1(m);
    	}
    }
}
