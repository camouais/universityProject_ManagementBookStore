package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import controller.ListLivres;
import controller.RechercheLivre;
import model.*;

public class Fen3_Gest_Liv extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel p = new JPanel();
	private DefaultListModel<String> model;
	private DefaultListModel<String> model2;
	private JScrollPane scrollPane = new JScrollPane();
	private JScrollPane scrollPane2 = new JScrollPane();
	private JList<String> list = new JList<String>();
	private JList<String> list2 = new JList<String>();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	public static int count = 0;
	private JTextField t_rech= new JTextField();
	private JLabel l_main = new JLabel("Gestion des livres");
	
	JButton b_modifier = new JButton("Modifier");
	JButton b_ajouter = new JButton("Ajouter");
	JButton b_retour = new JButton("RETOUR");
	JButton b_clearSearch = new JButton("X");
	
	public Fen3_Gest_Liv(Magasin m) {
		
		ListLivres l = new ListLivres(m, m.listLivre);
		
		// FenÃªtre
		
		p = new JPanel();
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		p.setBackground(new Color(119, 181, 254));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Liste 1 (Liste d'employÃ©s)

        model = new DefaultListModel<String>();
        for (int i = 0; i < l.getList().length; i++) {
			for (int j = 0; j < l.getList().length; j++) {
				if (Integer.parseInt((l.getList()[i]).split(" ")[0]) < Integer.parseInt((l.getList()[j]).split(" ")[0])) {
					String temp = l.getList()[i];
					l.getList()[i] = l.getList()[j];
					l.getList()[j] = temp;
				}
			}
		}
        for(int i = 0; i < l.getList().length; i++) {
        	model.addElement(l.getList()[i]);
        	System.out.printf("a");
        }
        list.setModel(model);
		
        list.setFont(new Font("Tahoma", Font.PLAIN, 15));
        scrollPane.setViewportView(list);
        list.setLayoutOrientation(JList.VERTICAL);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel1.setBounds(50, 175, 400, 440);
        panel1.setLayout(null);
        scrollPane.setBounds(0, 0, 400, 440);
        panel1.add(scrollPane);
        p.add(panel1);
        
        // Liste 2 (Informations de l'employÃ© sÃ©lectionnÃ©)
        
        model2 = new DefaultListModel<String>();
        list2.setModel(model2);
        
		list2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        scrollPane2.setViewportView(list2);
        list2.setLayoutOrientation(JList.VERTICAL);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel2.setBounds(540, 175, 400, 345);
		panel2.setLayout(null);
		scrollPane2.setBounds(0, 0, 400, 345);
		panel2.add(scrollPane2);
		p.add(panel2);

		// Textfield - Recherche d'un livre
		
		t_rech.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_rech.setText("Recherchez un livre");
		t_rech.setBounds(50, 100, 345, 45);
		t_rech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.clear();
				String[] a = new ListLivres(m, new RechercheLivre(m, t_rech).getList()).getList();
				if(a.length == 0) {
					if(t_rech.getText().equals("")) {
				        for(int i = 0; i < l.getList().length; i++) {
				        	model.addElement(l.getList()[i]);
				        }
					}
				} else {
					ListLivres def = new ListLivres(m,new RechercheLivre(m, t_rech).getList());
			        for (int i = 0; i < def.getList().length; i++) {
						for (int j = 0; j < def.getList().length; j++) {
							if (Integer.parseInt((def.getList()[i]).split(" ")[0]) < Integer.parseInt((def.getList()[j]).split(" ")[0])) {
								String temp = def.getList()[i];
								def.getList()[i] = def.getList()[j];
								def.getList()[j] = temp;
							}
						}
					}
					for (int i = 0; i < def.getList().length; i++) {
						model.addElement(def.getList()[i]);
					}
				}
			}
		});
		
		p.add(t_rech);
		t_rech.setColumns(10);
		
		// JLabel "Livres"
		
		l_main.setHorizontalAlignment(SwingConstants.CENTER);
		l_main.setFont(new Font("Arial", Font.BOLD, 50));
		l_main.setBounds(10, 15, 964, 57);
		p.add(l_main);
		
		// Boutons : Modifier, Ajouter, Retour
		
		b_modifier.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b_modifier.setBounds(540, 555, 400, 60);
		b_modifier.setBackground(new Color(200, 200, 100));
		b_modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen4_Gest_ModifLiv(m);
			}
		});
		p.add(b_modifier);
		
		b_ajouter.setIcon(null);
		b_ajouter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedValue()!=null) {
					model.addElement("Test nÂ°"+count);
					count++;
				}         
			}
		});
		b_ajouter.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b_ajouter.setBounds(50, 650, 400, 60);
		b_ajouter.setBackground(new Color(100, 200, 120));
		p.add(b_ajouter);
        
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen2_Gest(m);
			}
		});
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_retour.setBounds(540, 650, 400, 60);
		b_retour.setBackground(new Color(200, 100, 100));
		p.add(b_retour);
		

		b_clearSearch.setForeground(new Color(255, 255, 255));
		b_clearSearch.setBackground(new Color(165, 42, 42));
		b_clearSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		b_clearSearch.setBounds(405, 100, 45, 45);
		b_clearSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t_rech.setText("");
				model.clear();
				for (int i = 0; i < l.getList().length; i++) {
					for (int j = 0; j < l.getList().length; j++) {
						if (Integer.parseInt((l.getList()[i]).split(" ")[0]) < Integer.parseInt((l.getList()[j]).split(" ")[0])) {
							String temp = l.getList()[i];
							l.getList()[i] = l.getList()[j];
							l.getList()[j] = temp;
						}
					}
				}
		        for(int i = 0; i < l.getList().length; i++) {
		        	model.addElement(l.getList()[i]);
		        }
			}
		});
		p.add(b_clearSearch);
	}
}
