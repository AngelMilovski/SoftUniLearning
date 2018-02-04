import java.util.Scanner;

public class p26_Pets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberDays = Integer.parseInt(scan.nextLine());
        int foodLeftPerKg = Integer.parseInt(scan.nextLine());
        double foodPerDayForDogKg = Double.parseDouble(scan.nextLine());
        double foodPerDayForCatKg = Double.parseDouble(scan.nextLine());
        double foodPerDayForfTurtleGr = Double.parseDouble(scan.nextLine());

        double neededFoodForDog = numberDays * foodPerDayForDogKg;
        double neededFoodForCat = numberDays * foodPerDayForCatKg;
        double neededFoodForTurtle = numberDays * foodPerDayForfTurtleGr;
        double neededFoodForTurtleKg = neededFoodForTurtle / 1000;
        double totalNeededFood = neededFoodForDog + neededFoodForCat + neededFoodForTurtleKg;

        if (totalNeededFood <= foodLeftPerKg){
            int neededFood = (int)Math.floor(foodLeftPerKg - totalNeededFood);

            System.out.println(neededFood + " kilos of food left.");
        }
        else {
            int neededFood = (int) Math.ceil(totalNeededFood - foodLeftPerKg);
            System.out.println(neededFood + " more kilos of food are needed.");
        }
    }
}
