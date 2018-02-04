import java.text.DecimalFormat;
import java.util.Scanner;

public class p01_ChooseADrink {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String starTest = scan.nextLine();
        System.out.println("Using String:" + starTest);
        int newTest = Integer.parseInt(starTest);
        System.out.println("Actual String:"+ starTest);
        System.out.println("Converted to Int:" + newTest / 2);
    }
}
