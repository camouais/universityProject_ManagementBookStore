package controller;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import model.*;
import view.*;

public class NewMagasin implements ActionListener {
    Magasin magasin;
    JTextField nom;
    
    public NewMagasin(JTextField n) {
        this.nom = n;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        magasin= new Magasin(nom.getText());
    }
}
