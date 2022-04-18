

package view;

import model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Fen3_Gest_Cl extends JFrame {
	
	String[] data = {"sdfsd", "qsdfqsdf", "sdqsd", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "a", "dqsd", "sddq", "sddq", "sddq", "sddq", "sddq"
			,"sdfsd", "qsdfqsdf", "sdqsd", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "a", "dqsd", "sddq", "sddq", "sddq", "sddq", "sddq"
			,"sdfsd", "qsdfqsdf", "sdqsd", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "a", "dqsd", "sddq", "sddq", "sddq", "sddq", "sddq"
			,"sdfsd", "qsdfqsdf", "sdqsd", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "a", "dqsd", "sddq", "sddq", "sddq", "sddq", "sddq"
			,"sdfsd", "qsdfqsdf", "sdqsd", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "a", "dqsd", "sddq", "sddq", "sddq", "sddq", "sddq"
			};
    
    JList<String> list = new JList<String>();
    JList<String> list2 = new JList<String>();
    DefaultListModel<String> model;
    JScrollPane scrollPane = new JScrollPane();
    JScrollPane scrollPane2 = new JScrollPane();
    public static int count = 0;
	private JPanel p = new JPanel();

	public Fen3_Gest_Cl() {
		
		// Fenêtre
		
		p = new JPanel();
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		p.setBackground(new Color(150, 131, 236));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Panel 1 (Liste de clients)
		
		JPanel panel1 = new JPanel();
        list.setFont(new Font("Tahoma", Font.PLAIN, 15));
        scrollPane.setViewportView(list);
        list.setLayoutOrientation(JList.VERTICAL);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel1.setBounds(50, 175, 400, 440);
        panel1.setLayout(null);
        scrollPane.setBounds(0, 0, 400, 440);
        panel1.add(scrollPane);
        p.add(panel1);
        
        // Panel 2 (Informations du client sélectionné)
        
        model=new DefaultListModel<String>();
        list2.setModel(model);
        
		JPanel panel2 = new JPanel();
		list2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        scrollPane2.setViewportView(list2);
        list2.setLayoutOrientation(JList.VERTICAL);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel2.setBounds(540, 175, 400, 345);
		panel2.setLayout(null);
		scrollPane2.setBounds(0, 0, 400, 345);
		panel2.add(scrollPane2);
		p.add(panel2);

		// Textfield - Recherche d'un client
		
		JTextField t_rechercheC= new JTextField();
		t_rechercheC.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_rechercheC.setText("Recherchez un livre...");
		t_rechercheC.setBounds(50, 100, 890, 45);
		p.add(t_rechercheC);
		t_rechercheC.setColumns(10);
		
		// JLabel "Clients"
		
		JLabel l_clients = new JLabel("Clients");
		l_clients.setHorizontalAlignment(SwingConstants.CENTER);
		l_clients.setFont(new Font("Arial", Font.BOLD, 50));
		l_clients.setBounds(10, 15, 964, 57);
		p.add(l_clients);
		
		// Bouton "Modifier"
		
		JButton b_modifier = new JButton("Modifier");
		b_modifier.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b_modifier.setBounds(540, 555, 400, 60);
		b_modifier.setBackground(new Color(200, 200, 100));
		b_modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fen4_Gest_ModifCli a = new Fen4_Gest_ModifCli();
				dispose();
			}
		});
		p.add(b_modifier);
		
		// Bouton "Ajouter"
		
		JButton b_ajouter = new JButton("Ajouter");
		b_ajouter.setIcon(null);
		b_ajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                       
            	Fen4_Gest_NewCli a = new Fen4_Gest_NewCli();
				dispose();
            }
		});
		b_ajouter.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b_ajouter.setBounds(50, 650, 400, 60);
		b_ajouter.setBackground(new Color(100, 200, 120));
		p.add(b_ajouter);
		
		// Bouton "Retour"
        
		JButton b_retour = new JButton("RETOUR");
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fen2_Gest a = new Fen2_Gest();
				dispose();
			}
		});
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_retour.setBounds(540, 650, 400, 60);
		b_retour.setBackground(new Color(200, 100, 100));
		p.add(b_retour);
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen3_Gest_Cl frame = new Fen3_Gest_Cl();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
