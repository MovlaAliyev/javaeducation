package streamprinter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class StreamPrinter {

    InputStream is;

    public static void main(String[] args) throws FileNotFoundException {
        StreamPrinter sp = new StreamPrinter(new FileInputStream("C:\\Users\\Javatarr\\Desktop\\test.txt"));
        sp.print();
    }

    public StreamPrinter(InputStream is) {
        this.is = is;
    }
    
    public void print(){
        try{
            while(true){
                int datum = is.read();
                if(datum == -1) break;
                System.out.println(datum);
            }
        }catch(IOException io){
        }
    }
    
    

}
