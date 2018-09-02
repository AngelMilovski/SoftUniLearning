package need_for_speed.entities.races;

import need_for_speed.entities.cars.Car;

import java.util.List;

public class DriftRace extends Race {
    public DriftRace(int length, String route, int prizePool, List<Car> cars) {
        super(length, route, prizePool, cars);
    }
}
