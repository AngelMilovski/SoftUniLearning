package ferrari;

public class Ferrari implements Car {
    private static final String BRAKES = "Brakes!";
    private static final String GAS = "Zadu6avam sA!";
    private static final String MODEL = "488-Spider";

    private String driverName;

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String brakesPushedDown() {
        return BRAKES;
    }

    @Override
    public final String gasPushedDown() {
        return GAS;
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", MODEL, this.brakesPushedDown(), this.gasPushedDown(), this.driverName);
    }
}
