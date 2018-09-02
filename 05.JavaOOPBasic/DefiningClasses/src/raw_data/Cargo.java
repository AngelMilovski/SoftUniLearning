package raw_data;

class Cargo {
    private String type;
    private int weight;

    public Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}