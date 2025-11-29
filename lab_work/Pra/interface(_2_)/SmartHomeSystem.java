
interface Switchable {
    void turnOn();
    void turnOff();

    default void status() {
        System.out.println("Device status checked.");
    }

    static void saveEnergy() {
        System.out.println("Tip: Turn off unused devices to save energy!");
    }
}

interface Schedulable {
    void schedule(String time);

    default void cancelSchedule() {
        System.out.println("Schedule cancelled.");
    }
}

interface SensorEnabled {
    void detect();
}

class Light implements Switchable, Schedulable {
    public void turnOn() { System.out.println("Light turned ON"); }
    public void turnOff() { System.out.println("Light turned OFF"); }
    public void schedule(String time) { System.out.println("Light scheduled at " + time); }
}

class Fan implements Switchable {
    public void turnOn() { System.out.println("Fan turned ON"); }
    public void turnOff() { System.out.println("Fan turned OFF"); }
}

class Thermostat implements Switchable, Schedulable, SensorEnabled {
    public void turnOn() { System.out.println("Thermostat ON"); }
    public void turnOff() { System.out.println("Thermostat OFF"); }
    public void schedule(String time) { System.out.println("Thermostat scheduled at " + time); }
    public void detect() { System.out.println("Thermostat detecting room temperature..."); }
}

class Camera implements Switchable, SensorEnabled {
    public void turnOn() { System.out.println("Camera ON"); }
    public void turnOff() { System.out.println("Camera OFF"); }
    public void detect() { System.out.println("Camera motion detected!"); }
}

public class SmartHomeSystem {
    public static void main(String[] args) {
        Light light = new Light();
        Fan fan = new Fan();
        Thermostat thermostat = new Thermostat();
        Camera camera = new Camera();

        light.turnOn();
        light.schedule("8:00 PM");
        light.status(); 

        fan.turnOn();
        fan.status();

        thermostat.turnOn();
        thermostat.detect();
        thermostat.schedule("6:00 AM");

        camera.turnOn();
        camera.detect();

        Switchable.saveEnergy();
        System.out.println("24CE092-Prince Patel");
    }
}
