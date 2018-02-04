import java.util.Scanner;

public class p44_Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();
        double coasts = 0.0;

        if (budget <= 1000) {
            if (season.equals("Summer")) {
                coasts = budget * 0.65;
                System.out.printf("Alaska - Camp - %.2f%n", coasts);
            }else if (season.equals("Winter")){
                coasts = budget * 0.45;
                System.out.printf("Morocco - Camp - %.2f%n", coasts);
            }
        }else if (budget > 1000 && budget <= 3000){
                if (season.equals("Summer")){
                    coasts = budget * 0.80;
                    System.out.printf("Alaska - Hut - %.2f%n", coasts);
                }else if (season.equals("Winter")){
                    coasts = budget * 0.60;
                    System.out.printf("Morocco - Hut - %.2f%n", coasts);
                }
        }else {
            if (season.equals("Summer")){
                coasts = budget * 0.90;
                System.out.printf("Alaska - Hotel - %.2f%n", coasts);
            }else if (season.equals("Winter")){
                coasts = budget * 0.90;
                System.out.printf("Morocco - Hotel - %.2f%n", coasts);
            }
        }
    }
}
