package need_for_speed.entities.cars;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {
    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower,
                          int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
    }

    @Override
    public void setHorsepower(int horsepower) {
        int increasedHorsepower = horsepower + ((horsepower * 50) / 100);
        super.setHorsepower(increasedHorsepower);
    }

    @Override
    protected void setSuspension(int suspension) {
        int currentSuspension = suspension - ((suspension * 25) / 100);
        super.setSuspension(currentSuspension);
    }

    @Override
    public String toString() {
        StringBuilder performanceCar = new StringBuilder(super.toString());
        String addOns = this.addOns.isEmpty() ? null : String.join(", ", this.addOns);
        performanceCar
                .append(String.format("Add-ons: ", addOns));
        return performanceCar.toString();
    }
}
