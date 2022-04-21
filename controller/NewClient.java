package controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import model.*;
import view.*;

public class NewClient {
	
	Magasin m;
	Client c;
	JTextField nom;
	JTextField prenom;
	JTextField adresse;
	JTextField dateN;
	JTextField tel;
	JTextField mail;
	JTextField sexe;
	
	public NewClient(Magasin m, JTextField s1, JTextField s2, JTextField s3, JTextField s4, JTextField s5, JTextField s6) {
		c = new Client(s1.getText(), s2.getText(), s3.getText(), s4.getText(), s5.getText(), s6.getText());
		System.out.println("Client créé avec les attributs suivants : \nNom = " + c.getNom());
		new Fen4_Ach_DoAch(m,c);
	}
}
