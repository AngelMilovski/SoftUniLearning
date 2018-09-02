package cat_lady;

class StreetCat extends Cat {
    private double meowDecibels;

    StreetCat(String name, double meowDecibels) {
        super(name);
        this.meowDecibels = meowDecibels;
    }

    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %.2f", super.getName(), this.meowDecibels);
    }
}