package movedrectanglestwo;


import java.awt.HeadlessException;
import javax.swing.JFrame;
import movedrectanglestwo.RectangleView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pc-2
 */
public class Frames extends JFrame {

    public Frames() {
        RectangleView rectangleView = new RectangleView();
        JFrame frame = new JFrame();
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(rectangleView);
    }

}
