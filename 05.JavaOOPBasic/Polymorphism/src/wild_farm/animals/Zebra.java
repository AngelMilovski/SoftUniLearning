package wild_farm.animals;

import wild_farm.abstract_classes.Food;
import wild_farm.abstract_classes.Mammal;

public class Zebra extends Mammal {
    private static final String THE_FOOD_THE_ZEBRA_DOES_NOT_EAT = "Zebras are not eating that type of food!";
    private static final String ZEBRA_SOUND = "Zs";

    public Zebra(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println(ZEBRA_SOUND);
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equalsIgnoreCase("meat")) {
            throw new IllegalArgumentException(THE_FOOD_THE_ZEBRA_DOES_NOT_EAT);
        }
        super.eat(food);
    }
}
