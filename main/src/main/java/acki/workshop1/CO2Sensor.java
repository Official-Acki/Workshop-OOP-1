package acki.workshop1;

public class CO2Sensor extends Sensor {
    private CO2 co2;

    public CO2Sensor() {
        co2 = new CO2();
    }

    @Override
    public Object getReading() {
        return co2;
    }

    public CO2 getCo2() {
        return co2;
    }

    @Override
    public String toString() {
        return "TemperatureSensor (" + co2.getCO2() + "ppm)";
    }
}
