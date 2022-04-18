package view;

import model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Fen4_Gest_MagEmp extends JFrame {
	
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

	public Fen4_Gest_MagEmp() {
		
		// Fenêtre
		
		p = new JPanel();
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		p.setBackground(new Color(233, 150, 122));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Panel 1 (Liste d'employés)
		
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
        
        // Panel 2 (Informations de l'employé sélectionné)
        
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

		// Textfield - Recherche d'un employé
		
		JTextField t_rech = new JTextField();
		t_rech.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_rech.setText("Recherchez un employé...");
		t_rech.setBounds(50, 100, 890, 45);
		p.add(t_rech);
		t_rech.setColumns(10);
		
		// JLabel "Employés"
		
		JLabel l_employes = new JLabel("Employ\u00E9s");
		l_employes.setHorizontalAlignment(SwingConstants.CENTER);
		l_employes.setFont(new Font("Arial", Font.BOLD, 50));
		l_employes.setBounds(10, 15, 964, 57);
		p.add(l_employes);
		
		// Bouton "Modifier"
		
		JButton b_modifier = new JButton("Modifier");
		b_modifier.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b_modifier.setBounds(540, 555, 400, 60);
		b_modifier.setBackground(new Color(200, 200, 100));
		b_modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fen5_Gest_ModifEmp a = new Fen5_Gest_ModifEmp();
				dispose();
			}
		});
		p.add(b_modifier);
		
		// Bouton "Ajouter"
		
		JButton b_ajouter = new JButton("Ajouter");
		b_ajouter.setIcon(null);
		b_ajouter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Fen5_Gest_NewEmp a = new Fen5_Gest_NewEmp();
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
				Fen3_Gest_Mag a = new Fen3_Gest_Mag();
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
					Fen4_Gest_MagEmp frame = new Fen4_Gest_MagEmp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
