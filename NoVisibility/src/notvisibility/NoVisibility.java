package notvisibility;

public class NoVisibility {

    private static boolean ready;
    private static int number = 0;

    private static class ReaderThread extends Thread {

        @Override
        public void run() {
            System.out.println(number);
            System.out.println(ready);
            while (!ready) {
                Thread.yield();
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }

}
