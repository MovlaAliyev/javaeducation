package movedrectanglestwo;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class RectangleView extends JPanel {

    private boolean movement = false;

    public boolean isMovement() {
        return movement;
    }

    public void setMovement(boolean movement) {
        this.movement = movement;
        if(movement)
           repaint();
        movement = false;
    }
    
    private ArrayList<Rectangle> rec;
    private Rectangle selectedRec = null;
    private RectangleModel m;

    public RectangleView() {
        m   = new RectangleModel();
        rec = new ArrayList<>();
        rec.add(new Rectangle(10, 10, 30, 30));
        rec.add(new Rectangle(40, 40, 30, 30));
    }
    
    public void setSelectedRec(Rectangle selectedRec) {
        this.selectedRec = selectedRec;
        if (selectedRec != null) {
            repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        m.drawRec(g, rec, selectedRec);

    }

    void addMousePressed(MouseListener listener) {
        this.addMouseListener(listener);
    }
    
    void addMouseDragged(MouseMotionListener listener) {
        this.addMouseMotionListener(listener);
    }

    public ArrayList<Rectangle> getRec() {
        return rec;
    }

    public Rectangle getSelectedRec() {
        return selectedRec;
    }

}
