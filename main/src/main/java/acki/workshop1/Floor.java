package acki.workshop1;

public class Floor {
    private Sensor[] sensors;
    private Actuator[] actuators;
    private Range co2Thresh = new Range(1, 400); // ppm
    private Range tempThresh = new Range(14, 20); // Celsius

    public void addSensor(Sensor sensor) {
        // Check through the array to find the next empty spot
        for (int i = 0; i < this.sensors.length; i++) {
            if (this.sensors[i] == null) {
                this.sensors[i] = sensor;
                return;
            }
        }

        // If we get here, there are no empty spots so expand the array by creating a
        // new array +4 the size.
        Sensor[] newSensors = new Sensor[this.sensors.length + 4];

        // Copy the old array into the new array
        for (int i = 0; i < this.sensors.length; i++) {
            newSensors[i] = this.sensors[i];
        }

        // Add the new sensor to the new array
        newSensors[this.sensors.length] = sensor;

        // Set the new array as the sensors array
        this.sensors = newSensors;
    }

    public void removeSensor(Sensor sensor) {
        // Check through the array to find the sensor
        for (int i = 0; i < this.sensors.length; i++) {
            if (this.sensors[i] == sensor) {
                this.sensors[i] = null;
            }
        }

        // Now compact the array by creating a new array -1 the size.
        Sensor[] newSensors = new Sensor[this.sensors.length - 1];

        // Copy the old array into the new array
        int extra_index = 0;
        for (int i = 0; i < this.sensors.length; i++) {
            if (this.sensors[i] != null) {
                newSensors[i - extra_index] = this.sensors[i];
            } else {
                extra_index++;
            }
        }

        // Set the new array as the floors array
        this.sensors = newSensors;
    }

    public void removeSensor(int index) {
        // Check if the index is within bounds.
        if (index < 0 || index >= this.sensors.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", is out of bounds.");
        }

        // Remove the floor at the index
        this.sensors[index] = null;

        // Now compact the array by creating a new array -1 the size.
        Sensor[] newSensors = new Sensor[sensors.length - 1];

        // Copy the old array into the new array
        int extra_index = 0;
        for (int i = 0; i < this.sensors.length; i++) {
            if (this.sensors[i] != null) {
                newSensors[i - extra_index] = this.sensors[i];
            } else {
                extra_index++;
            }
        }

        // Set the new array as the floors array
        this.sensors = newSensors;
    }

    public Temperature getAvgTemp() {
        if (this.sensors.length == 0) {
            Temperature temp = new Temperature();
            temp.setTemp(0, TType.CELSIUS);
            return temp;
        }

        Temperature temp = new Temperature();
        double total = 0;
        int tempSens = 0;
        for (int i = 0; i < this.sensors.length; i++) {
            if (this.sensors[i] != null && this.sensors[i] instanceof TemperatureSensor) {
                total += ((Temperature) this.sensors[i].getReading()).getK();
                tempSens++;
            }
        }
        total /= tempSens;
        temp.setTemp(total, TType.KELVIN);

        return temp;
    }

    public double getAvgCO2() {
        if (this.sensors.length == 0) {
            return 0;
        }

        double total = 0;
        int co2Sens = 0;
        for (int i = 0; i < this.sensors.length; i++) {
            if (this.sensors[i] != null && this.sensors[i] instanceof CO2Sensor) {
                total += ((CO2) this.sensors[i].getReading()).getCO2();
                co2Sens++;
            }
        }
        total /= co2Sens;

        return total;
    }

    public void addActuator(Actuator actuator) {
        // Find the next empty space
        for (int i = 0; i < this.actuators.length; i++) {
            if (this.actuators[i] == null) {
                this.actuators[i] = actuator;
                return;
            }
        }

        // No space
        Actuator[] newActuators = new Actuator[this.actuators.length + 4];

        // Copy the old array into the new array
        for (int i = 0; i < this.actuators.length; i++) {
            newActuators[i] = this.actuators[i];
        }

        // Add the new actuator to the new array
        newActuators[this.actuators.length] = actuator;

        // Set the new array as the actuators array
        this.actuators = newActuators;
    }

    public void removeActuator(Actuator actuator) {
        for (int i = 0; i < this.actuators.length; i++) {
            if (this.actuators[i] == actuator) {
                this.actuators[i] = null;
                return;
            }
        }

    }

    public void evaluateAndAct()
    {
        // Compare Temperature to threshold
        short evaluated = tempThresh.evaluate(this.getAvgTemp().getC());
        if (evaluated == 2) 
        {
            // Temperature is too high open windows
            for (int i = 0; i < this.actuators.length; i++) {
                if (this.actuators[i] != null && this.actuators[i] instanceof WindowActuator) {
                    ((WindowActuator) this.actuators[i]).setOpen(true);
                }
            }
        } else if (evaluated == 1)
        {
            // Temperature is too low close windows
            for (int i = 0; i < this.actuators.length; i++) {
                if (this.actuators[i] != null && this.actuators[i] instanceof WindowActuator) {
                    ((WindowActuator) this.actuators[i]).setOpen(false);
                }
            }
        }

        // Compare CO2 to threshold
        evaluated = co2Thresh.evaluate(this.getAvgCO2());
        if (evaluated == 2) 
        {
            // CO2 is too high open vents
            for (int i = 0; i < this.actuators.length; i++) {
                if (this.actuators[i] != null && this.actuators[i] instanceof VentActuator) {
                    ((VentilationActuator) this.actuators[i]).setOpen(true);
                }
            }
        } else if (evaluated == 1)
        {
            // CO2 is too low close vents
            for (int i = 0; i < this.actuators.length; i++) {
                if (this.actuators[i] != null && this.actuators[i] instanceof VentActuator) {
                    ((VentilationActuator) this.actuators[i]).setOpen(false);
                }
            }
        }   low close windows}ol oot si erutarep
        }
    }
}
