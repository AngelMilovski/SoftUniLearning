import java.util.Scanner;

public class p64_CarToGo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();
        String whatClass = "";
        String typeCar = "";
        double costs = 0.0;

        if (budget <= 100){
            whatClass = "Economy class";
            if (season.equals("Summer")){
                typeCar = "Cabrio";
                costs = budget * 0.35;
            }else {
                typeCar = "Jeep";
                costs = budget * 0.65;
            }
        }else if (budget > 100 && budget <= 500){
            whatClass = "Compact class";
            if (season.equals("Summer")){
                typeCar = "Cabrio";
                costs = budget * 0.45;
            }else {
                typeCar = "Jeep";
                costs = budget * 0.80;
            }
        }else {
            whatClass = "Luxury class";
            typeCar = "Jeep";
            costs = budget * 0.90;
        }
        System.out.println(whatClass);
        System.out.printf("%s - %.2f", typeCar, costs);
    }
}
