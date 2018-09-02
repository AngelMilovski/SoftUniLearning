package raw_data;

class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tyre tyre;
    private Tyre[] tyres;

    Car(String model, Engine engine, Cargo cargo, Tyre... tyres) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tyres = tyres;
        this.tyre = tyres[0];
    }

    public String getModel() {
        return this.model;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Tyre getTyre() {
        return this.tyre;
    }
}
