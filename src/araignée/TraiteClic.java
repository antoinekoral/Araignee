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
    
    private MyJLabel Case;
    private String icone;
    private Partie partie;
    private Player joueurquijoue;
    private Player joueur1;
    private Player joueur2;
    private String message;
    
    public TraiteClic (MyJLabel jl,Partie p){
        Case=jl;
        
        this.partie = p;
        
        joueurquijoue = p.get_joueurquijoue();
        icone=p.get_joueurquijoue().get_image();
        
        joueur1 = p.get_joueur1();
        joueur2 = p.get_joueur2();
        
        message = joueurquijoue.get_login() + ", à toi de jouer !";
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Permet de gérer le click sur la case.
        
        joueurquijoue = partie.get_joueurquijoue();
        icone = joueurquijoue.get_image();
        
        System.out.println("Click de " + joueurquijoue.get_login()+".");
        
        if (partie.get_finie()) {//si la partie est terminée
            System.out.println("Finie!");
            partie.set_message("Ne sois pas mauvais perdant voyons.. fais une nouvelle partie plutôt !");
            partie.changerText();
        } else {
            if (joueurquijoue.get_pionsPlaces()!=3)//si le joueur n'a pas encore placé tous ses pions
            partie.NewMove(joueurquijoue,Case);
            else if (joueurquijoue.get_secondClic()){//si le joueur est en train de modifier la position d'un pion
                partie.NewMove(joueurquijoue,joueurquijoue.get_pionChoisi(),Case);
            } else{
                if (joueurquijoue.estDans_JL(Case)) {//si le joueur a choisi une case dans laquelle il a un pion
                    joueurquijoue.set_pionChoisi(joueurquijoue.search_JL(Case));
                    joueurquijoue.set_secondClic(true);
                    partie.set_message("Maintenant choisi l'endroit où tu veux le replacer.");
                    partie.changerText();
                } else {
                    System.out.println("Il y a déjà un pion là.");
                    partie.set_message("Choisi un de tes pions afin de le bouger..");
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
    
}
