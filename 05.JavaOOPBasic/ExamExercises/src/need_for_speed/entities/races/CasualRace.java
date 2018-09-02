package need_for_speed.entities.races;

import need_for_speed.entities.cars.Car;

import java.util.List;

public class CasualRace extends Race {
    public CasualRace(int length, String route, int prizePool, List<Car> cars) {
        super(length, route, prizePool, cars);
    }
}
