package acki.workshop1;

public class Temperature {
    private double temperature = 273.0;
    private static TType standardType = TType.CELSIUS;

    public Temperature() {
    }

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

    public double getTemp(TType type) {
        switch (type) {
            case CELSIUS:
                return Math.round(getC() * 100.0) / 100.0;
            case FAHRENHEIT:
                return Math.round(getF() * 100.0) / 100.0;
            case KELVIN:
                return Math.round(getK() * 100.0) / 100.0;
            default:
                return 0;
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

    @Override
    public String toString() {
        return "" + getTemp(Temperature.standardType);
    }
}

enum TType {
    CELSIUS, FAHRENHEIT, KELVIN
}