import java.util.Scanner;

public class p08_CaloriesCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberIngredients = Integer.parseInt(scan.nextLine());

        int cheese = 500;
        int tomatoSauce = 150;
        int salami = 600;
        int pepper = 50;
        int totalCalories = 0;

        for (int i = 0; i < numberIngredients; i++) {
            String ingredient = scan.nextLine().toLowerCase();
            switch (ingredient){
                case "cheese":
                    totalCalories += cheese;
                    break;
                case "tomato sauce":
                    totalCalories += tomatoSauce;
                    break;
                case "salami":
                    totalCalories += salami;
                    continue;
                case "pepper":
                    totalCalories += pepper;
                    break;
            }
        }
        System.out.println(String.format("Total calories: %d", totalCalories));
    }
}
