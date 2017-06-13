package dogdoors;

import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {

    private boolean open;
    private Bark allowedBark;

    public DogDoor() {
        open = false;
    }

    public void open() {
        System.out.println("The dog door opens.");
        open = true;
        final Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                close();
                t.cancel();
            }
        }, 5000);
    }

    public void close() {
        System.out.println("The dog door closes.");
        open = false;
    }

    public boolean isOpen() {
        return open;
    }

    public Bark getAllowedBark() {
        return allowedBark;
    }

    public void setAllowedBark(Bark allowedBark) {
        this.allowedBark = allowedBark;
    }

}
