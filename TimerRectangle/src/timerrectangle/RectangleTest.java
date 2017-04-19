package timerrectangle;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;
public class RectangleTest extends JPanel implements ActionListener{
    
    private Timer timer = new Timer(100,this);
    private LinkedList<Rectangle> list = new LinkedList<>();
    private Random random = new Random();
    
    
    private int maxX = 300;
    private int maxY = 400;
    private int maxW = 40;
    private int maxH = 40;
    
    
    public RectangleTest() {
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       randomRectangle();
       repaint();
    }

    private void verticalRectangle(int x, int y, int WIDTH, int HEIGHT){
        boolean add = true;
        Rectangle verticalRec = new Rectangle(x, y, WIDTH, HEIGHT);
        Iterator<Rectangle> it = list.iterator();
        while(it.hasNext()){
            Rectangle r = it.next();
            if(verticalRec.intersects(r))
                add = false;
        }
        if(add)
            list.add(verticalRec);
        else
            randomRectangle();
    }
    
    private void randomRectangle(){
        int x = random.nextInt(maxX);
        int y = random.nextInt(maxY);
        int w = random.nextInt(maxW);
        int h = random.nextInt(maxH);
        
        verticalRectangle(x, y, w, h);
    }
    
    
    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        
        Iterator<Rectangle> it = list.iterator();
        while(it.hasNext()){
            Rectangle r = it.next();
            g.fillRect((int)r.getX(), 
                       (int)r.getY(), 
                       (int)r.getWidth(),
                       (int)r.getHeight());
        }
    }
    
    
    
}
