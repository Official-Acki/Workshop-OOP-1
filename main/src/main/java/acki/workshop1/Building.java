package main.java.acki.workshop1;

public class Building {
    private Floor[] floors = new Floor[10];

    public addFloor(Floor floor) {
        // Check through the array to find the next empty spot
        for (int i = 0; i < floors.length; i++) {
            if (floors[i] == null) {
                floors[i] = floor;
                return;
            }
        }

        // If we get here, there are no empty spots so expand the array by creating a new array +4 the size.
        Floor[] newFloors = new Floor[floors.length + 4];

        // Copy the old array into the new array
        for (int i = 0; i < floors.length; i++) {
            newFloors[i] = floors[i];
        }

        // Add the new floor to the new array
        newFloors[floors.length] = floor;

        // Set the new array as the floors array
        this.floors = newFloors;
    }

    public removeFloor(Floor floor)
    {
        // Check through the array to find the floor
        for (int i = 0; i < floors.length; i++) {
            if (floors[i] == floor) {
                floors[i] = null;
            }
        }

        // Now compact the array by creating a new array -1 the size.
        Floor[] newFloors = new Floor[floors.length - 1];

        // Copy the old array into the new array
        int extra_index = 0;
        for (int i = 0; i < floors.length; i++) {
            if(floors[i] != null) {
                newFloors[i - extra_index] = floors[i];
            } else {
                extra_index++;
            }
        }

        // Set the new array as the floors array
        this.floors = newFloors;
    }

    public removeFloor(int index)
    {
        // Check if the index is within bounds.
        if (index < 0 || index >= floors.length)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", is out of bounds.");
        }

        // Remove the floor at the index
        floors[index] = null;

        // Now compact the array by creating a new array -1 the size.
        Floor[] newFloors = new Floor[floors.length - 1];

        // Copy the old array into the new array
        int extra_index = 0;
        for (int i = 0; i < floors.length; i++) {
            if(floors[i] != null) {
                newFloors[i - extra_index] = floors[i];
            } else {
                extra_index++;
            }
        }

        // Set the new array as the floors array
        this.floors = newFloors;
    }

    public Floor getFloor(int index)
    {
        // Check if the index is within bounds.
        if (index < 0 || index >= floors.length)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", is out of bounds.");
        }

        return floors[index];
    }

    public Temperature getAvgTemp()
    {
        // Not implemented.
        throw new Exception("Not implemented");
    }
    public CO2 getAvgCO2()
    {
        // Not implemented.
        throw new Exception("Not implemented");
    }
}
