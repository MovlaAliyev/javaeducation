package threadlocaltest;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadLocalTest implements Runnable {

    private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd HHmm");
        }
    };
    
    private static final ThreadLocal<SimpleDateFormat> formatterTwo = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy/MM/dd HHmm");
        }
    };

    public static void main(String[] args) {
        ThreadLocalTest localTest = new ThreadLocalTest();
        Thread t = new Thread(localTest, "Thread 1");
        Thread t2 = new Thread(localTest, "Thread 2");
        
        t.start();
        t2.start();
    }

    @Override
    public void run() {
        System.out.println("Thread name: " + Thread.currentThread().getName() + " default formatter " + formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadLocalTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        formatter.set(new SimpleDateFormat("yyyy-MM-dd HH:mm"));
        System.out.println("Thread name: " + Thread.currentThread().getName() + " default formatter " + formatterTwo.get().toPattern());

    }

}
