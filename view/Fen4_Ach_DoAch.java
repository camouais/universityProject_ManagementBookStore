package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import model.*;
import controller.*;

public class Fen4_Ach_DoAch extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
    public static int count = 0;
    
	private JPanel p = new JPanel();
	private DefaultListModel<String> model;
	private DefaultListModel<String> model2;
	private JScrollPane scrollPane = new JScrollPane();
	private JScrollPane scrollPane2 = new JScrollPane();
	private JList<String> list = new JList<String>();
	private JList<String> list2 = new JList<String>();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JLabel l_achat = new JLabel("R\u00E9alisation de l'achat");
	private JTextField t_rech = new JTextField();
	
	JButton b_effacer = new JButton("Effacer");
	JButton b_tEffacer = new JButton("Tout Effacer");
	JButton b_ajouter = new JButton("Ajouter");
    JButton b_retour = new JButton("Retour");
	JButton b_enregistrer = new JButton("Enregistrer");

	public Fen4_Ach_DoAch(Magasin m, Client c) {
		
		ListLivres t = new ListLivres(m);
		
		// FenÃªtre
		
		p = new JPanel();
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Panel 1 (Liste de livres)

        model = new DefaultListModel<String>();
        for(int i = 0; i < t.getList().length; i++) {
        	model.addElement(t.getList()[i]);
        }
        list.setModel(model);
        list.setFont(new Font("Tahoma", Font.PLAIN, 15));
        scrollPane.setViewportView(list);
        list.setLayoutOrientation(JList.VERTICAL);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel1.setBounds(50, 150, 400, 400);
        panel1.setLayout(null);
        scrollPane.setBounds(0, 0, 400, 400);
        panel1.add(scrollPane);
        p.add(panel1);
        
        // Panel 2 (Liste d'articles)
        
        model2 = new DefaultListModel<String>();
        list2.setModel(model2);
        
		list2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        scrollPane2.setViewportView(list2);
        list2.setLayoutOrientation(JList.VERTICAL);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel2.setBounds(540, 100, 400, 395);
		panel2.setLayout(null);
		scrollPane2.setBounds(0, 0, 400, 395);
		panel2.add(scrollPane2);
		p.add(panel2);

		// Textfield - Recherche de livres
		
		t_rech.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_rech.setText("Recherchez un livre");
		t_rech.setBounds(50, 100, 400, 45);
		p.add(t_rech);
		t_rech.setColumns(10);
		
		// JLabel RÃ©alisation de l'achat
		
		l_achat.setHorizontalAlignment(SwingConstants.CENTER);
		l_achat.setFont(new Font("Tahoma", Font.BOLD, 36));
		l_achat.setBounds(10, 11, 964, 57);
		p.add(l_achat);
		
		// Boutons : Effacer, Tout Effacer, Ajouter, Retour, Enregistrer
		
		b_effacer.setBackground(new Color(58, 2, 13));
		b_effacer.setForeground(Color.WHITE);
		b_effacer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b_effacer.setBounds(540, 500, 400, 50);
		b_effacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list2.getSelectedValue()!=null) {
					model2.removeElement(list2.getSelectedValue());
				}
			}
		});
		p.add(b_effacer);
		
		b_tEffacer.setBackground(new Color(0, 0, 0));
		b_tEffacer.setForeground(Color.WHITE);
		b_tEffacer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b_tEffacer.setBounds(540, 555, 400, 50);
		p.add(b_tEffacer);
		
		b_ajouter.setBackground(new Color(150, 255, 150));
		b_ajouter.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b_ajouter.setBounds(50, 555, 400, 50);
		b_ajouter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(list.getSelectedValue()!=null) {
	                model2.addElement(list.getSelectedValue());
	                count++;
                }
            }
		});
		p.add(b_ajouter);
		
        b_retour.setBackground(new Color(255, 255, 0));
        b_retour.setFont(new Font("Tahoma", Font.PLAIN, 30));
        b_retour.setBounds(50, 650, 400, 60);
        b_retour.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		new Fen2_Ach(m);
        	}
        });
        p.add(b_retour);
        
		b_enregistrer.setBackground(new Color(1, 215, 88));
		b_enregistrer.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_enregistrer.setBounds(540, 650, 400, 60);
		b_enregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen5_Ach_Fact(m,c);
			}
		});
		p.add(b_enregistrer);
		
		JFrame error = new JFrame();
		int a = m.listLivre.size();
		if(a == 0) {
			JOptionPane.showMessageDialog(error, "La liste de livres est vide", "Avertissement", 1);
		}
	}
}
