package wild_farm.animals;

import wild_farm.abstract_classes.Felime;
import java.text.DecimalFormat;

public class Cat extends Felime {
    private static final String CAT_SOUND = "Meowwww";

    private String catBreed;

    public Cat(String animalType, String animalName, Double animalWeight, String livingRegion, String catBreed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.setCatBreed(catBreed);
    }

    private void setCatBreed(String catBreed) {
        this.catBreed = catBreed;
    }

    private String getCatBreed() {
        return this.catBreed;
    }

    @Override
    public void makeSound() {
        System.out.println(CAT_SOUND);
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]",
                super.getAnimalType(),
                super.getAnimalName(),
                this.getCatBreed(),
                new DecimalFormat("#.##").format(super.getAnimalWeight()),
                super.getLivingRegion(),
                super.getFoodEaten());
    }
}
