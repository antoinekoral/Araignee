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

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Grille {
    public JPanel Cadre;
    public JPanel NE;
    public JPanel N;
    public JPanel NO;
    public JPanel O;
    public JPanel C;
    public JPanel E;
    public JPanel SE;
    public JPanel S;
    public JPanel SO;
    
    public Grille (){
        Cadre=new JPanel();
        NE=new JPanel();
        N=new JPanel();
        NO=new JPanel();
        O=new JPanel();
        C=new JPanel();
        E=new JPanel();
        SE=new JPanel();
        S=new JPanel();
        SO=new JPanel();
        JLabel text=new JLabel("test");
        Dimension dim=new Dimension(50,50);
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
        Cadre.add(text);
        
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
