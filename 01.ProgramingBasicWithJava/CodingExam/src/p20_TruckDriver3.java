import java.util.Scanner;

public class p20_TruckDriver3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String season = scan.nextLine();
        double kms = Double.parseDouble(scan.nextLine());
        double sumPerKm = 0.0;

        if (season.equals("Spring") || season.equals("Autumn")){
            if (kms <= 5000){
                sumPerKm = 0.75;
            }else if (kms <= 10000){
                sumPerKm = 0.95;
            }else if (kms <= 20000){
                sumPerKm = 1.45;
            }

        }else if (season.equals("Summer")){
            if (kms <= 5000){
                sumPerKm = 0.90;
            }else if (kms <= 10000){
                sumPerKm = 1.10;
            }else if (kms <= 20000){
                sumPerKm = 1.45;
            }

        }else if (season.equals("Winter")){
            if (kms <= 5000){
                sumPerKm = 1.05;
            }else if (kms <= 10000){
                sumPerKm = 1.25;
            }else if (kms <= 20000){
                sumPerKm = 1.45;
            }

        }
        double money = kms * sumPerKm;
        double percent = money * 0.10;
        double salary = money - percent;
        System.out.printf("%.2f", salary * 4);
    }
}
