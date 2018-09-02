package raw_data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        List<Car> cars = getCars(reader);
        printCars(reader, cars);
    }

    private static void printCars(BufferedReader reader, List<Car> cars) throws IOException {
        String command = reader.readLine();

        switch (command) {
            case "fragile":
                cars.stream().filter(c -> c.getCargo().getType().equals("fragile")).filter(t ->
                        t.getTyre().getPressure() < 1).forEach(car -> System.out.println(car.getModel()));

                break;
            case "flamable":
                cars.stream().filter(c -> c.getCargo().getType().equals("flamable")).filter(e ->
                        e.getEngine().getPower() > 250).forEach(car -> System.out.println(car.getModel()));
                break;
        }
    }

    private static List<Car> getCars(BufferedReader reader) throws IOException {

        List<Car> cars = new ArrayList<>();
        int countOfCar = Integer.parseInt(reader.readLine());

        while (cars.size() < countOfCar) {
            String[] tokens = reader.readLine().split(" ");
            String carModel = tokens[0];
            int engineSpeed = Integer.valueOf(tokens[1]);
            int enginePower = Integer.valueOf(tokens[2]);
            int cargoWeight = Integer.valueOf(tokens[3]);
            String cargoType = tokens[4];

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tyre[] tyres = new Tyre[]{
                    new Tyre(Double.valueOf(tokens[5]), Integer.valueOf(tokens[6])),
                    new Tyre(Double.valueOf(tokens[7]), Integer.valueOf(tokens[8])),
                    new Tyre(Double.valueOf(tokens[9]), Integer.valueOf(tokens[10])),
                    new Tyre(Double.valueOf(tokens[11]), Integer.valueOf(tokens[12])),
            };
            cars.add(new Car(carModel, engine, cargo, tyres));
        }
        return cars;
    }
}