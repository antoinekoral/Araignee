/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignée;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

/**
 *
 * @author antoine
 */
public class Araignée {

    public static void main(String[] args) {
        JFrame Fenetre = new JFrame ("Test");        
        Grille g=new Grille();
        Fenetre.setContentPane(g.Cadre);
        
        Fenetre.pack();
        Fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Fenetre.setVisible(true);
    }
    
}
