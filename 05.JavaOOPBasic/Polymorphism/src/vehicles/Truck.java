package vehicles;

public class Truck extends Vehicle {
    private static final double FUEL_CONSUMPTION_PER_KM_WITH_AIR_CONDITIONING = 1.6;

    public Truck(double fuelQuantity, double litersPerKm, double fuelCapacity) {
        super(fuelQuantity, litersPerKm, fuelCapacity);
    }

    @Override
    protected void refuel(double quantity) {
        super.refuel(quantity - (quantity * 5 /100));
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
