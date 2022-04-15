package model;

import java.util.*;
/*
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
*/

public class Stock {

    // Attributs
    public int qtStock;
    public float prixStock;
    public int qtEntree;
    public Livre livre;
    public Magasin mag;
    public int idStock; 
    
    // Constructeur
    public Stock(float pS, int qE, int id, Livre l) {
        prixStock = pS;
        qtEntree = qE;
        qtStock = qtEntree;
        idStock = id;
        livre = l;
    }
    
    // Méthodes
    
    public int updLiv(Livre l) {
    	if(!l.equals(livre)) {
    		livre = l;
    		return 0;
    	} else return -1;
    }
    
    public int decStock() {
    	if(qtStock!=0) {
    	qtStock--;
    	return 0;
    	} else return -1; 
	}
    
    public int calculQuantiteSortie() {
    	return qtEntree-qtStock;
    }
}
