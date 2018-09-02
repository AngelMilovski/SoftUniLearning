package need_for_speed.entities.cars;



public class ShowCar extends Car {
    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsepower,
                   int acceleration, int suspension, int durability, int stars) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.stars = 0;
    }

    @Override
    public String toString() {
        StringBuilder showCar = new StringBuilder(super.toString());
        showCar
                .append(String.format("%d *", this.stars));

        return super.toString();
    }
}
