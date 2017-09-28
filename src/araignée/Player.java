/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignée;

import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author antoine
 */
public class Player {
    
    private String login;
    private ArrayList<Pion> pions;
    private int pionsPlaces;
    private String image;
    public Pion pion_choisi;
    public boolean second_clic;

    
    Player(String login,String image) {
        this.login = login;        
        this.image = image;
        pionsPlaces = 0;
        second_clic=false;
        pions=new ArrayList<>();
    }
    
    public void NewMove(JLabel JL) {
        //Ajout d'un nouveau pion
        pions.add(new Pion(JL));
        pionsPlaces += 1;
    }
    
    public JLabel NewMove(Pion p,JLabel JL) {
        //Modifier la position d'un pion existant
        pions.remove(p);
        pions.add(new Pion(JL));
        return p.get_label();
    }
    
    public String get_image() {
        return this.image;
    }
    
    public int get_pionsPlaces() {
        return this.pionsPlaces;
    }
    
    public String get_login() {
        return this.login;
    }
    
    public ArrayList get_pions() {
        return this.pions;
    }
    
    public Pion search_JL(JLabel JL) {
        Pion pion_cherche = new Pion(new JLabel());
        for (int i=0; i<pions.size();i++) {
            Pion pion = pions.get(i);
            if (pion.get_label()==JL)
                pion_cherche = pion;
        }
        return pion_cherche;
    }
}
