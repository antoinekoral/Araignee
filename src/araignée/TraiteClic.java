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
    private JLabel Case;
    private String icone;
    public boolean clicked;
    
    public TraiteClic (JLabel j,String image){
        Case=j;
        icone=image;
        clicked=false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Case.setIcon(new ImageIcon(icone+".png"));
        clicked=true;
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

    public boolean getEtat(){
        return clicked;
    }
    
    public JLabel getCase(){
        return Case;
    }
    
}
