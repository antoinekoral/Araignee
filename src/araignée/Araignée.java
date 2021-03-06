/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignée;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author antoine
 */
public class Araignée {

    public static void main(String[] args) {
        
        //Création du JLabel comportant les messages aux joueurs.
        JLabel Annonces=new JLabel ("");
        Annonces.setFont(new Font("Times New Roman",Font.BOLD,20));
        
        //Création de la partie.
        Partie partie = new Partie("Joueur1","Joueur2",Annonces);
        
        //Création de la grille de jeu.
        Grille g = new Grille(partie);
        
        //Création de la frame.
        MyFrame MF = new MyFrame(g,Annonces);
        
        JPanel Texte=new JPanel();
        
        Texte.setPreferredSize(new Dimension(600,50));
        Texte.add(Annonces);
        
        JPanel Jeu = new JPanel();
        Jeu.setBackground(Color.white);
        Jeu.setLayout(new BorderLayout());
        Jeu.add("Center", g.TopCadre);
        
        MF.f.add("Center",Jeu);
        MF.f.add("South",Texte);
        MF.f.setResizable(false);
        MF.f.pack();
        MF.f.setJMenuBar(MF.menuBar);
        MF.f.setSize(new Dimension(600,700));
        MF.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MF.f.setVisible(true);
     }
   
}
