/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignée;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import javax.swing.JApplet;

/**
 *
 * @author antoine
 */
public class DrawLines extends JApplet {
    @Override
    public void init() {
       setBackground(Color.white);
       setForeground(Color.white);
    }
    @Override
    public void paint(Graphics g) {
       Graphics2D g2 = (Graphics2D) g;
       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       g2.setPaint(Color.black);
       g2.draw(new Line2D.Double(100,100,100,500));
       g2.draw(new Line2D.Double(500,100,500,500));
       g2.draw(new Line2D.Double(100,100,500,100));
       g2.draw(new Line2D.Double(100,500,500,500));
       g2.draw(new Line2D.Double(300,100,300,500));
       g2.draw(new Line2D.Double(100,300,500,300));
       g2.draw(new Line2D.Double(100,100,500,500));
       g2.draw(new Line2D.Double(500,100,100,500));
    }
}
