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

import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class TraiteClic implements MouseListener {
    private JLabelPerso Case;
    private String icone;
    private Partie partie;
    public Player joueurquijoue;
    public boolean clicked;
    private Player joueur1;
    private Player joueur2;
    public String message;
    
    public TraiteClic (JLabelPerso jl,Partie p){
        Case=jl;
        this.partie = p;
        joueurquijoue= p.joueurquijoue;
        icone=p.joueurquijoue.get_image();
        clicked=false;
        joueur1 = p.joueur1;
        joueur2 = p.joueur2;
        message = joueurquijoue.get_login() + ", à toi de jouer !";
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        joueurquijoue = partie.joueurquijoue;
        icone = joueurquijoue.get_image();
        System.out.println("Click de " + joueurquijoue.get_login()+".");
        System.out.println("Utilisation du logo " + icone +".");
        if (partie.finie) {
            System.out.println("Finie!");
            partie.message = "Ne sois pas mauvais perdant voyons.. fais une nouvelle partie plutôt !";
            partie.changerText();
        } else {
            if (joueurquijoue.get_pionsPlaces()!=3)
            partie.NewMove(joueurquijoue,Case);
            else if (joueurquijoue.second_clic){
                partie.NewMove(joueurquijoue,joueurquijoue.pion_choisi,Case);
                joueurquijoue.second_clic=false;
            } else{
                if (joueurquijoue.estDans_JL(Case)) {
                    joueurquijoue.pion_choisi=joueurquijoue.search_JL(Case);
                    joueurquijoue.second_clic=true;
                    partie.message = "Maintenant choisi l'endroit où tu veux le replacer.";
                    partie.changerText();
                } else {
                    System.out.println("On est d'accord, il est con..");
                    partie.message = "Choisi un de tes pions afin de le bouger..";
                    partie.changerText();
                }
            }
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
