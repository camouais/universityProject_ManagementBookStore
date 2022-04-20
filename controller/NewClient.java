package controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import model.*;
import view.*;

public class NewClient implements ActionListener{
	Client c;
	String nom;
	String prenom;
	String adresse;
	Date dateN;
	String tel;
	String mail;
	String sexe;
	public NewClient(String s1, String s2, String s3, Date s4, 
			String s5, String s6, String s7) {
		nom = s1;
		prenom = s2;
		adresse = s3;
		dateN = s4;
		tel = s5;
		mail = s6;
		sexe = s7;
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
