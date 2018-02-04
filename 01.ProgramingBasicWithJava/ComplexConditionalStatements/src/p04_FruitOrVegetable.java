import java.util.Scanner;

public class p04_FruitOrVegetable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String fruitOrVegetable = scan.nextLine();


        if (fruitOrVegetable.equals("banana") || fruitOrVegetable.equals("apple") || fruitOrVegetable.equals("kiwi") ||
                fruitOrVegetable.equals("cherry") || fruitOrVegetable.equals("lemon") || fruitOrVegetable.equals("grapes")) {
            System.out.println("fruit");
        } else if (fruitOrVegetable.equals("tomato") || fruitOrVegetable.equals("cucumber") || fruitOrVegetable.equals("pepper") ||
                fruitOrVegetable.equals("carrot")) {
            System.out.println("vegetable");
        } else {
            System.out.println("unknown");
        }
    }
}
