package controller;

import java.util.*;
import javax.swing.*;
import model.*;

public class RechercheAchat {
	Set<Commande> a;

	String s;
	
	public RechercheAchat(Magasin m, JTextField arg, String f) {
		a = new HashSet<Commande>();
		
		if(		
				f.equals("ID Achat")||
				f==("Nom Client")|| 
				f==("Pr\u00E9nom Client") || 
				f.equals("ID client") || 
				f==("Date")
				) {
		String rechterm = arg.getText();
		if(rechterm.equals("")) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Recherche vide. Veuillez �crire un terme de recherche.", "Erreur", 2);
		} else {
			for(int i = 0; i < m.listCom.size(); i++) {
				
			if(f =="Nom Client") {
				s = ((Commande) m.listCom.toArray()[i]).getClient().getNom();
			}
			else if(f =="Pr\u00E9nom Client") {
				s = (((Commande) m.listCom.toArray()[i]).getClient().getPrenom());
			}
			else if(f =="ID Client") {
				s = String.valueOf(((Commande) m.listCom.toArray()[i]).getClient().getId());
			}
			else if(f =="ID Achat") {
				s = String.valueOf(((Commande) m.listCom.toArray()[i]).getId());
			}
		
			else if(f =="Date") {
				s = (((Commande) m.listCom.toArray()[i]).getDateAchat()).toString();
			}
			
			int minlength = Math.min(s.length(), rechterm.length());
				if(rechterm.toLowerCase().equals(s.substring(0,minlength).toLowerCase())) {
					a.add((Commande) m.listCom.toArray()[i]);
				
				}
			}
		}}
		else {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Recherche vide. Veuillez sélectionner un filtre.", "Erreur", 2);
		
		}
	}
	public Set<Commande> getList() {
		return a;
	}
}
