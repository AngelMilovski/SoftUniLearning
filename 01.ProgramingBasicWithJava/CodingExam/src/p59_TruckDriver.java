import java.util.Scanner;

public class p59_TruckDriver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String season = scan.nextLine();
        double kmPerMonth = Double.parseDouble(scan.nextLine());
        double issue = 0.0;


        if (season.equals("Spring") || season.equals("Autumn")) {
            if (kmPerMonth <= 5000) {
                issue = 0.75;
            } else if (kmPerMonth > 5000 && kmPerMonth <= 10000) {
                issue = 0.95;
            } else if (kmPerMonth > 10000 && kmPerMonth <= 20000) {
                issue = 1.45;
            }
        } else if (season.equals("Summer")) {
            if (kmPerMonth <= 5000) {
                issue = 0.90;
            } else if (kmPerMonth > 5000 && kmPerMonth <= 10000) {
                issue = 1.10;
            } else if (kmPerMonth > 10000 && kmPerMonth <= 20000) {
                issue = 1.45;
            }
        } else if (season.equals("Winter")) {
            if (kmPerMonth <= 5000) {
                issue = 1.05;
            } else if (kmPerMonth > 5000 && kmPerMonth <= 10000) {
                issue = 1.25;
            } else if (kmPerMonth > 10000 && kmPerMonth <= 20000) {
                issue = 1.45;
            }
        }
        double salary = kmPerMonth * issue;
        double salaryWithoutTenPercent = salary  - (salary * 0.10);

        System.out.printf("%.2f%n", salaryWithoutTenPercent * 4);
    }
}
