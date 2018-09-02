package p03_coffee_machine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {

    private List<Coin> coins;
    private List<Coffee> coffees;

    public CoffeeMachine() {
        this.coins = new ArrayList<>();
        this.coffees = new ArrayList<>();
    }

    void buyCoffee(String size, String type) {
        CoffeeType coffeeType = CoffeeType.valueOf(type);
        CoffeeSize coffeeSize = CoffeeSize.valueOf(size);
        Coffee coffee = new Coffee(coffeeSize, coffeeType);
        int coffeePrice = coffeeSize.getPrice();
        int currentSum = this.coins.stream().mapToInt(Coin::getValue).sum();
        if (coffeePrice <= currentSum) {
            this.coffees.add(coffee);
//            this.coins.clear();
        }
    }

    void insertCoin(String coin) {
        Coin cents = Coin.valueOf(coin);
        this.coins.add(cents);
    }

    Iterable<Coffee> coffeesSold() {
        return this.coffees;
    }
}
