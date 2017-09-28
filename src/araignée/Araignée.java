/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignée;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author antoine
 */
public class Araignée {

    public static void main(String[] args) {
        
        Grille g = new Grille();
                             
        MyFrame MF = new MyFrame(g);
        JApplet lines = new DrawLines();
        MF.f.getContentPane().add("Center", lines);
        lines.init();
        
        JPanel Texte=new JPanel();
        JLabel Annonces=new JLabel ("TEXT",SwingConstants.CENTER);
        Texte.setPreferredSize(new Dimension(600,100));
        Texte.add(Annonces);
        
        JPanel Jeu = new JPanel();
        Jeu.setBackground(Color.white);
        Jeu.setLayout(new BoxLayout(Jeu,BoxLayout.PAGE_AXIS));
        Jeu.add(g.TopCadre);
        Jeu.add(Texte);
        MF.f.setContentPane(Jeu);
        MF.f.pack();
        MF.f.setJMenuBar(MF.menuBar);
        MF.f.setSize(new Dimension(600,600));
        MF.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MF.f.setVisible(true);
     }
   
}
