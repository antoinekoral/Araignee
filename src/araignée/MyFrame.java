/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignée;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author antoine
 */
public class MyFrame extends JFrame implements ActionListener, ItemListener {
    
    public JFrame f;
    public JMenuBar menuBar;
    private Grille g;
    private String message;
    private JLabel JL;

    
    public MyFrame(Grille g,JLabel j) {
        
        f = new JFrame("Jeu de l'araignée");
        menuBar = new JMenuBar();
        createMenuBar();
        JL = j;
        this.g = g;
    }
    
    public void createMenuBar() {

        //Build the first menu.
        JMenu menu = new JMenu("Play");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu);
        
        //a group of JMenuItems
        JMenuItem menuItem = new JMenuItem("New Party",
                                 KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menuItem.addActionListener(this);
        menu.add(menuItem);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        g.partie.reinitialize("Joueur1","Joueur2",JL);
        for (JLabel JL : g.JList) {
            JL.setIcon(new ImageIcon("Nothing.png"));
        }
        
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
