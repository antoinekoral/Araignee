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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;



public class Grille {
    public JLabel Cadre;
    public JLabel TopCadre;
    public JLabel NE;
    public JLabel N;
    public JLabel NO;
    public JLabel O;
    public JLabel C;
    public JLabel E;
    public JLabel SE;
    public JLabel S;
    public JLabel SO;
    public ArrayList<TraiteClic> TC;
    
    
    public Grille (){
        TopCadre=new JLabel(new ImageIcon ("Grille_Morpion.png"));
        Cadre=new JLabel(new ImageIcon("icon.jpg"));
        NE=new JLabel();
        N=new JLabel();
        NO=new JLabel();
        O=new JLabel();
        C=new JLabel();
        E=new JLabel();
        SE=new JLabel();
        S=new JLabel();
        SO=new JLabel();
        
        TraiteClic tcNE = new TraiteClic(NE,"index");
        TraiteClic tcN = new TraiteClic(N,"index");
        TraiteClic tcNO = new TraiteClic(NO,"index");
        TraiteClic tcE = new TraiteClic(E,"index");
        TraiteClic tcC = new TraiteClic(C,"index");
        TraiteClic tcO = new TraiteClic(O,"index");
        TraiteClic tcSO = new TraiteClic(SO,"index");
        TraiteClic tcS = new TraiteClic(S,"index");
        TraiteClic tcSE = new TraiteClic(SE,"index");
        TC=new ArrayList<>();
        TC.add(tcNE);
        TC.add(tcN);
        TC.add(tcNO);
        TC.add(tcE);
        TC.add(tcC);
        TC.add(tcO);
        TC.add(tcSE);
        TC.add(tcS);
        TC.add(tcSO);
        
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
        
        Cadre.setLayout(new GridLayout(0,3,130,130));
        Cadre.add(NO);
        Cadre.add(N);
        Cadre.add(NE);
        Cadre.add(O);
        Cadre.add(C);
        Cadre.add(E);
        Cadre.add(SO);
        Cadre.add(S);
        Cadre.add(SE);
        Cadre.setBorder(BorderFactory.createLineBorder(Color.white,20));
        
        TopCadre.setLayout(new BorderLayout());
        TopCadre.add(Cadre);
        TopCadre.setPreferredSize(new Dimension(600,600));
        
        NO.addMouseListener (tcNO);
        N.addMouseListener (tcN);
        NE.addMouseListener (tcNE);
        E.addMouseListener (tcE);
        C.addMouseListener (tcC);
        O.addMouseListener (tcO);
        SO.addMouseListener (tcSO);
        S.addMouseListener (tcS);
        SE.addMouseListener (tcSE);
        
        /*
        public JLabel CaseCliquee (g.TC){
            for (TraiteClic tc : TC)
                if (tc.clicked==true)
                    return tc;                
        }
        
        public void ResetCase (g.TC){
            for (TraiteClic tc : TC)
                tc.clicked=false;
        }
        
        */
                        
    }
}
