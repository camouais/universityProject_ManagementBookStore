package controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import model.*;
import view.*;

public class NewClient implements ActionListener {
	static int id =0;
	Client c;
	JTextField nom;
	JTextField prenom;
	JTextField adresse;
	JTextField dateN;
	JTextField tel;
	JTextField mail;
	JTextField sexe;
	
	public NewClient(JTextField s1, JTextField s2, JTextField s3, JTextField s5, JTextField s6, JTextField s7) {
		this.nom = s1;
		this.prenom = s2;
		this.adresse = s3;
		this.tel = s5;
		this.mail = s6;
		this.sexe = s7;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		c = new Client(nom.getText(), prenom.getText(), adresse.getText(), tel.getText(), mail.getText(), sexe.getText());
	}
}