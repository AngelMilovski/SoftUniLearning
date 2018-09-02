package wild_farm.abstract_classes;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private double animalWeight;
    private int foodEaten;

    public Animal(){
    }

    public Animal(String animalName, String animalType, Double animalWeight) {
        this.setAnimalType(animalType);
        this.setAnimalName(animalName);
        this.setAnimalWeight(animalWeight);

    }

    private void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    private void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    private void setAnimalWeight(Double animalWeight) {
        this.animalWeight = animalWeight;
    }

    protected final String getAnimalName() {
        return this.animalName;
    }

    protected final String getAnimalType() {
        return this.animalType;
    }

    protected final Double getAnimalWeight() {
        return this.animalWeight;
    }

    protected Integer getFoodEaten() {
        return this.foodEaten;
    }

    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }

    public abstract void makeSound();
}