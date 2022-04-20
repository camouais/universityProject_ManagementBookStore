package controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import model.*;
import view.*;

public class NewMagasin implements ActionListener {
	Magasin magasin;
	JTextField nom;
	JTextField adresse;
	
	public NewMagasin(JTextField n, JTextField a) {
		this.nom = n;
		this.adresse = a;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		magasin= new Magasin(nom.getText());
		
	}
}
