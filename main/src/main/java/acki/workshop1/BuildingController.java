package acki.workshop1;

import java.util.Scanner;

public class BuildingController {
    private Building[] buildings;
    
    public BuildingController() {
        buildings = new Building[3];
        for (int i = 0; i < buildings.length; i++) {
            Building building = new Building();
            Floor floor = new Floor();
            Sensor sensor = new TemperatureSensor();
            Actuator actuator = new WindowActuator(false);
            floor.addSensor(sensor);
            floor.addActuator(actuator);
            building.addFloor(floor);
            buildings[i] = building;
        }
    }

    public void errOut(Object... objects)
    {
        System.out.print("\u001B[31m");
        for (Object object : objects) {
            System.out.print(object);
        }
        System.out.println("\u001B[0m");
    }

    public boolean wish() {
        // Take input from the user
        System.out.println("What do you want to do?");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputs = input.split(" ");
        switch (inputs[0]) {
            case "help":
                System.out.println("Commands:");
                System.out.println("help - Show this help");
                System.out.println("add <building|floor|sensor|actuator> - Add a building, floor, sensor or actuator");
                System.out.println("list - List all buildings, floors, sensors and actuators");
                System.out.println("exit - Exit the program");
                break;
            case "add":
                switch (inputs[1]) {
                    case "building":
                        // Find empty spot in array
                        boolean found = false;
                        for (int i = 0; i < this.buildings.length; i++) {
                            if (this.buildings[i] == null) {
                                this.buildings[i] = new Building();
                                found = true;
                                break;
                            }
                        }
                        if (found) {
                            System.out.println("Building added");
                        } else {
                            // Extend array
                            Building[] newBuildings = new Building[this.buildings.length + 4];
                            for (int i = 0; i < this.buildings.length; i++) {
                                newBuildings[i] = this.buildings[i];
                            }
                            newBuildings[buildings.length] = new Building();
                            this.buildings = newBuildings;
                        }
                        break;
                    case "floor":
                        int building_index;
                        try {
                            building_index = Integer.parseInt(inputs[2]);
                        } catch (Exception e) {
                            errOut("\u001B[31mInvalid building index - Proper Useage 'add floor <building_index>'\u001B[0m");
                            break;
                        }
                        if (building_index < 0 || building_index >= this.buildings.length) {
                            errOut("\u001B[31mBuilding index outside bounds\u001B[0m");
                            break;
                        }
                        this.buildings[building_index].addFloor(new Floor());
                        break;
                    case "sensor":
                        break;
                    case "actuator":
                        break;
                    default:
                        errOut("Unknown type (" + inputs[1] + ") viable types: <building|floor|sensor|actuator>");
                        break;
                }
                break;
            case "list":
                try {
                    // Check if the user provided a building index
                    int building_index = Integer.parseInt(inputs[1]);
                    if (building_index < 0 || building_index >= this.buildings.length) {
                        errOut("\u001B[31mBuilding index outside bounds\u001B[0m");
                        break;
                    }
                    System.out.println("Building (" + building_index + "):");
                    System.out.println(this.buildings[building_index]);
                } catch (Exception e) {
                    System.out.println("Buildings:");
                    for (int i = 0; i < this.buildings.length; i++) {
                        if (this.buildings[i] != null) {
                            System.out.println("Building (" + i + "):\n" + this.buildings[i].toString());
                        }
                    }
                }
                break;
            case "exit":
                return false;
            default:
                errOut("Unknown command use 'help' for a list of commands");
                break;
        }
        return true;
    }

    public static void main(String[] args) {
        BuildingController bc = new BuildingController();
        while (bc.wish()) {
            int building_count = 0;
            for (Building building : bc.buildings) {
                if (building != null) {
                    building_count++;
                }
            }
            System.out.println("Buildings (" + building_count + ")");
        }
    }
}
