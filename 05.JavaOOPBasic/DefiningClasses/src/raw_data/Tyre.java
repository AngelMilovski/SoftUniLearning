package raw_data;

class Tyre {
    private double pressure;
    private int age;


    public Tyre(double pressure, int age) {
        this.pressure = pressure;
        this.age = age;
    }

    public double getPressure() {
        return this.pressure;
    }
}
