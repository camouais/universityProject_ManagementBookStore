package model;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Exemplaire {

	// Attributs
	
	public static int totalExe=0;
	public Livre livre;
	public int idExe;
	public String etat;
	public String langage;
	public Date dateAcquisition;
	
    // Constructeurs 
	
    public Exemplaire(int i, Livre l) {
    	idExe = i;
    	livre = l;
    	dateAcquisition = new Date(System.currentTimeMillis());
    	totalExe++;
    }
    
    // Méthodes

    public void updEtat(String t) {
    	etat = t;
    }
    
    public void updLang(String t) {
    	langage = t;
    }
    
}