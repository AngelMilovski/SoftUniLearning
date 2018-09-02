package vehicles;

public class Bus extends Vehicle {
    private static final double FUEL_CONSUMPTION_PER_KM_WITH_AIR_CONDITIONING = 1.4;

    public Bus(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm, tankCapacity);
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
