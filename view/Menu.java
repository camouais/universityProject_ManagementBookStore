package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.awt.*;
import java.util.*;
 
public class Menu extends JFrame{
	// Define new buttons
    JButton jb1 = new JButton("Gestion");
    JButton jb2 = new JButton("Achat");
     
	
    JFrame frame = new JFrame("Menu");
    JPanel panel = new JPanel();
    
public Menu() {

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); 
    frame.setResizable(false);
    
    panel.setBackground(Color.lightGray);
    frame.add(panel, BorderLayout.CENTER);
    panel.setBorder(new EmptyBorder(new Insets(250, 360, 250, 360)));
 
    
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    
    //bouton gestion
    jb1.setMargin(new Insets(2,30,2,30));
    jb1.setFont(new Font("Arial", Font.BOLD, 80));
    jb1.setBackground(Color.GREEN);
    panel.add(jb1);
    panel.add(Box.createVerticalStrut(40));
    
    //bouton achat
    jb2.setMargin(new Insets(2,70,2,70));
    jb2.setFont(new Font("Arial", Font.BOLD, 80));
    jb2.setBackground(Color.yellow);
    panel.add(jb2);
    panel.add(Box.createVerticalStrut(40));
    
    frame.add(panel);
    frame.setSize(1200,800); 
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

	    }
		  
	  
 
    public static void main(String[] args) {
        new Menu();
    }
 
   
    
}