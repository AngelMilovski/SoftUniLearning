package wild_farm;

import wild_farm.abstract_classes.Animal;
import wild_farm.abstract_classes.Food;
import wild_farm.factories.AnimalFactory;
import wild_farm.factories.FoodFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        List<Animal> animals = new ArrayList<>();
        AnimalFactory factory = new AnimalFactory();
        FoodFactory foodFactory = new FoodFactory();
        for (String line = reader.readLine(); !("End").equals(line); line = reader.readLine()) {

            String[] animalTokens = line.split("\\s+");
            Animal animal = factory.getAnimal(animalTokens);

            String[] foodTokens = reader.readLine().split("\\s+");
            Food food = foodFactory.getFood(foodTokens);
            animal.makeSound();
            try {
                animal.eat(food);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
            animals.add(animal);
        }
        animals.forEach(System.out::println);
    }
}
