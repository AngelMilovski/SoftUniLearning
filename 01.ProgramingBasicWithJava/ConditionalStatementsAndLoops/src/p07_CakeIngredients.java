import java.util.Scanner;

public class p07_CakeIngredients {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countIngredient = 0;

        for (int i = 1; i <= 20; i++) {
            String ingredient = scan.nextLine();
            if (ingredient.equals("Bake!")) {
                System.out.println(String.format("Preparing cake with %d ingredients.", countIngredient));
                return;
            }else {
                System.out.println(String.format("Adding ingredient %s.", ingredient));
                countIngredient++;
            }
        }
    }
}


