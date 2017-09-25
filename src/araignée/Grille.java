/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignée;

/**
 *
 * @author Théo
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Grille {
    public JLabel Cadre;
    public JLabel NE;
    public JLabel N;
    public JLabel NO;
    public JLabel O;
    public JLabel C;
    public JLabel E;
    public JLabel SE;
    public JLabel S;
    public JLabel SO;
    
    public Grille (){
        Cadre=new JLabel(new ImageIcon ("Grille_Morpion.png"));
        NE=new JLabel();
        N=new JLabel();
        NO=new JLabel();
        O=new JLabel();
        C=new JLabel();
        E=new JLabel();
        SE=new JLabel();
        S=new JLabel();
        SO=new JLabel();
        JLabel text=new JLabel("test");
        Dimension dim=new Dimension(200,200);
        NE.setPreferredSize(dim);
        NO.setPreferredSize(dim);
        N.setPreferredSize(dim);
        E.setPreferredSize(dim);
        C.setPreferredSize(dim);
        O.setPreferredSize(dim);
        SO.setPreferredSize(dim);
        S.setPreferredSize(dim);
        SE.setPreferredSize(dim);
        
        
        Cadre.setLayout(new GridLayout(0,3));
        Cadre.add(NO);
        Cadre.add(N);
        Cadre.add(NE);
        Cadre.add(O);
        Cadre.add(C);
        Cadre.add(E);
        Cadre.add(SO);
        Cadre.add(S);
        Cadre.add(SE);
        /*Cadre.add(text);*/     
        
        NO.setOpaque(false);
        
        NO.addMouseListener (new TraiteClic(NO,"NO",text));
        N.addMouseListener (new TraiteClic(N,"N",text));
        NE.addMouseListener (new TraiteClic(NE,"NE",text));
        E.addMouseListener (new TraiteClic(E,"E",text));
        C.addMouseListener (new TraiteClic(C,"C",text));
        O.addMouseListener (new TraiteClic(O,"O",text));
        SO.addMouseListener (new TraiteClic(SO,"SO",text));
        S.addMouseListener (new TraiteClic(S,"S",text));
        SE.addMouseListener (new TraiteClic(SE,"SE",text));
    }
}
