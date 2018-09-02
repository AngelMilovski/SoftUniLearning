package cat_lady;

class CymricCat extends Cat {
    private double furLength;

     CymricCat(String name, double furLength) {
        super(name);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("Cymric %s %.2f", super.getName(), this.furLength);
    }
}