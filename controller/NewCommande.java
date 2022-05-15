package controller;

import java.util.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.*;
import model.*;

public class NewCommande {
	
	public int status;
	Commande c;
	
	public NewCommande(Magasin m, Client cli, Vector<Livre> livres) {
		if(!livres.isEmpty()) {
			c = new Commande(m.getTCom() + 1, LocalDate.now(), cli, livres);
			try {
				FileOutputStream fout = new FileOutputStream("src/data/m_" + m.getNom() + "/data.txt");
				ObjectOutputStream out = new ObjectOutputStream(fout);
				out.writeObject(m);    
				out.flush();
				out.close();
				fout.flush();
				fout.close();
			} catch(Exception e) {
				System.out.println(e);
			}
			status = 1;
		}
	}
	
	public Commande getCommande() {
		return c;
	}
}