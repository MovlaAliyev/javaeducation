package movedrectanglestwo;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class RectangleController {

    RectangleView  theView;
    RectangleModel theModel;
    Rectangle      r;
    Point          p;
    
    

    public RectangleController(RectangleView theView, RectangleModel theModel) {
        this.theView  = theView;
        this.theModel = theModel;

        this.theView.addMousePressed(new RectangleListener());
        this.theView.addMouseDragged(new RectangleListener());

    }

    class RectangleListener implements MouseListener, MouseMotionListener {

        Rectangle r;

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            r = theModel.getSetectedRectangle(theView.getRec(), e, theView.getSelectedRec());
            theView.setSelectedRec(r);
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

        @Override
        public void mouseDragged(MouseEvent e) {
            if (theView.getSelectedRec() != null) {
                p = (Point) e.getPoint().clone();

                p.setLocation((p.getX() - theModel.getNewX()), 
                              (p.getY() - theModel.getNewY()));

                theView.getSelectedRec().setLocation(p);
                theView.setMovement(true);
            }else{
                theView.setMovement(false);
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }

    }
}
