package movedrectanglestwo;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RectangleController {

    RectangleView theView;
    Model theModel;
    Rectangle r;

    public RectangleController(RectangleView theView, Model theModel) {
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addMousePressed(new RectangleListener());

    }

    class RectangleListener implements MouseListener {

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

    }
}
