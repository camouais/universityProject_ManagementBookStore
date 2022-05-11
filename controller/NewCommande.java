package controller;

import java.util.*;
import java.time.*;
import model.*;

public class NewCommande {
	
	public int status;
	Commande c;
	
	public NewCommande(Magasin m, Client cli, Vector<Livre> livres) {
		if(!livres.isEmpty()) {
			c = new Commande(LocalDate.now(), cli, livres);
			status = 1;
		}
	}
	
	public Commande getCommande() {
		return c;
	}
}