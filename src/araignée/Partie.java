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
        //Création des joueurs de la partie.
        joueur1 = new Player(p1,"Circle");
        joueur2 = new Player(p2,"Cross");
        //Repérage du joueur actuellement en train de jouer.
        joueurquijoue = joueur1;
        //Message affiché au joueur.
        message = joueurquijoue.get_login() + ", à toi de jouer !";
        //Affichage de ce message.
        text = j;
        text.setText(message);
        //Permet de vérifier si la partie est terminée.
        finie = false; 
    }
    
    public void NewMove(Player joueur,MyJLabel JL) {
        //Permet l'ajout d'un nouveau pion.
        
        System.out.println("Mouvement de " + joueur.get_login());
 
        if (joueur.get_secondClic()) { //si le joueur est en train de modifier la position d'un pion
            if (authorizedMove(joueur.get_pionChoisi(),JL)) { //si le mouvement souhaité est autorisé
                if (!((joueur1.estDans_JL(JL)) || (joueur2.estDans_JL(JL)))) { //si il n'y a pas déjà un pion dans la case visée
                    joueur.set_secondClic(false);
                    joueur.add_pions(new Pion(JL));
                    joueur.modif_pionsPlaces(1); //rajoute 1 dans le nombre de pions placés par le joueur
                    JL.setIcon(new ImageIcon(joueur.get_image()+".png")); //place le pion de manière graphique dans la case visée
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
            } else {
                message = "Il faut se déplacer le long des segments !";
                text.setText(message);
            }
        } else if (!((joueur1.estDans_JL(JL)) || (joueur2.estDans_JL(JL)))) {
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
    
    public void NewMove(Player joueur,Pion p,MyJLabel JL) {
        //Permet de modifier la position d'un pion existant.
        
        joueur.remove_pions(p); //retire le pion sélectionné des pions posés par le joueur
        p.get_label().setIcon(new ImageIcon("Nothing.png")); //retire graphiquement le pion sélectionné par le joueur
        joueur.modif_pionsPlaces(-1); //enlève 1 au nombre total de pions placés par le joueur
        NewMove(joueur,JL);
    }
    
    public void changerJoueur() {
        //Renseigne le changement de joueur suite à un mouvement.
        
        if (joueurquijoue == joueur1) {
            joueurquijoue = joueur2;
            
        } else {
            joueurquijoue = joueur1;
        }
        message = joueurquijoue.get_login() + ", à toi de jouer !";
        text.setText(message);
    }
    
    public boolean testPartieFinie() {
        //Permet de tester si le dernier mouvement effectué à permet de finir la partie.
        
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
        //Permet de réinitialiser les éléments nécessaires afin de faire une nouvelle partie.
        
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
    
    public boolean authorizedMove(Pion p,MyJLabel JL) {
        //Permet de savoir si le mouvement souhaité est autorisé ou non.
        
        String depart = p.get_case_id();
        String arrivee = JL.get_id();
        
        if (depart == "NO")
            return ((arrivee=="N") || (arrivee=="C") || (arrivee=="O") || (arrivee==depart));
        else if (depart == "N")
            return ((arrivee=="NO") || (arrivee=="NE") || (arrivee=="C") || (arrivee==depart));
        else if (depart == "NE")
            return ((arrivee=="N") || (arrivee=="C") || (arrivee=="E") || (arrivee==depart));
        else if (depart == "E")
            return ((arrivee=="NE") || (arrivee=="C") || (arrivee=="SE") || (arrivee==depart));
        else if (depart == "O")
            return ((arrivee=="NO") || (arrivee=="C") || (arrivee=="SO") || (arrivee==depart));
        else if (depart == "SO")
            return ((arrivee=="O") || (arrivee=="C") || (arrivee=="S") || (arrivee==depart));
        else if (depart == "S")
            return ((arrivee=="SO") || (arrivee=="C") || (arrivee=="SE") || (arrivee==depart));
        else if (depart == "SE")
            return ((arrivee=="E") || (arrivee=="C") || (arrivee=="S") || (arrivee==depart));
        else
            return true;
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
