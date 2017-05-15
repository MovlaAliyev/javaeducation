package movedrectanglestwo;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RectangleView extends JPanel {

    private ArrayList<Rectangle> rec;
    private Rectangle selectedRec = null;
    private Model m;

   

    public RectangleView() {
        m = new Model();
        rec = new ArrayList<>();
        rec.add(new Rectangle(10, 10, 30, 30));
        rec.add(new Rectangle(40, 40, 30, 30));
    }

    public void setSelectedRec(Rectangle selectedRec) {
        this.selectedRec = selectedRec;
        if(selectedRec != null)
            repaint();
    }

    @Override
    public void paint(Graphics g) {        m.drawRec(g, rec, selectedRec);
       
    }

    void addMousePressed(MouseListener listener) {
        this.addMouseListener(listener);
    }

    public ArrayList<Rectangle> getRec() {
        return rec;
    }

    public Rectangle getSelectedRec() {
        return selectedRec;
    }

}
