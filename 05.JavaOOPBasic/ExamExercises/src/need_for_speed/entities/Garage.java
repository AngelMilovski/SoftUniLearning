package need_for_speed.entities;

import need_for_speed.entities.cars.Car;

import java.util.List;

public class Garage {
    private List<Car> cars;

    public Garage(List<Car> cars) {
        this.cars = cars;
    }

    public boolean hasParkedCars() {
        if (this.cars.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
