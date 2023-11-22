package main.java.acki.workshop1;

public class Floor {
    private Sensor[] sensors;

    public addSensor(Sensor sensor) {
        // Check through the array to find the next empty spot
        for (int i = 0; i < sensors.length; i++) {
            if (sensors[i] == null) {
                sensors[i] = sensor;
                return;
            }
        }

        // If we get here, there are no empty spots so expand the array by creating a new array +4 the size.
        Sensor[] newSensors = new Sensor[sensors.length + 4];

        // Copy the old array into the new array
        for (int i = 0; i < sensors.length; i++) {
            newSensors[i] = sensors[i];
        }

        // Add the new sensor to the new array
        newSensors[sensors.length] = sensor;

        // Set the new array as the sensors array
        this.sensors = newSensors;
    }

    public removeSensor(Sensor sensor)
    {
        // Check through the array to find the sensor
        for (int i = 0; i < sensors.length; i++) {
            if (sensors[i] == sensor) {
                sensors[i] = null;
            }
        }

        // Now compact the array by creating a new array -1 the size.
        Floor[] newSensors = new Floor[sensors.length - 1];

        // Copy the old array into the new array
        int extra_index = 0;
        for (int i = 0; i < sensors.length; i++) {
            if(sensors[i] != null) {
                newSensors[i - extra_index] = sensors[i];
            } else {
                extra_index++;
            }
        }

        // Set the new array as the floors array
        this.sensors = newSensors;
    }

    public removeSensor(int index)
    {
        // Check if the index is within bounds.
        if (index < 0 || index >= sensors.length)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", is out of bounds.");
        }

        // Remove the floor at the index
        sensors[index] = null;

        // Now compact the array by creating a new array -1 the size.
        Floor[] newSensors = new Floor[sensors.length - 1];

        // Copy the old array into the new array
        int extra_index = 0;
        for (int i = 0; i < floors.length; i++) {
            if(sensors[i] != null) {
                newSensors[i - extra_index] = sensors[i];
            } else {
                extra_index++;
            }
        }

        // Set the new array as the floors array
        this.sensors = newSensors;
    }
}
