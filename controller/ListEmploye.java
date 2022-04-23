package controller;

import java.util.HashSet;
import java.util.Set;
import java.awt.EventQueue;
import java.util.*;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import view.*;
import model.*;

public class ListEmploye {
	
	Object[] list;
	String[] tab;
	public ListEmploye(Magasin m) {
	
		list= m.listEmp.toArray();
		tab = new String[list.length];
		
		
		for(int i=0; i<list.length; i++) {
			String s = (((Employe)list[i]).getId()+" "+((Employe)list[i]).getNom() +
					" "+((Employe)list[i]).getPrenom() +" - "+((Employe)list[i]).getFonction());
			tab[i]=s;
		}
		}
	
		public String[] getListEmp() {
			return tab;
		}
		
		
		
		
		
}
