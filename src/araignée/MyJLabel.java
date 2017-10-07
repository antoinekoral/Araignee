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
public class MyJLabel extends JLabel {
    
    private String id;
    
    public MyJLabel(String s) {
        //Ajout d'un id à un JLabel.
        id = s;
    }
    
    public String get_id() {
        return id;
    }
    
}
