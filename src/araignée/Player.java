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
    private int pionsPlaces;
    private String image;
    private Pion pionChoisi;
    private boolean secondClic;

    
    Player(String login,String image) {
        this.login = login;        
        this.image = image;
        pionsPlaces = 0;
        secondClic=false;
        pions=new ArrayList<>();
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
    
    public Pion search_JL(MyJLabel JL) {
        Pion pion_cherche = new Pion(new MyJLabel("Pas de pion."));
        for (int i=0; i<pions.size();i++) {
            Pion pion = pions.get(i);
            if (pion.get_label()==JL)
                pion_cherche = pion;
        }
        return pion_cherche;
    }
    
    public boolean estDans_JL(MyJLabel JL) {
        System.out.println("estDans : " + JL.get_id());
        boolean rep = false;
        for (int i=0; i<pions.size();i++) {
            Pion pion = pions.get(i);
            System.out.println(pion.get_case_id());
            if (JL.get_id() == pion.get_case_id())
                rep = true;
        }
        return rep;
    }
    
    public ArrayList<String> transfo_pions() {
        ArrayList<String> pionTransfo = new ArrayList<>();
        for (Pion pion : pions) {
            pionTransfo.add(pion.get_case_id());
        }
        return pionTransfo;
    }
    
    public void set_login(String l) {
        login = l;
    }
    
    public void reinitialize() {
        pions = new ArrayList<>();
        pionsPlaces = 0;
        secondClic = false;
    }
    
    public boolean get_secondClic() {
        return secondClic;
    }
    
    public void set_secondClic(boolean b) {
        secondClic = b;
    }
    
    public Pion get_pionChoisi() {
        return pionChoisi;
    }
    
    public void set_pionChoisi(Pion p) {
        pionChoisi = p;
    }
    
    public void modif_pionsPlaces(int i) {
        pionsPlaces = pionsPlaces + i;
    }
    
    public void add_pions(Pion p) {
        pions.add(p);
    }
    
    public void remove_pions(Pion p) {
        pions.remove(p);
    }
}
