package fuckingrectangles;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Start {

    public static void main(String[] args) {
        FuckingRectangles fr = new FuckingRectangles();

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame jf = new JFrame();
                fr.addMouseListener(fr);
                fr.addMouseMotionListener(fr);
                jf.add(fr);

                jf.setSize(600, 600);
                jf.setVisible(true);
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });

    }
}
