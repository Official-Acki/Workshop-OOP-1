package main.java.acki.workshop1;

public class Temperature {
    private double temperature;

    public void setTemp(double temperature, TType type) {
        switch (type) {
            case CELSIUS:
                this.temperature = temperature + 273.15;
                break;
            case FAHRENHEIT:
                this.temperature = (temperature - 32) * 5 / 9 + 273.15;
                break;
            case KELVIN:
                this.temperature = temperature;    
                break;
            default:
                break;
        }
    }

    public double getK()
    {
        return temperature;
    }

    public double getC()
    {
        return temperature - 273.15;
    }

    public double getF()
    {
        return (temperature - 273.15) * 9 / 5 + 32;
    }
}

enum TType {
    CELSIUS, FAHRENHEIT, KELVIN
}