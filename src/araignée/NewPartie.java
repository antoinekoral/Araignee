/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignée;

/**
 *
 * @author antoine
 */
public class NewPartie {
    
    private Player joueur1;
    private Player joueur2;
    
    NewPartie(String p1,String p2) {
        joueur1 = new Player(p1);
        joueur2 = new Player(p2);
    }
    
}
