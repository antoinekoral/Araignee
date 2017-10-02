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
import java.util.ArrayList;



public class Grille {
    public JLabel Cadre;
    public JLabel TopCadre;
    private MyJLabel NE;
    private MyJLabel N;
    private MyJLabel NO;
    private MyJLabel O;
    private MyJLabel C;
    private MyJLabel E;
    private MyJLabel SE;
    private MyJLabel S;
    private MyJLabel SO;
    private ArrayList<TraiteClic> TC;
    public ArrayList<JLabel> JList;
    private Player joueurquijoue;
    public Partie partie;
    
    
    public Grille (Partie p){
        TopCadre=new JLabel(new ImageIcon ("Grille_Morpion.png"));
        Cadre=new JLabel(new ImageIcon("icon.jpg"));
        partie = p;
        
        NE=new MyJLabel("NE");
        N=new MyJLabel("N");
        NO=new MyJLabel("NO");
        O=new MyJLabel("O");
        C=new MyJLabel("C");
        E=new MyJLabel("E");
        SE=new MyJLabel("SE");
        S=new MyJLabel("S");
        SO=new MyJLabel("SO");
        
        JList = new ArrayList<>();
        JList.add(NE);
        JList.add(N);
        JList.add(NO);
        JList.add(O);
        JList.add(C);
        JList.add(E);
        JList.add(SE);
        JList.add(S);
        JList.add(SO);
        
        TraiteClic tcNE = new TraiteClic((MyJLabel) NE,partie);
        TraiteClic tcN = new TraiteClic((MyJLabel) N,partie);
        TraiteClic tcNO = new TraiteClic((MyJLabel) NO,partie);
        TraiteClic tcE = new TraiteClic((MyJLabel) E,partie);
        TraiteClic tcC = new TraiteClic((MyJLabel) C,partie);
        TraiteClic tcO = new TraiteClic((MyJLabel) O,partie);
        TraiteClic tcSO = new TraiteClic((MyJLabel) SO,partie);
        TraiteClic tcS = new TraiteClic((MyJLabel) S,partie);
        TraiteClic tcSE = new TraiteClic((MyJLabel) SE,partie);
        
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
        Cadre.setBorder(BorderFactory.createLineBorder(Color.white,66));
        
        TopCadre.setLayout(new BorderLayout());
        TopCadre.add("Center",Cadre);
        TopCadre.setPreferredSize(new Dimension(600,600));
        
        NO.addMouseListener(tcNO);
        N.addMouseListener(tcN);
        NE.addMouseListener(tcNE);
        E.addMouseListener(tcE);
        C.addMouseListener(tcC);
        O.addMouseListener(tcO);
        SO.addMouseListener(tcSO);
        S.addMouseListener(tcS);
        SE.addMouseListener(tcSE);
                        
    }
}
