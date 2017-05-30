/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdesign;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Pc-2
 */
public class Editor extends JPanel implements MouseListener{

    ArrayList<Rectangle> r = new ArrayList<>();
    Point p;
    public Editor() {
        super(new BorderLayout());
        
        this.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 10)); 
    }

    
    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(Color.red);
        if(!r.isEmpty())
            g.fillRect(r.get(0).x, r.get(0).y, r.get(0).width, r.get(0).height);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        p = (Point)e.getPoint().clone();
        r.add(new Rectangle((int)p.getX(),(int)p.getY(),40,40));
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Worked");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
