package fuckingrectangles;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;

public class FuckingRectangles extends JPanel implements MouseListener, MouseMotionListener {

    ArrayList<Rectangle> rectangles;

    BasicStroke select;

    Rectangle SELECTED_RECTANGLE     = null;
    Rectangle SELECTED_LEFTUP_REC    = null;
    Rectangle SELECTED_RIGHTUP_REC   = null;
    Rectangle SELECTED_LEFTDOWN_REC  = null;
    Rectangle SELECTED_RIGHTDOWN_REC = null;

    Rectangle leftUp;
    Rectangle rightUp;
    Rectangle leftDown;
    Rectangle rightDown;

    Point p;

    int resizeBoxX      = 0;
    int resizeBoxY      = 0;
    int resizeBoxWidth  = 0;
    int resizeBoxHeight = 0;

    public FuckingRectangles() {
        rectangles = new ArrayList<>();

        rectangles.add(new Rectangle(70, 80, 500, 100));   // x y width height
        //rectangles.add(new Rectangle(100, 120, 40, 50)); // x y width height

        leftUp    = new Rectangle(resizeBoxX, resizeBoxY, resizeBoxWidth, resizeBoxHeight);
        rightUp   = new Rectangle(resizeBoxX, resizeBoxY, resizeBoxWidth, resizeBoxHeight);
        leftDown  = new Rectangle(resizeBoxX, resizeBoxY, resizeBoxWidth, resizeBoxHeight);
        rightDown = new Rectangle(resizeBoxX, resizeBoxY, resizeBoxWidth, resizeBoxHeight);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawRectangles(g);
    }

    public void drawRectangles(Graphics g) {
        Iterator<Rectangle> iter = rectangles.iterator();
        Rectangle r;
        while (iter.hasNext()) {
            r = iter.next();
            g.setColor(Color.BLACK);
            if (SELECTED_RECTANGLE != null && r.equals(SELECTED_RECTANGLE)) {
                addSelectLine(g, r);
                g.setColor(Color.RED);
                g.fillRect(r.x, r.y, r.width, r.height);
                setResizeBoxs(g, r.x, r.y, r.width, r.height, r);
                SELECTED_LEFTUP_REC = null;
            } else {
                //g.setColor(Color.BLACK);
                g.fillRect(r.x, r.y, r.width, r.height);
                setResizeBoxs(g, r.x, r.y, r.width, r.height, r);
            }
        }
    }

    public void setResizeBoxs(Graphics g, int x, int y, int width, int height, Rectangle r) {
        g.setColor(Color.BLUE);

        if (SELECTED_LEFTUP_REC != null && r.equals(SELECTED_RECTANGLE)) {
            g.setColor(Color.YELLOW);
            leftUp.setBounds(x, y, 10, 10);

            g.fillRect(leftUp.x, leftUp.y, leftUp.width, leftUp.height);

        } else {
            leftUp.setBounds(x, y, 10, 10);
            rightUp.setBounds((width + x) - 10, y, 10, 10);
            leftDown.setBounds(x, (y + height) - 10, 10, 10);
            rightDown.setBounds((width + x) - 10, (height + y) - 10, 10, 10);

            //g.setColor(Color.BLUE);
            g.fillRect(leftUp.x,    leftUp.y,    leftUp.width,    leftUp.height);
            g.fillRect(rightUp.x,   rightUp.y,   rightUp.width,   rightUp.height);
            g.fillRect(leftDown.x,  leftDown.y,  leftDown.width,  leftDown.height);
            g.fillRect(rightDown.x, rightDown.y, rightDown.width, rightDown.height);

        }
        // SELECTED_LEFTUP_REC = null;

    }

    public void getSelectedRectangle(MouseEvent e) {
        Rectangle r;
        Iterator<Rectangle> iter = rectangles.iterator();

        while (iter.hasNext()) {
            r = iter.next();

            if (r.contains(e.getPoint())) {
                SELECTED_RECTANGLE = r;
                if (leftUp.contains(e.getPoint())) {
                    SELECTED_LEFTUP_REC = leftUp;
                }
                break;
            } else {
                SELECTED_RECTANGLE  = null;
                SELECTED_LEFTUP_REC = null;
            }
        }

        //return SELECTED_RECTANGLE;
    }

    public void addSelectLine(Graphics g, Rectangle r) {
        if (SELECTED_RECTANGLE != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            float[] dash = {5};
            select = new BasicStroke(2.0f, BasicStroke.CAP_BUTT,
                                           BasicStroke.JOIN_MITER,
                                           2.0f, dash, 0.0f);
            g2d.setColor(Color.BLACK);
            g2d.setStroke(select);
            g2d.drawRect((int) r.x, (int) r.y, (int) r.width, (int) r.height);

            g2d.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        getSelectedRectangle(e);
        repaint();
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
        if (SELECTED_RECTANGLE != null) {
            p = (Point) e.getPoint().clone();

            SELECTED_RECTANGLE.setLocation(p);
            repaint();
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}
