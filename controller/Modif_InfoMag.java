package controller;

import java.awt.event.*;
import javax.swing.*;
import model.Magasin;

public class Modif_InfoMag {
    public Modif_InfoMag(Magasin m, JTextField f) {
        m.setNom(f.getText());
    }
}
