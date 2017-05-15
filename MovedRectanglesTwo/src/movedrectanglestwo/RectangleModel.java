package movedrectanglestwo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class RectangleModel {

    private double newX;
    private double newY;

    public RectangleModel() {

    }

    public double calculateXPoint(MouseEvent e, Rectangle r) {
        double c = e.getX() - r.getX();
        return c;
    }

    public double calculateYPoint(MouseEvent e, Rectangle r) {
        double c = e.getY() - r.getY();
        return c;
    }

    public void drawRec(Graphics g, ArrayList<Rectangle> rec, Rectangle selectedRec) {
        Iterator<Rectangle> iter = rec.iterator();
        Rectangle r;
        while (iter.hasNext()) {
            r = iter.next();
            if (selectedRec != null && r.equals(selectedRec)) {
                g.setColor(Color.red);
                g.fillRect(r.x, r.y, r.width, r.height);
                g.setColor(Color.black);
            } else {
                g.fillRect(r.x, r.y, r.width, r.height);
            }
        }
    }

    public Rectangle getSetectedRectangle(ArrayList<Rectangle> rec, MouseEvent e, Rectangle selectedRec) {
        Iterator<Rectangle> iter = rec.iterator();
        Rectangle r;
        while (iter.hasNext()) {
            r = iter.next();
            if (r.contains(e.getPoint())) {
                selectedRec = r;
                setNewX(calculateXPoint(e, r));
                setNewY(calculateYPoint(e, r));
                return selectedRec;
            }
        }

        return selectedRec;
    }

    public double getNewX() {
        return newX;
    }

    public void setNewX(double newX) {
        this.newX = newX;
    }

    public double getNewY() {
        return newY;
    }

    public void setNewY(double newY) {
        this.newY = newY;
    }

}
