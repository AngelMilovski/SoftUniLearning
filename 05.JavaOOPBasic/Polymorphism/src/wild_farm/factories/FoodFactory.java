package wild_farm.factories;

import wild_farm.abstract_classes.Food;
import wild_farm.foods.Meat;
import wild_farm.foods.Vegetable;

public class FoodFactory {

    public Food getFood(String[] foodTokens) {
        String foodType = foodTokens[0];
        int foodQuantity = Integer.parseInt(foodTokens[1]);
        switch (foodType.toLowerCase()) {
            case "vegetable": return new Vegetable(foodQuantity);
            case "meat": return new Meat(foodQuantity);
            default: return null;
        }
    }
}
