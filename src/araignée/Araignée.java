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
                             
        JFrame f = new JFrame("Jeu de l'araignée");
        JApplet lines = new DrawLines();
        f.getContentPane().add("Center", lines);
        lines.init();
        
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;

        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the first menu.
        menu = new JMenu("Play");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu);
        
        //a group of JMenuItems
        menuItem = new JMenuItem("New Party",
                                 KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu.add(menuItem);
        
        Grille g=new Grille();
        JPanel Texte=new JPanel();
        JLabel Annonces=new JLabel ("TEXT",SwingConstants.CENTER);
        Texte.setPreferredSize(new Dimension(600,100));
        Texte.add(Annonces);
        
        JPanel Jeu = new JPanel();
        Jeu.setBackground(Color.white);
        Jeu.setLayout(new BoxLayout(Jeu,BoxLayout.PAGE_AXIS));
        Jeu.add(g.TopCadre);
        Jeu.add(Texte);
        f.setContentPane(Jeu);
        f.pack();
        f.setJMenuBar(menuBar);
        f.setSize(new Dimension(600,600));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
     }
   
}
