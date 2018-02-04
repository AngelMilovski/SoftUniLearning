import java.text.DecimalFormat;
import java.util.Scanner;

public class p06_CarToGo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");
        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();
        double coasts = 0.0;

        if (budget > 500){
            coasts = budget * 90 / 100;
            System.out.println("Luxury class");
            System.out.printf("Jeep - %.2f%n", coasts);
        }else if (budget > 100 && budget <= 500){
            if (season.equals("Summer")){
                coasts = budget * 45 / 100;
                System.out.println("Compact class");
                System.out.printf("Cabrio - %.2f", coasts);
            }else if (season.equals("Winter")){
                coasts = budget * 80 / 100;
                System.out.println("Compact class");
                System.out.printf("Jeep - %.2f", coasts);
            }
        }else if (budget <= 100){
            if (season.equals("Summer")){
                coasts = budget * 35 / 100;
                System.out.println("Economy class");
                System.out.printf("Cabrio - %.2f", coasts);
            }else if (season.equals("Winter")){
                coasts = budget * 65 / 100;
                System.out.println("Economy class");
                System.out.printf("Jeep - %.2f", coasts);
            }
        }
    }
}
