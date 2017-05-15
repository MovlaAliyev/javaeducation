package movedrectanglestwo;

import java.awt.Frame;
import javax.swing.JFrame;


public class MovedRectanglesTwo {

    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        RectangleView rectangleView = new RectangleView();
        Model m = new Model();
        RectangleController controller = new RectangleController(rectangleView, m);
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(rectangleView);
        frame.setVisible(true);
        
    }
    
}
