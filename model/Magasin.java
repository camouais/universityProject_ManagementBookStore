package model;

import java.util.*;

public class Magasin {
	//attributs
    public String m_nom;
    public String m_adresse;
    public Set<Employe> listEmp = new HashSet<>();
    public Set<Stock> listStock = new HashSet<>();
    public Set<Client> listClient = new HashSet<>();
    public Set<Commande>  listCom = new HashSet<>();
    public Set<Livre>  listLivre = new HashSet<>();
    
    
    //Constructeur
    public Magasin(String name, String adr) {
    	m_nom = name;
    	m_adresse = adr;
    	
    }
    
    //méthodes
    
    ///////////////////////////////////////////
    //---------------- COMMANDES---------------- 
    ////////////////////////////////////////////
    
    // Enregistrement d'une commande 
    
    public void addCommande(Commande c) {
    	listCom.add(c);
    }

    //Recherche une commande par un id 
    
    public Commande rchCm1(int id) {
        Commande[] rch = new Commande[listCom.size()];
        for (int i = 0; i < listCom.size(); i++) {
            if(listCom.toArray(rch)[i].idCom == id) {
                return (Commande) listCom.toArray()[i];
            }
        }
        return null;
    }
    
  //lister les commandes qui ont la même date 
    public Set<Commande> rchCm(Date d) {
    	Set<Commande> sameDate = new HashSet<>();
        Commande[] t1 = new Commande[listCom.size()];
        for (int i = 0; i < listCom.size(); i++) {
            if(listCom.toArray(t1)[i].dateAchat == d) {
            	sameDate.add(listCom.toArray(t1)[i]);
            }
        }
        return  sameDate;
    }
  //lister les commandes qui ont le même mode de paiement 
    public Set<Commande> rchCm(String mdp) {
    	Set<Commande> sameMdp = new HashSet<>();
        Commande[] t1 = new Commande[listCom.size()];
        
        for (int i = 0; i < listCom.size(); i++) {
            if( listCom.toArray(t1)[i].modePaiement == mdp) {
            	sameMdp.add(listCom.toArray(t1)[i]);
            }
        }
        return sameMdp;
    }
    
    ///////////////////////////////////////////
    //---------------- LIVRES---------------- 
    ////////////////////////////////////////////
    //enregistrer un livre 
    public int addLivre(Livre c) {
    	if(!listLivre.contains(c)) {
    		listLivre.add(c);
    		return 0;
    	}
    	return -1;
    }
    
   //suppprimer un livre 
    public int remLivre(Livre c) {
    	if(!listLivre.contains(c)) {
    		listLivre.remove(c);
    		return 0;
    	}
    	return -1;
    }
  //rechercher un livre 
    public int Livre(Livre c) {
    	if(!listLivre.contains(c)) {
    		listLivre.remove(c);
    		return 0;
    	}
    	return -1;
    }
	////////////////////////////////////////////
	//--------------EXEMPLAIRES---------------//
	////////////////////////////////////////////
	
	public int addEx(int id, int n) {
		Stock[] t = new Stock[listStock.size()];
		for (int j = 0; j < listStock.size(); j++) {
			if(listStock.toArray(t)[j].idStock==id) {
				for(int i = 0; i < n; i++) {
					Exemplaire e = new Exemplaire(listStock.toArray(t)[j].exemplaires.size()+1, listStock.toArray(t)[j].livre);
					listStock.toArray(t)[j].exemplaires.add(e);
				}
				return 0;
			}
		}
		return -1;
	}
	
	public int delEx(int id, int n) {
		Stock[] t = new Stock[listStock.size()];
		for (int j = 0; j < listStock.size(); j++) {
			if(listStock.toArray(t)[j].idStock==id) {
				for(int i = 0; i < n; i++) {
					Exemplaire e = new Exemplaire(listStock.toArray(t)[j].exemplaires.size()+1, listStock.toArray(t)[j].livre);
					listStock.toArray(t)[j].exemplaires.add(e);
				}
				return 0;
			}
		}
		return -1;
	}
	///////////////////////////////////////////
	//-----------------STOCKS----------------- 
	////////////////////////////////////////////
	
	
	//recherche un stock par un id
	public Stock rchStock(int id) {
		Stock[] t = new Stock[listStock.size()];
		for (int i = 0; i < listStock.size(); i++) {
			if(listStock.toArray(t)[i].idStock==id) {
				return (Stock) listStock.toArray()[i];
			}
		}
		return null;
	}
	
    ///////////////////////////////////////////
    //-----------------CLIENTS----------------- 
    ////////////////////////////////////////////
	
	//recherche un client par nom et prénom
    public Client rchCli(String n, String p) {
        Client[] t = new Client[listClient.size()];
        for (int i = 0; i < listCom.size(); i++) {
            if((listClient.toArray(t)[i].nom==n) && (listClient.toArray(t)[i].prenom== p)) {
                return (Client) listClient.toArray()[i];
            }
        }
        return null;
    }
    
    //ajouter un client
    public int addCli(Client c) {
    	if(!listClient.contains(c)) {
    		listClient.add(c);
    		return 0;
    	} 
    	return -1;
    	
    }
    
    //supprimer un client
    public int supCli(Client c) {
    	if(listClient.contains(c)) {
    		listClient.remove(c);
    		return 0;
    	} else {
    		return -1;
    	}
    }
    
    //recherche un client par un id 
    public Client rchClient(int id) {
    	Client[] rch = new Client[listClient.size()];
        for (int i = 0; i < listClient.size(); i++) {
            if(listClient.toArray(rch)[i].idClient == id) {
                return (Client) listClient.toArray()[i];
            }
        }
        return null;
    }
    
    //lister les commandes d'un client
    public Commande listComCli(Client c) {
    	if(c.listCom!=null) {
    		return (Commande) c.listCom;
    	}
    	return null;
    }
    
    //lister tous les clients qui ont la même date de création de compte
    public Set<Client> listDatCompCli(Date d) {
    	
    	Set<Client> s = new HashSet<>();
    	Client[] tab = new Client[listClient.size()];
        for (int i = 0; i < listClient.size(); i++) {
        	if(listClient.toArray(tab)[i].dateCreationCompte == d) {
            	s.add(listClient.toArray(tab)[i]);
            }
        }
        return s;
    }
    //lister tous les clients en fonction du nom
    public Set<Client> listDatCompCli(String n) {
    	
    	Set<Client> sNom = new HashSet<>();
    	Client[] tab = new Client[listClient.size()];
        for (int i = 0; i < listClient.size(); i++) {
        	if(listClient.toArray(tab)[i].nom == n) {
        		sNom.add(listClient.toArray(tab)[i]);
            }
        }
        return sNom;
    }

  //lister tous les clients qui ont la même adresse
    public Set<Client> listAdCli(String ad) {
    	
    	Set<Client> sameAd = new HashSet<>();
    	Client[] tab = new Client[listClient.size()];
        for (int i = 0; i < listClient.size(); i++) {
        	if(listClient.toArray(tab)[i].adresse == ad) {
        		sameAd.add(listClient.toArray(tab)[i]);
            }
        }
        return  sameAd;
    }
    ///////////////////////////////////////////
    //-----------------MAGASIN----------------- 
    ////////////////////////////////////////////
    
    //modifier l'adresse du magasin
    public int updateAdr(String adr) {
		if(adr != m_adresse) {
			m_adresse=adr; 
			return 0;
		}
		else {
			return-1;
		}
    }
    
    //modifier le nom du magasin
    public int updateNom(String n) {
		if(n != m_nom) {
			m_nom=n; 
			return 0;
		}
		else {
			return -1;
		}
    }
    
    ////////////////////////////////////////////
    //-----------------EMPLOYES----------------- 
    ////////////////////////////////////////////
    //supprimer un employé
    public int supEmp(Employe e) {
    	if(listEmp.contains(e)) {
    		listEmp.remove(e);
    		return 0;
    	} else {
    		return -1;
    	}
    }
    
	//ajouter un employé
    public int addEmp(Employe e) {
    	if(!listEmp.contains(e)) {
    		listEmp.add(e);
    		return 0;
    	} else {
    		return -1;
    	}
    }
    
    // Recher un employé un employé par son nom et prénom
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
    
    //lister tous les employés qui ont le même poste 
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
    
    //lister tous les employés qui ont le même salaire 
    public Set<Employe> listEmpSalaire(float s) {
    	
    	Set<Employe> sameSalai = new HashSet<>();
    	Employe[] tab = new Employe[listEmp.size()];
        for (int i = 0; i < listEmp.size(); i++) {
        	if(listEmp.toArray(tab)[i].salaire == s) {
        		sameSalai.add(listEmp.toArray(tab)[i]);
            }
        }
        return  sameSalai;
    }
    //recherche un employe par un id 
    public Employe rchEmp(int id) {
    	Employe[] rch = new Employe[listEmp.size()];
        for (int i = 0; i < listCom.size(); i++) {
            if(listEmp.toArray(rch)[i].idEmp == id) {
                return (Employe) listEmp.toArray()[i];
            }
        }
        return null;
    }
    public static void main(String[] argv) {
    	
    	
    	
    }
}