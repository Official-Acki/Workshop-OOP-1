package acki.workshop1;

public class Floor {
    private Sensor[] sensors;

    public  void addSensor(Sensor sensor) {
        // Check through the array to find the next empty spot
        for (int i = 0; i < this.sensors.length; i++) {
            if (this.sensors[i] == null) {
                this.sensors[i] = sensor;
                return;
            }
        }

        // If we get here, there are no empty spots so expand the array by creating a new array +4 the size.
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

    public void removeSensor(Sensor sensor)
    {
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
            if(this.sensors[i] != null) {
                newSensors[i - extra_index] = this.sensors[i];
            } else {
                extra_index++;
            }
        }

        // Set the new array as the floors array
        this.sensors = newSensors;
    }

    public void removeSensor(int index)
    {
        // Check if the index is within bounds.
        if (index < 0 || index >= this.sensors.length)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", is out of bounds.");
        }

        // Remove the floor at the index
        this.sensors[index] = null;

        // Now compact the array by creating a new array -1 the size.
        Sensor[] newSensors = new Sensor[sensors.length - 1];

        // Copy the old array into the new array
        int extra_index = 0;
        for (int i = 0; i < this.sensors.length; i++) {
            if(this.sensors[i] != null) {
                newSensors[i - extra_index] = this.sensors[i];
            } else {
                extra_index++;
            }
        }

        // Set the new array as the floors array
        this.sensors = newSensors;
    }
}
