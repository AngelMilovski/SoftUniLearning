import java.util.Scanner;

public class p27_Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double numberOfElderlyPeople = Double.parseDouble(scan.nextLine());
        double numberOfStudents = Double.parseDouble(scan.nextLine());
        double numberOfNights = Double.parseDouble(scan.nextLine());
        String transport = scan.nextLine();
        double elderPeople = 0.0;
        double students = 0.0;

        if (transport.equals("train")) {
            if (numberOfElderlyPeople + numberOfStudents >= 50) {
                elderPeople = 24.99 - (24.99 * 0.5);
                students = 14.99 - (14.99 * 0.5);
            } else {
                elderPeople = 24.99;
                students = 14.99;
            }
        } else if (transport.equals("bus")) {
            elderPeople = 32.50;
            students = 28.50;
        } else if (transport.equals("boat")) {
            elderPeople = 42.99;
            students = 39.99;
        } else if (transport.equals("airplane")) {
            elderPeople = 70.00;
            students = 50.00;
        }
        double costsTransport = ((numberOfElderlyPeople * elderPeople) + (numberOfStudents * students)) * 2;
        double hotel = numberOfNights * 82.99;
        double commission = (costsTransport + hotel) * 0.10;
        double totalSum = costsTransport + hotel + commission;
        System.out.printf("%.2f", totalSum);

    }
}
