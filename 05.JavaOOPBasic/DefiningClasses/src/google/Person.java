package google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Children> children;
    private List<Pokemon> pokemons;

     Person(String name) {
        this.setName(name);
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Parent> getParents() {
        return this.parents;
    }

    public void setParents(Parent parent) {
        this.parents.add(parent);
    }

    public List<Children> getChildren() {
        return this.children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    private String readList(List list) {
        StringBuilder sb = new StringBuilder();
        for (Object o : list) {
            sb.append(o).append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String toString() {

        String pokemons = readList(this.getPokemons());
        String parents = readList(this.getParents());
        String children = readList(this.getChildren());

        return String.format("%s%nCompany:%n%sCar:%n%sPokemon:%n%sParents:%n%sChildren:%n%s",
                this.getName(), this.getCompany() != null ? this.getCompany() : "",
                this.getCar() != null ? this.getCar() : "",
                this.getPokemons().isEmpty() ? "" : pokemons,
                this.getParents().isEmpty() ? "" : parents,
                this.getChildren().isEmpty() ? "" : children);
    }
}
