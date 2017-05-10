package imageprocressing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BfImage extends JPanel{
    BufferedImage image;

    public BfImage() {
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        
        g.drawImage(image, 0, 0, null);
    }
    
    public void loadImage(){
        try {
            image = ImageIO.read(new File("C:\\Users\\Pc-2\\Documents\\NetBeansProjects\\ImageProcressing\\src\\imageprocressing\\za.jpg"));
            
        } catch (IOException ex) {
            Logger.getLogger(BfImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getColors(){
        int maxW = image.getWidth();
        int maxH = image.getHeight();
        
        Color c;
        Color c1;
        
        for(int i = 0; i < maxW; i++){
            for(int j = 0; j < maxH; j++){
                c  = new Color(image.getRGB(i, j));
               // c1 = new Color(c.getRed(), c.getGreen(), 5);
                
                int red   = (int)(c.getRed()   * 0.299);
                int green = (int)(c.getGreen() * 0.587);
                int blue  = (int)(c.getBlue()  * 0.114);
                
                int sum   = red + green + blue;
                
                c1 = new Color(sum, sum, sum);
                
               // if(sum > 100)
                 //   image.setRGB(i, j, c1.getRGB());
                //else
                    //image.setRGB(i, j, Color.WHITE.getRGB());
               
                
                
                
                
            }
        }
    }
}
