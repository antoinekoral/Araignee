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
    private Player jqj;
    public boolean clicked;
    
    public TraiteClic (JLabel jl,Player j){
        Case=jl;
        jqj=j;
        icone=j.get_image();
        clicked=false;        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Case.setIcon(new ImageIcon(icone+".png"));
        if (jqj.get_pionsPlaces()!=3)
            jqj.NewMove(Case);
        else if (jqj.second_clic){
            jqj.NewMove(jqj.pion_choisi,Case);
            jqj.second_clic=false;
        }
        else{
            jqj.pion_choisi=jqj.search_JL(Case);
            jqj.second_clic=true;
        }
            
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
