package cat_lady;

abstract class Cat {
    private String name;

    Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}