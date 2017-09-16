package controlframework;

public class ControlFramework {

    public static void main(String[] args) {
        GreenHouseController controller = new GreenHouseController();

        
        controller.addEvent(controller.new Bell(900));
        Event[] eventList = {
            controller.new ThermostatNight(0),
            controller.new LightOn(200),
            controller.new LightOff(400),
            controller.new WaterOn(600),
            controller.new WaterOff(800),
            controller.new ThermostatDay(1400)
        };

        controller.addEvent(controller.new Restart(2000, eventList));

        controller.addEvent(
                new GreenHouseController.Terminate(
                        5000));

        controller.run();
    }

}
