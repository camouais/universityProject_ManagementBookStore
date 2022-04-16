package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fen_4_Ach_DoAch extends JFrame{
	
	private JPanel contentPane;
	private JTextField txtRecherchezUnLivre;
	
	String[] data = {"sdfsd", "qsdfqsdf", "sdqsd", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "a", "dqsd", "sddq", "sddq", "sddq", "sddq", "sddq"
			,"sdfsd", "qsdfqsdf", "sdqsd", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "a", "dqsd", "sddq", "sddq", "sddq", "sddq", "sddq"
			,"sdfsd", "qsdfqsdf", "sdqsd", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "a", "dqsd", "sddq", "sddq", "sddq", "sddq", "sddq"
			,"sdfsd", "qsdfqsdf", "sdqsd", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "a", "dqsd", "sddq", "sddq", "sddq", "sddq", "sddq"
			,"sdfsd", "qsdfqsdf", "sdqsd", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "sddq", "a", "dqsd", "sddq", "sddq", "sddq", "sddq", "sddq"
			};
    
    JList<String> list = new JList<String>(data);
    JList<String> list2 = new JList<String>();
    DefaultListModel<String> model;
    JScrollPane scrollPane = new JScrollPane();
    JScrollPane scrollPane2 = new JScrollPane();
    public static int count = 0;
	
	public Fen_4_Ach_DoAch() {
		
		// Fenêtre
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(153, 204, 255));
		
		// Panel 1 (Liste de livres)
		
		JPanel panel1 = new JPanel();
        list.setFont(new Font("Tahoma", Font.PLAIN, 15));
        scrollPane.setViewportView(list);
        list.setLayoutOrientation(JList.VERTICAL);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel1.setBounds(50, 150, 400, 400);
        panel1.setLayout(null);
        scrollPane.setBounds(0, 0, 400, 400);
        panel1.add(scrollPane);
        contentPane.add(panel1);
        
        // Panel 2 (Liste d'articles)
        
        model=new DefaultListModel<String>();
        list2.setModel(model);
        
		JPanel panel2 = new JPanel();
		list2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        scrollPane2.setViewportView(list2);
        list2.setLayoutOrientation(JList.VERTICAL);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel2.setBounds(540, 100, 400, 395);
		panel2.setLayout(null);
		scrollPane2.setBounds(0, 0, 400, 395);
		panel2.add(scrollPane2);
		contentPane.add(panel2);

		// Textfield - Recherche de livres
		
		txtRecherchezUnLivre = new JTextField();
		txtRecherchezUnLivre.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtRecherchezUnLivre.setText("Recherchez un livre");
		txtRecherchezUnLivre.setBounds(50, 100, 400, 45);
		contentPane.add(txtRecherchezUnLivre);
		txtRecherchezUnLivre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("R\u00E9alisation de l'achat");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel.setBounds(10, 11, 964, 57);
		contentPane.add(lblNewLabel);
		
		// Bouton "Effacer"
		
		JButton btnEffacer = new JButton("Effacer");
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEffacer.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnEffacer.setBounds(540, 500, 400, 50);
		contentPane.add(btnEffacer);
		
		// Bouton "Tout Effacer"
		
		JButton btnTEffacer = new JButton("Tout Effacer");
		btnTEffacer.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnTEffacer.setBounds(540, 555, 400, 50);
		contentPane.add(btnTEffacer);
		
		// Bouton "Ajouter"
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(list.getSelectedValue()!=null) {
	                model.addElement("Test n°"+count);
	                count++;
                }           
            }
		});
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAjouter.setBounds(50, 555, 400, 50);
		contentPane.add(btnAjouter);
		
		// Bouton "Retour"
		
        JButton btnRetour = new JButton("Retour");
        btnRetour.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 30));
        btnRetour.setBounds(50, 650, 400, 60);
        contentPane.add(btnRetour);
		
		// Bouton "Enregistrer"
        
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEnregistrer.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnEnregistrer.setBounds(540, 650, 400, 60);
		contentPane.add(btnEnregistrer);
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen_4_Ach_DoAch frame = new Fen_4_Ach_DoAch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
