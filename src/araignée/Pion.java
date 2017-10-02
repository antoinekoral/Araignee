/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignée;

import javax.swing.JLabel;

/**
 *
 * @author antoine
 */
public class Pion {
    
    private MyJLabel JL;
    
    public Pion(MyJLabel JL) {
        this.JL = JL;
    }
    
    public JLabel get_label() {
        return this.JL;
    }
    
    public String get_case_id() {
        return JL.get_id();
    }
}
