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
public class Player {
    private String login;
    private ArrayList<Pion> pions;
    private int pions_places;
    
    Player(String login) {
        this.login = login;        
    }
    
    public void NewMove(int x, int y) {
        //Ajout d'un nouveau pion
        pions.add(new Pion(x, y));
    }
    
    public void NewMove(Pion p,int x,int y) {
        //Modifier la position d'un pion existant
        pions.remove(p);
        pions.add(new Pion(x,y));
    }
}
