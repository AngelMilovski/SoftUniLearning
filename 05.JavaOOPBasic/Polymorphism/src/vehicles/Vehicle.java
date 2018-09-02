package vehicles;

public abstract class Vehicle {
    private double fuelQuantity;
    private double litersPerKm;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double litersPerKm, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setLitersPerKm(litersPerKm);
        this.setTankCapacity(tankCapacity);
    }

    private void setLitersPerKm(double litersPerKm) {
        this.litersPerKm = litersPerKm;
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    protected void refuel(double currentQuantity) {
        double total = this.fuelQuantity + currentQuantity;
        if (currentQuantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        } else if (total > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.setFuelQuantity(this.fuelQuantity + currentQuantity);
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
//        } else if (fuelQuantity > this.tankCapacity) {
//            throw new IllegalArgumentException("Cannot fit fuel in tank");
//        }
        this.fuelQuantity = fuelQuantity;
    }

    public double getLitersPerKm() {
        return this.litersPerKm;
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public abstract boolean travel(double distance);

    public boolean travelEmpty(double distance) {
        double neededFuel = distance * this.litersPerKm;
        if (neededFuel > this.fuelQuantity) {
            return false;
        }
        this.fuelQuantity -= neededFuel;
        return true;
    }


    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}
