package p03_coffee_machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        CoffeeMachine vending = new CoffeeMachine();
        String debug = "";
        String line;

        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }
            String[] cmdArgs = line.split(" ");

            if (cmdArgs.length == 2) {
                vending.buyCoffee(cmdArgs[0].toUpperCase(), cmdArgs[1].toUpperCase());
            } else {
                vending.insertCoin(cmdArgs[0].toUpperCase());
            }
        }
        for (Coffee coffee : vending.coffeesSold()) {
            System.out.println(coffee);
        }
    }
}
