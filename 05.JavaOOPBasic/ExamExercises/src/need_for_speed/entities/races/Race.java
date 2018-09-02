package need_for_speed.entities.races;

import need_for_speed.entities.cars.Car;

import java.util.List;

public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private List<Car> cars;

    public Race(int length, String route, int prizePool, List<Car> cars) {
        this.setLength(length);
        this.setRoute(route);
        this.setPrizePool(prizePool);
        this.setCars(cars);
    }

    private void setLength(int length) {
        this.length = length;
    }

    private void setRoute(String route) {
        this.route = route;
    }

    private void setPrizePool(int prizePool) {
        this.prizePool = prizePool;
    }

    private void setCars(List<Car> cars) {
        this.cars = cars;
    }

}
