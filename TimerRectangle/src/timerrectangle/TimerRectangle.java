package timerrectangle;

import javax.swing.JFrame;


public class TimerRectangle {

   
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(300,400);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        RectangleTest r = new RectangleTest();
        frame.add(r);
    }
    
}
