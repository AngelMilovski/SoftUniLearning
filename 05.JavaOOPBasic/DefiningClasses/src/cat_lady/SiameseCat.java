package cat_lady;

class SiameseCat extends Cat {
    private double earSize;

    SiameseCat(String name, double earSize) {
        super(name);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("Siamese %s %.2f", super.getName(), this.earSize);
    }
}