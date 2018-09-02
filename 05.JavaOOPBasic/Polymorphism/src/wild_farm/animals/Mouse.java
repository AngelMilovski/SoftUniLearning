package wild_farm.animals;

import wild_farm.abstract_classes.Food;
import wild_farm.abstract_classes.Mammal;

public class Mouse extends Mammal {
    private static final String THE_FOOD_THE_MOUSE_DOES_NOT_EAT = "Mice are not eating that type of food!";
    private static final String MOUSE_SOUND = "SQUEEEAAAK!";

    public Mouse(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println(MOUSE_SOUND);
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equalsIgnoreCase("meat")) {
            throw new IllegalArgumentException(THE_FOOD_THE_MOUSE_DOES_NOT_EAT);
        }
        super.eat(food);
    }
}
