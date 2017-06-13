package dogdoors;

import java.util.Timer;
import java.util.TimerTask;

public class DogDoors {

    public static void main(String[] args) {
        DogDoor door = new DogDoor();
        Remote remote = new Remote(door);
        BarkRecognizer barkRecognizer = new BarkRecognizer(door);

        System.out.println("Fido barks to go outside...");
        remote.pressButton();

        System.out.println("\nFido has gone outside...");
        //remote.pressButton();

        System.out.println("\nFido's all done...");
        //remote.pressButton();
        final Timer t = new Timer();
        t.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("Dog Fucked up");
                t.cancel();
                barkRecognizer.recognize("Woof");
            }
        }, 10000);
        System.out.println("\nFido's back inside...");
        //remote.pressButton();
    }

}
