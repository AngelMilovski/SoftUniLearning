package vehicles;

public class Car extends Vehicle {
    private static final double FUEL_CONSUMPTION_PER_KM_WITH_AIR_CONDITIONING = 0.9;
    public Car(double fuelQuantity, double litersPerKm, double fuelCapacity) {
        super(fuelQuantity, litersPerKm, fuelCapacity);
    }

    @Override
    public boolean travel(double distance) {
        double fuelQuantity = super.getFuelQuantity();
        double neededFuel = distance * (super.getLitersPerKm() + FUEL_CONSUMPTION_PER_KM_WITH_AIR_CONDITIONING);
        if (neededFuel > super.getFuelQuantity()) {
            return false;
        }
        fuelQuantity -= neededFuel;
        super.setFuelQuantity(fuelQuantity);
        return true;
    }
}
