package acki.workshop1;

public class TemperatureSensor extends Sensor {
    private Temperature temperature;

    @Override
    public Object getReading() {
        return temperature;
    }

    public Temperature getTemp() {
        return temperature;
    }

    @Override
    public String toString() {
        return "TemperatureSensor (" + temperature.getC() + "°C)";
    }
}
