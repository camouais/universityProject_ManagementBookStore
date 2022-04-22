package model;

import java.io.*;

public class Stock implements Serializable {

    // Attributs
    public static int totalS;
    private int qtStock;
    private int qtEntree;
    private Livre livre;
    private int id; 
    
    // Constructeur
    public Stock(int qE, Livre l) {
        qtEntree = qE;
        qtStock = qtEntree;
        totalS++;
        id = totalS;
        livre = l;
    }
    
    // MÃ©thodes
    
    public int updLiv(Livre l) {
    	if(!l.equals(livre)) {
    		livre = l;
    		return 0;
    	} else return -1;
    }
    
    public int getQtStock() {
    	return qtStock;
    }
    public void setQtStock(int a) {
    	qtStock = a;
    }
    public void addStock(int n) {
    	qtEntree += n;
    	qtStock += n;
    }
    public int decStock() { // ajouter un paramètre n à l'avenir ?
    	if(qtStock!=0) {
    	qtStock--;
    	return 0;
    	} else return -1; 
	}
    
    public int getQtEntree() {
    	return qtEntree;
    }
    
    public Livre getLivre() {
    	return livre;
    }
    public void setLivre(Livre a) {
    	livre = a;
    }
    
    public int getIdStock() {
    	return id;
    }
    
    
    public int calculQuantiteSortie() {
    	return qtEntree-qtStock;
    }
}
