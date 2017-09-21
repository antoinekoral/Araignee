/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignée;

import java.awt.Graphics;
import java.util.LinkedList;
import javax.sound.sampled.Line;
import javax.swing.*;

/**
 *
 * @author antoine
 */
public class LinesComponent extends JComponent {
    
    private int x1; 
    private int y1;
    private int x2;
    private int y2;   
    
    public LinesComponent(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;             
    }

    private LinkedList<Line> lines = new LinkedList<Line>();

    public void addLine(int x1, int x2, int x3, int x4) {
        lines.add(new Line(x1,x2,x3,x4));        
        repaint();
    }

    public void clearLines() {
        lines.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Line line : lines) {
            g.drawLine(line.getStartX(), line.y1, line.x2, line.y2);
        }
    
}
