package model;

import java.util.*;

public class Magasin {
	
	// Attributs
	
    public String m_nom;
    public String m_adresse;
    public Set<Employe> listEmp = new HashSet<>();
    public Set<Stock> listStock = new HashSet<>();
    public Set<Client> listClient = new HashSet<>();
    public Set<Commande> listCom = new HashSet<>();
    public Set<Livre> listLivre = new HashSet<>();
    
    // Constructeur
    
    public Magasin(String name, String adr) {
    	m_nom = name;
    	m_adresse = adr;
    	
    }
    
    // Méthodes
    
    //////////////////////////////////////////////
    //-----------------COMMANDES----------------//
    //////////////////////////////////////////////
    
    // Enregistrement d'une commande 
    
    public void addCommande(Commande c) {
    	listCom.add(c);
    }

    // Recherche d'une commande par son ID 
    
    public Commande rchCm1(int id) {
        Commande[] rch = new Commande[listCom.size()];
        for (int i = 0; i < listCom.size(); i++) {
            if(listCom.toArray(rch)[i].idCom == id) {
                return (Commande) listCom.toArray()[i];
            }
        }
        return null;
    }
    
    // Liste des commandes ayant la même date
    
    public Set<Commande> rchCm(Date d) {
    	Set<Commande> sameDate = new HashSet<>();
        Commande[] t1 = new Commande[listCom.size()];
        for (int i = 0; i < listCom.size(); i++) {
            if(listCom.toArray(t1)[i].dateAchat == d) {
            	sameDate.add(listCom.toArray(t1)[i]);
            }
        }
        return sameDate;
    }
    
    // Liste des commandes ayant le même mode de paiement
    
    public Set<Commande> rchCm(String mdp) {
    	Set<Commande> sameMdp = new HashSet<>();
        Commande[] t1 = new Commande[listCom.size()];
        for (int i = 0; i < listCom.size(); i++) {
            if(listCom.toArray(t1)[i].modePaiement == mdp) {
            	sameMdp.add(listCom.toArray(t1)[i]);
            }
        }
        return sameMdp;
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
    
	////////////////////////////////////////////
	//-----------------STOCKS-----------------//
	////////////////////////////////////////////
    
    // Création d'un Stock
    public void addStock(Livre c, int qE, int p) {
    	Stock s = new Stock(p, qE, listStock.size()+1, c);
    	listStock.add(s);
    }
    
	// Recherche d'un stock par son ID
	public Stock rchStock(int id) {
		Stock[] t = new Stock[listStock.size()];
		for (int i = 0; i < listStock.size(); i++) {
			if(listStock.toArray(t)[i].idStock==id) {
				return (Stock) listStock.toArray()[i];
			}
		}
		return null;
	}
	
    /////////////////////////////////////////////
    //-----------------CLIENTS-----------------//
    /////////////////////////////////////////////
	
    // Recherche d'un client par son nom et prénom
	
    public Client rchCli(String n, String p, int id) {
        Client[] t = new Client[listClient.size()];
        for (int i = 0; i < listCom.size(); i++) {
            if((listClient.toArray(t)[i].nom==n) && (listClient.toArray(t)[i].prenom== p) && (listClient.toArray(t)[i].idClient == id)) {
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
    
    // Recherche d'un client par son ID
    
    public Client rchClient(int id) {
    	Client[] rch = new Client[listClient.size()];
        for (int i = 0; i < listClient.size(); i++) {
            if(listClient.toArray(rch)[i].idClient == id) {
                return (Client) listClient.toArray()[i];
            }
        }
        return null;
    }
    
    // Recherche d'un client par son nom
    
    public Client listDatCompCli(String n) {
    	Set<Client> sNom = new HashSet<>();
    	Client[] tab = new Client[listClient.size()];
        for (int i = 0; i < listClient.size(); i++) {
        	if(listClient.toArray(tab)[i].nom == n) {
        		sNom.add(listClient.toArray(tab)[i]);
            }
        }
        return (Client) sNom;
    }
    
    // Liste des commandes d'un client
    
    public Commande listComCli(Client c) {
    	if(c.listCom!=null) {
    		return (Commande) c.listCom;
    	}
    	return null;
    }
    
    // Liste des clients possédant la même date de création de compte
    
    public Client listDatCompCli(Date d) {
    	
    	Set<Client> s = new HashSet<>();
    	Client[] tab = new Client[listClient.size()];
        for (int i = 0; i < listClient.size(); i++) {
        	if(listClient.toArray(tab)[i].dateCreationCompte == d) {
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
		if(adr != m_adresse) {
			m_adresse=adr; 
			return 0;
		}
		else {
			return-1;
		}
    }
    
    // Modification du nom du magasin
    
    public int updateNom(String n) {
		if(n != m_nom) {
			m_nom=n; 
			return 0;
		}
		else {
			return-1;
		}
    }
    
    //////////////////////////////////////////////
    //-----------------EMPLOYÉS-----------------//
    //////////////////////////////////////////////
    
    // Ajout d'un employé
    
    public int addEmp(Employe e) {
    	if(!listEmp.contains(e)) {
    		listEmp.add(e);
    		return 0;
    	} else {
    		return -1;
    	}
    }
    
    // Suppression d'un employé
    
    public int supEmp(Employe e) {
    	if(listEmp.contains(e)) {
    		listEmp.remove(e);
    		return 0;
    	} else {
    		return -1;
    	}
    }
	
    // Recherche d'un employé par son ID
    
    public Employe rchEmp(int id) {
    	Employe[] rch = new Employe[listEmp.size()];
        for (int i = 0; i < listCom.size(); i++) {
            if(listEmp.toArray(rch)[i].idEmp == id) {
                return (Employe) listEmp.toArray()[i];
            }
        }
        return null;
    }
    
    // Recherche d'un employé par son nom
    
    public Set<Employe> listEmpNom(String n, String p) {
    	Set<Employe> sNom = new HashSet<>();
    	Employe[] tab = new Employe[listEmp.size()];
        for (int i = 0; i < listEmp.size(); i++) {
        	if(listEmp.toArray(tab)[i].nom == n) {
        		sNom.add(listEmp.toArray(tab)[i]);
            }
        }
        return sNom;
    }
    
    // Liste de tous les employés ayant le même poste
    
    public Set<Employe> listEmpPos(String f) {
    	Set<Employe> samePoste = new HashSet<>();
    	Employe[] tab = new Employe[listEmp.size()];
        for (int i = 0; i < listEmp.size(); i++) {
        	if(listEmp.toArray(tab)[i].fonction == f) {
        		samePoste.add(listEmp.toArray(tab)[i]);
            }
        }
        return samePoste;
    }
    
    // Liste de tous les employés ayant le même salaire
    
    public Set<Employe> listEmpSalaire(float s) {
    	Set<Employe> sameSalai = new HashSet<>();
    	Employe[] tab = new Employe[listEmp.size()];
        for (int i = 0; i < listEmp.size(); i++) {
        	if(listEmp.toArray(tab)[i].salaire == s) {
        		sameSalai.add(listEmp.toArray(tab)[i]);
            }
        }
        return sameSalai;
    }
    
    public static void main(String[] argv) {
    }
}
