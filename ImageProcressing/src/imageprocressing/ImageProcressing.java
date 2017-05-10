
package imageprocressing;

import javax.swing.JFrame;


public class ImageProcressing {

    public static void main(String[] args) {
        BfImage image = new BfImage();
        
        JFrame frame = new JFrame();
        
        image.loadImage();
        image.getColors();
        
        frame.add(image);
        
        frame.setVisible(true);
        frame.setSize(1200,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
