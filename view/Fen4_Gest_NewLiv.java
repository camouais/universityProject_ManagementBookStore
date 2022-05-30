package view;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

import javax.swing.*;

import controller.NewDepense;
import controller.NewLivre;
import model.*;

public class Fen4_Gest_NewLiv extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	String v = String.valueOf(LocalDate.now().toString());
	String strArray[] = v.split("-");
	
	public Fen4_Gest_NewLiv(Magasin m) {
		
		// Fenêtre

		Toolkit tk = Toolkit.getDefaultToolkit();  
        Image img = tk.getImage("src/resources/logo.png");
		setIconImage(img);
		JPanel p = new JPanel();
		setTitle("Création d'un nouveau livre");
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 850);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Labels
		
		JLabel l_rens = new JLabel("Renseignements du nouveau livre");
		l_rens.setHorizontalAlignment(SwingConstants.CENTER);
		l_rens.setFont(new Font("Tahoma", Font.BOLD, 35));
		l_rens.setBounds(0, 0, 784, 89);
		p.add(l_rens);
		
		JLabel l_titre = new JLabel("Titre :");
		l_titre.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_titre.setBounds(35, 100, 190, 31);
		p.add(l_titre);
		
		JLabel l_auteur = new JLabel("Auteur :");
		l_auteur.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_auteur.setBounds(35, 180, 190, 31);
		p.add(l_auteur);
			
		JLabel l_editeur = new JLabel("Editeur :");
		l_editeur.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_editeur.setBounds(35, 260, 190, 31);
		p.add(l_editeur);
		
		JLabel l_prix = new JLabel("Prix : ");
		l_prix.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_prix.setBounds(35, 340, 190, 31);
		p.add(l_prix);
		
		JLabel l_categorie = new JLabel("Cat\u00E9gorie :");
		l_categorie.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_categorie.setBounds(430, 100, 190, 31);
		p.add(l_categorie);
		
		JLabel l_langueVO = new JLabel("Langue originale :");
		l_langueVO.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_langueVO.setBounds(430, 180, 319, 31);
		p.add(l_langueVO);
		
		JLabel l_idEmploye = new JLabel("Identifiant employ\u00E9");
		l_idEmploye.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_idEmploye.setBounds(35, 560, 319, 31);
		p.add(l_idEmploye);
		
		JLabel l_nomEmploye = new JLabel("Nom employ\u00E9");
		l_nomEmploye.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_nomEmploye.setBounds(430, 560, 319, 31);
		p.add(l_nomEmploye);
		
		JLabel l_preEmploye = new JLabel("Pr\u00E9nom employ\u00E9");
		l_preEmploye.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_preEmploye.setBounds(430, 640, 319, 31);
		p.add(l_preEmploye);
		
		JLabel l_prix_1 = new JLabel("Stock initial :");
		l_prix_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_prix_1.setBounds(35, 440, 190, 31);
		p.add(l_prix_1);
		
		JLabel l_jour = new JLabel("Jour");
		l_jour.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 20));
		l_jour.setBounds(430, 295, 80, 31);
		p.add(l_jour);
		
		JLabel l_mois = new JLabel("Mois");
		l_mois.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 20));
		l_mois.setBounds(530, 295, 80, 31);
		p.add(l_mois);
		
		JLabel l_annee = new JLabel("Ann\u00E9e");
		l_annee.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 20));
		l_annee.setBounds(630, 295, 80, 31);
		p.add(l_annee);
		
		JLabel l_pStock = new JLabel("Prix du stock :");
		l_pStock.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_pStock.setBounds(430, 440, 190, 31);
		p.add(l_pStock);
		
		JLabel l_dateP = new JLabel("Date de parution : ");
		l_dateP.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_dateP.setBounds(430, 260, 319, 31);
		p.add(l_dateP);
		
		// TextFields
		
		JTextField t_titre = new JTextField();
		t_titre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t_titre.setBounds(35, 140, 319, 31);
		p.add(t_titre);
		t_titre.setColumns(10);
		
		JTextField t_auteur = new JTextField();
		t_auteur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t_auteur.setColumns(10);
		t_auteur.setBounds(35, 220, 319, 31);
		p.add(t_auteur);
		
		JTextField t_editeur = new JTextField();
		t_editeur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t_editeur.setColumns(10);
		t_editeur.setBounds(35, 300, 319, 31);
		p.add(t_editeur);
		
		JTextField t_prix = new JTextField();
		t_prix.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t_prix.setColumns(10);
		t_prix.setBounds(35, 380, 319, 31);
		p.add(t_prix);
		
		JTextField t_categorie = new JTextField();
		t_categorie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t_categorie.setColumns(10);
		t_categorie.setBounds(430, 140, 319, 31);
		p.add(t_categorie);
		
		JTextField t_langueVO = new JTextField();
		t_langueVO.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t_langueVO.setColumns(10);
		t_langueVO.setBounds(430, 220, 319, 31);
		p.add(t_langueVO);
		
		JTextField t_pStock = new JTextField();
		t_pStock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t_pStock.setColumns(10);
		t_pStock.setBounds(430, 480, 319, 31);
		p.add(t_pStock);
		
		
		JTextField t_idEmploye = new JTextField();
		t_idEmploye.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t_idEmploye.setColumns(10);
		t_idEmploye.setBounds(35, 600, 319, 31);
		p.add(t_idEmploye);
		
		JTextField t_nomEmploye = new JTextField();
		t_nomEmploye.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t_nomEmploye.setColumns(10);
		t_nomEmploye.setBounds(430, 600, 319, 31);
		p.add(t_nomEmploye);
		
		JTextField t_preEmploye = new JTextField();
		t_preEmploye.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t_preEmploye.setColumns(10);
		t_preEmploye.setBounds(430, 680, 319, 31);
		p.add(t_preEmploye);
		
		JTextField t_stock = new JTextField("0");
		t_stock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t_stock.setColumns(10);
		t_stock.setBounds(35, 480, 319, 31);
		p.add(t_stock);
		
		JTextField t_annee = new JTextField();
		t_annee.setColumns(10);
		t_annee.setBounds(630, 330, 80, 22);
		p.add(t_annee);
		
		// ComboBoxes
		
		JComboBox<String> c_jour = new JComboBox<String>();
		c_jour.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		c_jour.setBounds(430, 330, 80, 22);
		p.add(c_jour);
		
		JComboBox<String> c_mois = new JComboBox<String>();
		c_mois.setModel(new DefaultComboBoxModel<String>(new String[] {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"}));
		c_mois.setBounds(530, 330, 80, 22);
		p.add(c_mois);
		
		// Boutons
		
		JButton b_retour = new JButton("Retour");
		b_retour.setBackground(new Color(200, 100, 100));
		b_retour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b_retour.setBounds(0, 781, 100, 30);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen3_Gest_Liv(m);
			}
		});
		p.add(b_retour);
		
		JButton b_enregistrer = new JButton("Enregistrer");
		b_enregistrer.setBackground(new Color(100, 200, 100));
		b_enregistrer.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_enregistrer.setBounds(267, 730, 250, 60);
		b_enregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(new NewDepense(m, t_idEmploye, t_nomEmploye , t_preEmploye, t_pStock, "Achat nouveau stock").status == 1) {
					if(new NewLivre(m, t_titre, t_auteur, t_editeur, c_jour, c_mois, t_annee, t_prix, t_categorie, t_stock).status == 1) {
						new Fen3_Gest_Liv(m);
						dispose();
						JFrame a = new JFrame();
					    JOptionPane.showMessageDialog(a, "Livre cr\u00E9\u00E9 et ajout\u00E9 \u00E0 la base de donn\u00E9es.", "Succ\u00E8s", 1);
					}
				}
			}
		});
		p.add(b_enregistrer);
		
		// Séparation
		
		JPanel sep = new JPanel();
		sep.setBackground(Color.BLACK);
		sep.setBounds(35, 540, 714, 4);
		p.add(sep);
	}
}