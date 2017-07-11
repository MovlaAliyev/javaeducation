/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamcopier;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StreamCopier {

    
    public static void main(String[] args) {
        StreamCopier sc = new StreamCopier();
        try {
            sc.copy(new FileInputStream("C:\\Users\\Javatarr\\Desktop\\test.txt"), new FileOutputStream("C:\\Users\\Javatarr\\Desktop\\out.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StreamCopier.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StreamCopier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void copy(InputStream in, OutputStream out)
        throws IOException{
        synchronized(in){
            synchronized(out){
                byte[] buffer = new byte[256];
                while(true){
                    int bytesRead = in.read(buffer);
                    if(bytesRead == -1) break;
                    out.write(buffer, 60, bytesRead);
                }
                in.close();
                out.close();
            }
        }
    }
    
}
