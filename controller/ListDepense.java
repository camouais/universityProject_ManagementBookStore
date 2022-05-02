package controller;

import java.util.Set;

import model.*;

public class ListDepense {
    Object[] list;
    String[] tab;
    
    public ListDepense(Magasin m, Set<Depense> dep) {
        list = dep.toArray();
        tab = new String[list.length];
        for(int i = 0; i < list.length; i++) {
            String s = (((Depense)list[i]).getId()+" - " + 
            		((Depense)list[i]).getDescription() + " " + 
            		((Depense)list[i]).getCout() + " - " + 
                    ((Depense)list[i]).getEmp().getNom() + " - " + 
                    ((Depense)list[i]).getEmp().getPrenom());
            tab[i] = s;
        }
    }
    
    public String[] getList() {
        return tab;
    }
}