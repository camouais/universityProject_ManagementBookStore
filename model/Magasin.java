package model;

import java.io.Serializable;
import java.util.*;

public class Magasin implements Serializable {
	
	// Attributs
	
    private String nom;
    private String adresse;
    // [...]
    public Set<Employe> listEmp = new HashSet<>();
    public Set<Stock> listStock = new HashSet<>();
    public Set<Client> listClient = new HashSet<>();
    public Set<Commande> listCom = new HashSet<>();
    public Set<Livre> listLivre = new HashSet<>();
    
    // Constructeur
    
    public Magasin(String name) {
    	nom = name;
    }
    
    // MÃ©thodes
    
    //////////////////////////////////////////////
    //-----------------COMMANDES----------------//
    //////////////////////////////////////////////
    
    // Enregistrement d'une commande 
    
    public void newCommande(Date d, Client c, Set<Livre> l) {
    	Commande temp = new Commande(d,c,l);
    }

    // Recherche d'une commande par son ID 
    
    public Commande rchCm1(int id) {
        Commande[] rch = new Commande[listCom.size()];
        for (int i = 0; i < listCom.size(); i++) {
            if(listCom.toArray(rch)[i].getId() == id) {
                return (Commande) listCom.toArray()[i];
            }
        }
        return null;
    }
    
    // Liste des commandes ayant la mÃªme date
    
    public Set<Commande> rchCm(Date d) {
    	Set<Commande> sameDate = new HashSet<>();
        Commande[] t1 = new Commande[listCom.size()];
        for (int i = 0; i < listCom.size(); i++) {
            if(listCom.toArray(t1)[i].getDateAchat() == d) {
            	sameDate.add(listCom.toArray(t1)[i]);
            }
        }
        return sameDate;
    }
    
    ///////////////////////////////////////////
    //---------------- LIVRES----------------//
    ///////////////////////////////////////////
    
    // Enregistrement d'un livre 
    
    public int addLivre(Livre c) {
    	if(!listLivre.contains(c)) {
    		listLivre.add(c);
    		return 0;
    	}
    	return -1;
    }
    
    // Recherche d'un livre par son titre
    public Livre rchLivre(String titre) {
		Livre[] t = new Livre[listStock.size()];
		for (int i = 0; i < listStock.size(); i++) {
			if(listStock.toArray(t)[i].getTitre()==titre) {
				return (Livre) listStock.toArray()[i];
			}
		}
		return null;
    }
    
	////////////////////////////////////////////
	//-----------------STOCKS-----------------//
	////////////////////////////////////////////
    
    // CrÃ©ation d'un Stock
    public void addStock(Livre l, int qE) {
    	Stock s = new Stock(qE, l);
    	listStock.add(s);
    }
    
	// Recherche d'un stock par son ID
	public Stock rchStock(int id) {
		Stock[] t = new Stock[listStock.size()];
		for (int i = 0; i < listStock.size(); i++) {
			if(listStock.toArray(t)[i].getIdStock()==id) {
				return (Stock) listStock.toArray()[i];
			}
		}
		return null;
	}
	
    /////////////////////////////////////////////
    //-----------------CLIENTS-----------------//
    /////////////////////////////////////////////
	
    // Recherche d'un client par son nom et prÃ©nom
	
    public Client rchCli(String n, String p, String mail) {
        Client[] t = new Client[listClient.size()];
        for (int i = 0; i < listClient.size(); i++) {
            if((listClient.toArray(t)[i].getNom().equals(n)) && (listClient.toArray(t)[i].getPrenom().equals(p)) && (listClient.toArray(t)[i].getMail().equals(mail))) {
                return (Client) listClient.toArray()[i];
            }
        }
        return null;
    }
    
    // Ajout d'un client
    
    public int addCli(Client c) {
    	if(!listClient.contains(c)) {
    		listClient.add(c);
    		return 0;
    	} 
    	return -1;
    }
    
    // Suppression d'un client
    
    public int supCli(Client c) {
    	if(listClient.contains(c)) {
    		listClient.remove(c);
    		return 0;
    	} else {
    		return -1;
    	}
    }
    
    // Recherche d'un client par son nom
    
    public Client rchCliNom(String n) {
    	Set<Client> sNom = new HashSet<>();
    	Client[] tab = new Client[listClient.size()];
        for (int i = 0; i < listClient.size(); i++) {
        	if(listClient.toArray(tab)[i].getNom() == n) {
        		sNom.add(listClient.toArray(tab)[i]);
            }
        }
        return (Client) sNom;
    }
    
    // Liste des commandes d'un client
    
    public Set<Commande> listComCli(Client c) {
    	if(c.listCom!=null) {
    		return c.listCom;
    	}
    	return null;
    }
    
    // Liste des clients possÃ©dant la mÃªme date de crÃ©ation de compte
    
    public Client listDatCompCli(Date d) {
    	
    	Set<Client> s = new HashSet<>();
    	Client[] tab = new Client[listClient.size()];
        for (int i = 0; i < listClient.size(); i++) {
        	if(listClient.toArray(tab)[i].getDateCC()== d) {
            	s.add(listClient.toArray(tab)[i]);
            }
        }
        return (Client) s;
    }
    
    /////////////////////////////////////////////
    //-----------------MAGASIN-----------------//
    /////////////////////////////////////////////
    
    // Modification de l'adresse du magasin
    
    public int updateAdr(String adr) {
		if(adr != adresse) {
			adresse=adr; 
			return 0;
		}
		else {
			return-1;
		}
    }
    
    // Modification du nom du magasin
    
    public String getNom() {
    	return nom;
    }
    
    public void setNom(String n) {
		nom = n;
    }
    
    //////////////////////////////////////////////
    //-----------------EMPLOYÃ‰S-----------------//
    //////////////////////////////////////////////
    
    // Ajout d'un employÃ©
    
    public int addEmp(Employe e) {
    	if(!listEmp.contains(e)) {
    		listEmp.add(e);
    		return 0;
    	} else {
    		return -1;
    	}
    }
    
    // Suppression d'un employÃ©
    
    public int supEmp(Employe e) {
    	if(listEmp.contains(e)) {
    		listEmp.remove(e);
    		return 0;
    	} else {
    		return -1;
    	}
    }
	
    // Recherche d'un employÃ© par son ID
    
    public Employe rchEmp(int id) {
    	Employe[] t = new Employe[listEmp.size()];
        for (int i = 0; i < listCom.size(); i++) {
            if(listEmp.toArray(t)[i].getId() == id) {
                return (Employe) listEmp.toArray()[i];
            }
        }
        return null;
    }
    
    // Recherche d'un employÃ© par son nom
    
    public Set<Employe> listEmpNom(String n, String p) {
    	Set<Employe> sNom = new HashSet<>();
    	Employe[] tab = new Employe[listEmp.size()];
        for (int i = 0; i < listEmp.size(); i++) {
        	if(listEmp.toArray(tab)[i].getNom() == n) {
        		sNom.add(listEmp.toArray(tab)[i]);
            }
        }
        return sNom;
    }
    
    // Liste de tous les employÃ©s ayant le mÃªme poste
    
    public Set<Employe> listEmpPos(String f) {
    	Set<Employe> samePoste = new HashSet<>();
    	Employe[] tab = new Employe[listEmp.size()];
        for (int i = 0; i < listEmp.size(); i++) {
        	if(listEmp.toArray(tab)[i].getFonction() == f) {
        		samePoste.add(listEmp.toArray(tab)[i]);
            }
        }
        return samePoste;
    }
    
    // Liste de tous les employÃ©s ayant le mÃªme salaire
    
    public Set<Employe> listEmpSalaire(float s) {
    	Set<Employe> sameSalai = new HashSet<>();
    	Employe[] tab = new Employe[listEmp.size()];
        for (int i = 0; i < listEmp.size(); i++) {
        	if(listEmp.toArray(tab)[i].getSalaire() == s) {
        		sameSalai.add(listEmp.toArray(tab)[i]);
            }
        }
        return sameSalai;
    }
}
