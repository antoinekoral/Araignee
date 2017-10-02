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
    private JLabel NE;
    private JLabel N;
    private JLabel NO;
    private JLabel O;
    private JLabel C;
    private JLabel E;
    private JLabel SE;
    private JLabel S;
    private JLabel SO;
    private ArrayList<TraiteClic> TC;
    public ArrayList<JLabel> JList;
    private Player joueurquijoue;
    public Partie partie;
    
    
    public Grille (Partie p){
        TopCadre=new JLabel(new ImageIcon ("Grille_Morpion.png"));
        Cadre=new JLabel(new ImageIcon("icon.jpg"));
        partie = p;
        
        NE=new JLabelPerso("NE");
        N=new JLabelPerso("N");
        NO=new JLabelPerso("NO");
        O=new JLabelPerso("O");
        C=new JLabelPerso("C");
        E=new JLabelPerso("E");
        SE=new JLabelPerso("SE");
        S=new JLabelPerso("S");
        SO=new JLabelPerso("SO");
        
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
        
        TraiteClic tcNE = new TraiteClic((JLabelPerso) NE,partie);
        TraiteClic tcN = new TraiteClic((JLabelPerso) N,partie);
        TraiteClic tcNO = new TraiteClic((JLabelPerso) NO,partie);
        TraiteClic tcE = new TraiteClic((JLabelPerso) E,partie);
        TraiteClic tcC = new TraiteClic((JLabelPerso) C,partie);
        TraiteClic tcO = new TraiteClic((JLabelPerso) O,partie);
        TraiteClic tcSO = new TraiteClic((JLabelPerso) SO,partie);
        TraiteClic tcS = new TraiteClic((JLabelPerso) S,partie);
        TraiteClic tcSE = new TraiteClic((JLabelPerso) SE,partie);
        
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
