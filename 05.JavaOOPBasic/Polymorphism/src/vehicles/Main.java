package vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    private static final DecimalFormat df = new DecimalFormat("#.##");

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String[] carTokens = reader.readLine().split(" ");
        double carFuelQuantity = Double.parseDouble(carTokens[1]);
        double carConsumption = Double.parseDouble(carTokens[2]);
        double carFuelCapacity = Double.parseDouble(carTokens[3]);

        String[] truckTokens = reader.readLine().split(" ");
        double truckFuelQuantity = Double.parseDouble(truckTokens[1]);
        double truckConsumption = Double.parseDouble(truckTokens[2]);
        double truckFuelCapacity = Double.parseDouble(truckTokens[3]);

        String[] busTokens = reader.readLine().split(" ");
        double busFuelQuantity = Double.parseDouble(busTokens[1]);
        double busConsumption = Double.parseDouble(busTokens[2]);
        double busFuelCapacity = Double.parseDouble(busTokens[3]);

        Vehicle car = new Car(carFuelQuantity, carConsumption, carFuelCapacity);
        Vehicle truck = new Truck(truckFuelQuantity, truckConsumption, truckFuelCapacity);
        Vehicle bus = new Bus(busFuelQuantity, busConsumption, busFuelCapacity);

        int numberOfCommands = Integer.parseInt(reader.readLine());

        while (numberOfCommands-- > 0) {
            String[] commandTokens = reader.readLine().split(" ");
            try {
                String command = commandTokens[0];
                String vehicleType = commandTokens[1];
                String token = commandTokens[2];
                switch (command) {
                    case "DriveEmpty":
                        executeDriveEmptyCommand(token, car, truck, bus, vehicleType);
                        break;
                    case "Drive":
                        executeDriveCommand(token, car, truck, bus, vehicleType);
                        break;
                    case "Refuel":
                        executeRefuel(token, car, truck, bus, vehicleType);
                        break;
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }

    private static void executeDriveEmptyCommand(String token, Vehicle car, Vehicle truck, Vehicle bus, String vehicleType) {
        double distance = Double.parseDouble(token);
        switch (vehicleType) {
            case "Car":
                if (car.travelEmpty(distance)) {
                    System.out.println(String.format("Car travelled %s km", df.format(distance)));
                } else {
                    System.out.println("Car needs refueling");
                }
                break;
            case "Truck":
                if (truck.travelEmpty(distance)) {
                    System.out.println(String.format("Truck travelled %s km", df.format(distance)));
                } else {
                    System.out.println("Truck needs refueling");
                }
                break;
            case "Bus":
                if (bus.travelEmpty(distance)) {
                    System.out.println(String.format("Bus travelled %s km", df.format(distance)));
                } else {
                    System.out.println("Bus needs refueling");
                }
                break;
        }
    }

    private static void executeRefuel(String token, Vehicle car, Vehicle truck, Vehicle bus, String vehicleType) {
        double quantity = Double.parseDouble(token);
        switch (vehicleType) {
            case "Car":
                car.refuel(quantity);
                break;
            case "Truck":
                truck.refuel(quantity);
                break;
            case "Bus":
                bus.refuel(quantity);
                break;
        }
    }

    private static void executeDriveCommand(String token, Vehicle car, Vehicle truck, Vehicle bus, String vehicleType) {
        double distance = Double.parseDouble(token);
        switch (vehicleType) {
            case "Car":
                if (car.travel(distance)) {
                    System.out.println(String.format("Car travelled %s km", df.format(distance)));
                } else {
                    System.out.println("Car needs refueling");
                }
                break;
            case "Truck":
                if (truck.travel(distance)) {
                    System.out.println(String.format("Truck travelled %s km", df.format(distance)));
                } else {
                    System.out.println("Truck needs refueling");
                }
                break;
            case "Bus":
                if (bus.travel(distance)) {
                    System.out.println(String.format("Bus travelled %s km", df.format(distance)));
                } else {
                    System.out.println("Bus needs refueling");
                }
                break;
        }
    }
}