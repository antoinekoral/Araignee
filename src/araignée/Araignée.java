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
                
        JPanel myPanel;
        
        myPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawLine(0,0, 20, 35);
            };
            
        JFrame f = new JFrame("Jeu de l'araignée");
        f.add("North",myPanel);
        f.setPreferredSize(new Dimension(500,120));
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        f.add("North",myPanel);
        
    }
    
}
