package view;

import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;
import javax.swing.border.*;
import model.*;

public class Fen5_Ach_Fact extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public Fen5_Ach_Fact(Magasin m, Client c, Commande cm, DefaultListModel<String> mod) {
		
		// Fenêtre
		
		JPanel p = new JPanel();
		Toolkit tk = Toolkit.getDefaultToolkit();  
        Image img = tk.getImage("src/resources/logo.png");
		setIconImage(img);
		setTitle("Résumé de l'achat");
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		p.setBackground(SystemColor.inactiveCaption);
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 580);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Labels : Client, Facture, Prix, Achats
		
		JLabel l_facture = new JLabel("Facture ");
		l_facture.setHorizontalAlignment(SwingConstants.CENTER);
		l_facture.setFont(new Font("Arial", Font.BOLD, 42));
		l_facture.setBounds(0, 0, 484, 100);
		p.add(l_facture);
		
		JLabel l_client = new JLabel("Client : ");
		l_client.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l_client.setBounds(25, 100, 100, 30);
		p.add(l_client);
		
		JLabel l_prix = new JLabel("Prix : ");
		l_prix.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l_prix.setBounds(25, 425, 100, 40);
		p.add(l_prix);
		
		JLabel l_achats = new JLabel("Achats : ");
		l_achats.setHorizontalAlignment(SwingConstants.CENTER);
		l_achats.setFont(new Font("Tahoma", Font.BOLD, 25));
		l_achats.setBounds(0, 139, 484, 40);
		p.add(l_achats);
		
		// Text Fields : Client, Prix
		
		JTextField t_client;
		t_client = new JTextField(c.getNom() + " " + c.getPrenom() + " (" + c.getMail() + ")");
		t_client.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t_client.setBounds(125, 100, 325, 30);
		t_client.setEditable(false);
		p.add(t_client);
		t_client.setColumns(10);
		
		float pT = 0;
		for(int i = 0; i < cm.listLivres.size(); i++) {
        	pT += (((Livre) cm.listLivres.toArray()[i]).getPrix());
        }
		pT = Math.round(pT*100f)/100f;
		
		JTextField t_prix;
		t_prix = new JTextField("Prix total = " + String.valueOf(pT) + " \u20AC");
		t_prix.setHorizontalAlignment(SwingConstants.RIGHT);
		t_prix.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_prix.setBackground(SystemColor.activeCaption);
		t_prix.setBounds(100, 425, 350, 40);
		t_prix.setEditable(false);
		p.add(t_prix);
		t_prix.setColumns(10);
		
		JPanel p_achats = new JPanel();
		p_achats.setBounds(40, 180, 400, 236);
		p_achats.setLayout(null);
		p.add(p_achats);
		
		// Liste 1 : Livres
		
		JPanel p_livres = new JPanel();
		p_livres.setBounds(0, 0, 400, 236);
		p_achats.add(p_livres);
		p_livres.setLayout(null);
		
		JList<String> l_Livres = new JList<String>();
		l_Livres.setModel(mod);
		l_Livres.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		l_Livres.setBounds(0, 0, 400, 236);
		p_livres.add(l_Livres);
		
		// Boutons : Enregistrer, Retour
		
		JButton b_enreg = new JButton("Enregistrer");
		b_enreg.setBackground(new Color(100, 200, 100));
		b_enreg.setFont(new Font("Tahoma", Font.PLAIN, 25));
		b_enreg.setBounds(162, 480, 160, 41);
		b_enreg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < cm.listLivres.size(); i++) {
					m.decStockLiv((((Livre) cm.listLivres.toArray()[i])),1);
				}
				m.addCom(cm);
				c.listCom.add(cm);
				try {
					FileOutputStream fout = new FileOutputStream("src/data/m_" + m.getNom() + "/data.txt");
					ObjectOutputStream out = new ObjectOutputStream(fout);
					out.writeObject(m);    
					out.flush();
					out.close();
				} catch(Exception ex) {
					System.out.println(e);
				}
				JFrame a = new JFrame();
				dispose();
				new Fen1(m);
			    JOptionPane.showMessageDialog(a, "Achat enregistré !", "Succès", 1);
			}
		});
		p.add(b_enreg);
		
		JButton b_retour = new JButton("Retour");
		b_retour.setBackground(new Color(200, 100, 100));
		b_retour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b_retour.setBounds(0, 511, 100, 30);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen4_Ach_DoAch(m,c);
			}
		});
		p.add(b_retour);
	}
}