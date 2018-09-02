package wild_farm.animals;

import wild_farm.abstract_classes.Felime;
import wild_farm.abstract_classes.Food;

public class Tiger extends Felime {
    private static final String THE_FOOD_THE_TIGER_DOES_NOT_EAT = "Tigers are not eating that type of food!";
    private static final String TIGER_SOUND = "ROAAR!!!";

    public Tiger(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println(TIGER_SOUND);
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equalsIgnoreCase("vegetable")) {
            throw new IllegalArgumentException(THE_FOOD_THE_TIGER_DOES_NOT_EAT);
        }
        super.eat(food);
    }
}
