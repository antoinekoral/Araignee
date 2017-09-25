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
import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class TraiteClic implements MouseListener {
    private JPanel JP;
    private String Zone;
    private JLabel JL;
    
    public TraiteClic (JPanel j,String z,JLabel l){
        JP=j;
        Zone=z;
        JL=l;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JL.setText(Zone);
        JP.setBackground(Color.RED);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    
    
}
