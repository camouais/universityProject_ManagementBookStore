package model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;

public class Magasin implements Serializable {
	
	// Attributs
	private static final long serialVersionUID = 1L;
	private String nom;
    private String adresse;
    private String mdp;
    private String tel;
    private String site;
    private LocalDate dateC; 
    public Set<Employe> listEmp = new HashSet<>();
    public Set<Client> listClient = new HashSet<>();
    public Set<Commande> listCom = new HashSet<>();
    public Set<Livre> listLivre = new HashSet<>();
    public Set<Depense> listDep = new HashSet<>();
    private int totalEmp = 0;
    private int totalCli = 0;
    private int totalCom = 0;
    private int totalLiv = 0;
    private int totalDep = 0;
    
    // Constructeur
    
    public Magasin(String name, String mdp) {
    	nom = name;
    	this.mdp = mdp;
    }
    
    // M�thodes
    
    //////////////////////////////////////////////
    //-----------------COMMANDES----------------//
    //////////////////////////////////////////////
    
    // Lister les commandes enregistrées 
    
    public Set<Commande> listCommandes(){
    	return listCom;
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
    
    // Ajout d'une commande
    
    public int addCom(Commande c) {
    	if(!listCom.contains(c)) {
        	totalCom++;
    		listCom.add(c);
    		return 0;
    	} 
    	return -1;
    }
    
    //////////////////////////////////////////////
    //-----------------DEPENSES-----------------//
    //////////////////////////////////////////////
    
    // Ajout d'une nouvelle d�pense
    
    public int addDepense(Depense d) {
    	if(!listDep.contains(d)) {
        	totalDep++;
    		listDep.add(d);
    		return 0;
    	}
    	return -1;
    }
    
    public int supDepense(Depense d) {
    	if(listDep.contains(d)) {
    		listDep.remove(d);
    		return 0;
    	}
    	return -1;
    }
    
   
    // Recherche d'une d�pense par son id 
    
    public Depense rchDep(int id) {
    	Depense[] t = new Depense[listDep.size()];
		for (int i = 0; i < listDep.size(); i++) {
			if(listDep.toArray(t)[i].getId()==id) {
				return (Depense) listDep.toArray()[i];
			}
		}
		return null;
    }
    
    // Recherche d'une d�pense par sa description
    
    public Depense getDepDesc(String d) {
    	Depense[] t = new Depense[listDep.size()];
		for (int i = 0; i < listDep.size(); i++) {
			if(listDep.toArray(t)[i].getDescription()==d) {
				return (Depense) listDep.toArray()[i];
			}
		}
		return null;
    }
    
    // Obtenir la valeur de la d�pense totale d'un magasin
    
    public float getAllDepenses(Magasin m) {
        float dep = 0.F;
        if(m.listDep!=null) {
            Object[] arrayDep = m.listDep.toArray();
            
            for(int i = 0; i < arrayDep.length; i++) {
                dep += ((Depense) arrayDep[i]).getCout();
            }
            return dep;
        }
        return dep;
    }
    
    ///////////////////////////////////////////
    //---------------- LIVRES----------------//
    ///////////////////////////////////////////
    
    // Enregistrement d'un livre 
    
    public int addLivre(Livre c) {
    	if(!listLivre.contains(c)) {
        	totalLiv++;
    		listLivre.add(c);
    		return 0;
    	}
    	return -1;
    }
    
    // Suppression d'un livre 
    
    public int supLivre(Livre c) {
    	if(listLivre.contains(c)) {
    		listLivre.remove(c);
    		return 0;
    	}
    	return -1;
    }
    
    // Obtenir le stock total des livres
    
    public int getAllStock(Magasin m) {
    	int stock = 0;
    	if(m.listLivre!=null) {
    		Object[] arrayLiv = m.listLivre.toArray();
    		
    		for(int i = 0; i < arrayLiv.length; i++) {
    			stock += ((Livre) arrayLiv[i]).getStock();
    		}
    		return stock;
    	}
    	return stock;
    }
    
    // Obtenir le stock intial des livres
    
    public int getAllInitStock(Magasin m) {
    	int stock = 0;
    	if(m.listLivre!=null) {
    		Object[] arrayLiv = m.listLivre.toArray();
    		
    		for(int i = 0; i < arrayLiv.length; i++) {
    			stock += ((Livre) arrayLiv[i]).getQtEntree();
    		}
    		return stock;
    	}
    	return stock;
    }
    
    // Obtenir le nombre de ventes total 
    
    public int getAllVentes(Magasin m) {
    	int vente = 0;
    	if(m.listLivre!=null) {
    		Object[] arrayLiv = m.listLivre.toArray();
    		
    		for(int i = 0; i < arrayLiv.length; i++) {
    			vente += ((Livre) arrayLiv[i]).qtSortie();
    		}
    		return vente;
    	}
    	return vente;
    }
    
    
    // Recherche d'un livre par son id
    public Livre rchLivreId(int id) {
		Livre[] t = new Livre[listLivre.size()];
		for (int i = 0; i < listLivre.size(); i++) {
			if(listLivre.toArray(t)[i].getId()==id) {
				return (Livre) listLivre.toArray()[i];
			}
		}
		return null;
    }
    
    
    // Recherche d'un livre par son titre
    public Livre rchLivre(String titre) {
		Livre[] t = new Livre[listLivre.size()];
		for (int i = 0; i < listLivre.size(); i++) {
			if(listLivre.toArray(t)[i].getTitre().equals(titre)) {
				return (Livre) listLivre.toArray()[i];
			}
		}
		return null;
    }
	
    // Decrementer le stock d'un livre
    public int decStockLiv(Livre l, int n) {
    	if(listLivre.contains(l)) {
    		l.decStock(1);
    		return 0;
    	}
    	return -1;
    }
    
    
    /////////////////////////////////////////////
    //-----------------CLIENTS-----------------//
    /////////////////////////////////////////////
	
    // Recherche d'un client par son nom et pr�nom
	
    public Client rchCli_npmail(String n, String p, String mail) {
        Client[] t = new Client[listClient.size()];
        for (int i = 0; i < listClient.size(); i++) {
            if((listClient.toArray(t)[i].getNom().equals(n)) && (listClient.toArray(t)[i].getPrenom().equals(p)) && (listClient.toArray(t)[i].getMail().equals(mail))) {
                return (Client) listClient.toArray()[i];
            }
        }
        return null;
    }
    // Recherche d'un client par son id
	
    public Client rchCli(int id) {
    	Client[] t = new Client[listClient.size()];
        for (int i = 0; i < listClient.size(); i++) {
            if(listClient.toArray(t)[i].getId() == id) {
                return (Client) listClient.toArray()[i];
            }
        }
        return null;
        
    }
    
    //Calcul age moyen des clients d'un magasin
    
    public String getMoyAge(Magasin m) {
    	if(m.listClient!=null) {
    		DecimalFormat df = new DecimalFormat("##.#");
    	
    		Object[] arrayClient = m.listClient.toArray();
    		float age = 0.F;
    		for(int i = 0; i < arrayClient.length; i++) {
    			age += ((Client) arrayClient[i]).getAge();
    		}
    		age = (age)/(arrayClient.length);
    		return df.format(age);
    	}
    	return null;
    }
    
    // Ajout d'un client
    
    public int addCli(Client c) {
    	if(!listClient.contains(c)) {
        	totalCli++;
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
    
    // Calul du panier moyen d'un client 
    
    public String panierMoy(Client c) {
    	
    	if(c.listCom.size()==0) {
    		return "None";
    	}else {
    	 return  String.valueOf((getPrixTotalComCli2(c))/ (c.listCom.size()));}
    }
    
    // Liste des commandes d'un client
    
    public Vector<Commande> listComCli(Client c) {
    	if(c.listCom!=null) {
    		return  c.listCom;
    	}
    	return null;
    }
    // Prix total des commandes d'un magasin
    
    public String getPrixTotalCom (Magasin m) {
    	if(m.listCom!=null) {
    		DecimalFormat df = new DecimalFormat("#.##");
    	
    		Object[] arrayCom = m.listCom.toArray();
    		float prixCount = 0.F;
    		for(int i = 0; i < arrayCom.length; i++) {
    			prixCount += ((Commande) arrayCom[i]).getPrixTotal2();
    		}
    		return df.format(prixCount);
    	}
    	return null;
    }
    // Prix total des commandes d'un client
    
    public String getPrixTotalComCli (Client c) {
    	if(c.listCom!=null) {
    		DecimalFormat df = new DecimalFormat("#.##");
    	
    		Object[] arrayCom = c.listCom.toArray();
    		float prixCount = 0.F;
    		for(int i = 0; i < arrayCom.length; i++) {
    			prixCount += ((Commande) arrayCom[i]).getPrixTotal2();
    		}
    		return df.format(prixCount);
    	}
    	return null;
    }
    // Prix total des commandes d'un client - version float 
    
    public float getPrixTotalComCli2 (Client c) {
    	if(c.listCom!=null) {
    		Object[] arrayCom = c.listCom.toArray();
    		float prixCount = 0.F;
    		for(int i = 0; i < arrayCom.length; i++) {
    			prixCount += ((Commande) arrayCom[i]).getPrixTotal2();
    		}
    		return (prixCount);
    	}
    	return 0.F;
    }
    
    
    // Liste des clients poss�dant la m�me date de cr�ation de compte
    
    public Client listDatCompCli(LocalDate d) {
        
        Set<Client> s = new HashSet<>();
        Client[] tab = new Client[listClient.size()];
        for (int i = 0; i < listClient.size(); i++) {
            if(listClient.toArray(tab)[i].getDateCC() == d) {
                s.add(listClient.toArray(tab)[i]);
            }
        }
        return (Client) s;
    }
    
   
    
    //////////////////////////////////////////////
    //-----------------EMPLOY�S-----------------//
    //////////////////////////////////////////////
    
    // Ajout d'un employé
    
    public int addEmp(Employe e) {
    	if(!listEmp.contains(e)) {
        	totalEmp++;
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
    	Employe[] t = new Employe[listEmp.size()];
        for (int i = 0; i < listEmp.size(); i++) {
            if(listEmp.toArray(t)[i].getId() == id) {
                return (Employe) listEmp.toArray()[i];
            }
        }
        return null;
        
    }
    
    // Recherche d'un employé par son id, nom et prénom
    
    public Employe rchEmpINP(int id,String n, String p) {
    	Employe[] tab = new Employe[listEmp.size()];
        for (int i = 0; i < listEmp.size(); i++) {
        	if((listEmp.toArray(tab)[i].getId() == id) && (listEmp.toArray(tab)[i].getNom().equals(n)) &&(listEmp.toArray(tab)[i].getPrenom().equals(p)) ) {
        		return  (Employe) (listEmp.toArray()[i]);
            }
        }
        return null;
    }
    
   
    
    // Liste de tous les employés ayant le même poste
    
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
    
    //Calcul age moyen des employés d'un magasin
    
    public String getEmpMoyAge(Magasin m) {
    	if(m.listEmp!=null) {
    		DecimalFormat df = new DecimalFormat("##.#");
    		Object[] arrayEmp = m.listEmp.toArray();
    		float age = 0.F;
    		for(int i = 0; i < arrayEmp.length; i++) {
    			age += ((Employe) arrayEmp[i]).getAge();
    		}
    		age = (age)/(arrayEmp.length);
    		return df.format(age);
    	}
    	return null;
    }
    
    //	Somme des salaires des employés d'un magasin
    
    public float getSomSalaire(Magasin m) {
    	if(m.listEmp!=null) {
    		
    		Object[] arrayEmp = m.listEmp.toArray();
    		float somme = 0.F;
    		for(int i = 0; i < arrayEmp.length; i++) {
    			somme += ((Employe) arrayEmp[i]).getSalaire();
    		}
    		
    		return somme;
    	}
    	return 0;
    }
    
    
    // Liste de tous les employés ayant le même salaire
    
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
	
	public String getPW() {
		return mdp;
	}
	
	public void setPW(String mdp) {
		this.mdp = mdp;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String a) {
		adresse = a;
	}
	
	public String getSite() {
		return site;
	}
	
	public void setSite(String s) {
		site = s;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String t) {
		tel = t;
	}
	
	public LocalDate getDateC() {
		return dateC;
	}
	
	public void setDateC(LocalDate d) {
		dateC = d;
	}
    
	public int getTEmp() {
		return totalEmp;
	}
	
	public int getTCom() {
		return totalCom;
	}
	
	public int getTCli() {
		return totalCli;
	}
	
	public int getTLiv() {
		return totalLiv;
	}
	
	public int getTDep() {
		return totalDep;
	}
}