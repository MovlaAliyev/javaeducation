package dogdoors;

import java.util.Timer;
import java.util.TimerTask;

public class Remote {

    private DogDoor door;

    public Remote(DogDoor door) {
        this.door = door;
    }

    public void pressButton() {
        System.out.println("Pressing remote control button....");
        if (door.isOpen()) {
            door.close();
        } else {
            door.open();
            final Timer t = new Timer();
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    door.close();
                    t.cancel();
                }
            }, 5000);
        }
    }
}
