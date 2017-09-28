/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignée;

import java.util.ArrayList;

/**
 *
 * @author antoine
 */
public class Partie {
    
    private Player joueur1;
    private Player joueur2;
    private Player joueurquijoue;
    private String message;
    private Grille g;
    
    public Partie(String p1,String p2,Grille g) {
        joueur1 = new Player(p1,"Circle");
        joueur2 = new Player(p2,"Cross");
        joueurquijoue = joueur1;
        message = joueurquijoue.get_login() + ", à toi de jouer !";
        this.g = g;
        this.g.joueurquijoue=joueurquijoue;
    }
    
    public void changerJoueur() {
        if (joueurquijoue == joueur1) {
            joueurquijoue = joueur2;
        } else {
            joueurquijoue = joueur1;
        }
        g.joueurquijoue=joueurquijoue;
        message = joueurquijoue.get_login() + ", à toi de jouer !";
    }
    
    public Player get_joueurquijoue() {
        return joueurquijoue;
    }
    
    public void modifie_message() {
        
    }
    
    public boolean testPartieFinie() {
        if (joueurquijoue.get_pionsPlaces() != 3) {
            return false;
        } else {
            ArrayList pions = joueurquijoue.get_pions();
            if ((pions.contains(g.NO) && pions.contains(g.N) && pions.contains(g.NE)) ||
                (pions.contains(g.O) && pions.contains(g.C) && pions.contains(g.E)) ||
                (pions.contains(g.SO) && pions.contains(g.S) && pions.contains(g.SE)) ||
                (pions.contains(g.NO) && pions.contains(g.O) && pions.contains(g.SO)) ||
                (pions.contains(g.N) && pions.contains(g.C) && pions.contains(g.S)) ||
                (pions.contains(g.NE) && pions.contains(g.E) && pions.contains(g.SE)) ||
                (pions.contains(g.NO) && pions.contains(g.C) && pions.contains(g.SE)) ||
                (pions.contains(g.NE) && pions.contains(g.C) && pions.contains(g.SO))
               ) {
            return true;
        } else {
                return false;
            }
        }
    }
    
}
