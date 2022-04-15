package model;

import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Exemplaire {
	
	// Attributs
	
	public static int totalExe;
	public Livre livre;
	public int idExe;
	public String etat;
	public String langage;
	public Date dateAcquisition;
	
	// Constructeurs 
	
	public Exemplaire(int i, Livre l) {
		totalExe++;
		idExe = totalExe;
		livre = l;
		dateAcquisition = new Date(System.currentTimeMillis());
	}
	
	public Exemplaire() {
		totalExe = 0;
	}
	
	// Méthodes
	
	public void updEtat(String t) {
		etat = t;
	}
	
	public void updLang(String t) {
		langage = t;
	}
    
}
