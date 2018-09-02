package wild_farm.factories;

import wild_farm.abstract_classes.Animal;
import wild_farm.animals.Cat;
import wild_farm.animals.Mouse;
import wild_farm.animals.Tiger;
import wild_farm.animals.Zebra;

public class AnimalFactory {
    public Animal getAnimal(String[] tokens) {
        String type = tokens[0];
        String animalName = tokens[1];
        double animalWeight = Double.parseDouble(tokens[2]);
        String livingRegion = tokens[3];

        switch (type.toLowerCase()) {
            case "mouse": return new Mouse(animalName, type, animalWeight, livingRegion);
            case "cat":
                String catBreed = tokens[4];
                return new Cat(animalName, type, animalWeight, livingRegion, catBreed);
            case "zebra": return new Zebra(animalName, type, animalWeight, livingRegion);
            case "tiger": return new Tiger(animalName, type, animalWeight, livingRegion);
            default: return null;
        }
    }
}
