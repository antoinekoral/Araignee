/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignée;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author antoine
 */
public class Partie {
    
    private Player joueur1;
    private Player joueur2;
    private String message;
    private Player joueurquijoue;
    private JLabel text;
    private boolean finie;
    
    public Partie(String p1,String p2, JLabel j) {
        
        System.out.println("Nouvelle partie : " + p1 + "-" + p2 + ".");
        
        joueur1 = new Player(p1,"Circle");
        joueur2 = new Player(p2,"Cross");
        joueurquijoue = joueur1;
        message = joueurquijoue.get_login() + ", à toi de jouer !";
        text = j;
        text.setText(message);
        finie = false;

        //joueurquijoue=new Player("","");
 
    }
    public void NewMove(Player joueur,JLabelPerso JL) {
        System.out.println("Mouvement de " + joueur.get_login());
        //Ajout d'un nouveau pion
        if (!((joueur1.estDans_JL(JL)) || (joueur2.estDans_JL(JL)))) {
            joueur.add_pions(new Pion(JL));
            joueur.modif_pionsPlaces(1);
            JL.setIcon(new ImageIcon(joueur.get_image()+".png"));
            if (testPartieFinie()) {
                finie = true;
                message = "Bravo " + joueurquijoue.get_login() + " tu as gagné !";
                text.setText(message);
            } else
                changerJoueur();
        } else {
            message = "Il y a déjà un pion à cet endroit, essaie ailleurs.";
            text.setText(message);
        }
        System.out.println("C'est maintenant à " + joueurquijoue.get_login() + " de jouer.");
    }
    
    public JLabel NewMove(Player joueur,Pion p,JLabelPerso JL) {
        //Modifier la position d'un pion existant
        joueur.remove_pions(p);
        p.get_label().setIcon(new ImageIcon("Nothing.png"));
        joueur.modif_pionsPlaces(-1);
        NewMove(joueur,JL);
        return p.get_label();
    }
    
    public void changerJoueur() {
        if (joueurquijoue == joueur1) {
            joueurquijoue = joueur2;
            
        } else {
            joueurquijoue = joueur1;
        }
        message = joueurquijoue.get_login() + ", à toi de jouer !";
        text.setText(message);
    }
    
    public boolean testPartieFinie() {
        if (joueurquijoue.get_pionsPlaces() != 3) {
            return false;
        } else {
            ArrayList pions = joueurquijoue.transfo_pions();
            return (pions.contains("NO") && pions.contains("N") && pions.contains("NE")) ||
                    (pions.contains("O") && pions.contains("C") && pions.contains("E")) ||
                    (pions.contains("SO") && pions.contains("S") && pions.contains("SE")) ||
                    (pions.contains("NO") && pions.contains("O") && pions.contains("SO")) ||
                    (pions.contains("N") && pions.contains("C") && pions.contains("S")) ||
                    (pions.contains("NE") && pions.contains("E") && pions.contains("SE")) ||
                    (pions.contains("NO") && pions.contains("C") && pions.contains("SE")) ||
                    (pions.contains("NE") && pions.contains("C") && pions.contains("SO"));
        }
    }
    
    public void reinitialize(String p1,String p2, JLabel j) {
        
        System.out.println("Nouvelle partie : " + p1 + "-" + p2 + ".");
        
        joueur1.set_login(p1);
        joueur1.reinitialize();
        joueur2.set_login(p2);
        joueur2.reinitialize();
        joueurquijoue = joueur1;
        
        message = joueurquijoue.get_login() + ", à toi de jouer !";
        text = j;
        text.setText(message);
        
        finie = false;
    }
    
    public Player get_joueurquijoue() {
        return joueurquijoue;
    }
    
    public Player get_joueur1() {
        return joueur1;
    }
    
    public Player get_joueur2() {
        return joueur2;
    }
    
    public boolean get_finie() {
        return finie;
    }
    
    public void set_message(String m) {
        message = m;
    }
    
    public void changerText() {
        text.setText(message);
    }
    
}
