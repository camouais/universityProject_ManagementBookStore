package model;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Stock   {

    //attributs
    public int qtStock;
    public float prixStock;
    public int qtEntree;

    public Set<Exemplaire> exemplaires;
    public Livre livre;
    public Magasin mag;
    public int idStock; 
    
    //constructeur
    public Stock(int qS, float pS, int qE, int id) 
    {
        prixStock=pS;
        qtEntree=qE;
        qtStock=qtEntree;
        idStock= id;
    }
    
    // Méthodes
    
    public int addEx(Exemplaire e) {
    	if(!exemplaires.contains(e)) {
    		exemplaires.add(e);
    		return 0;
    	} else return -1;
    }
    
    public int delEx(Exemplaire e) {
    	if(exemplaires.contains(e)) {
    		exemplaires.remove(e);
    		return 0;
    	} else return -1;
    }
    
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
    	}
    	else {
    		return -1; 
    	}	
    }
    public int calculQuantiteSortie() 
    {
    	return qtEntree-qtStock;
    }
}