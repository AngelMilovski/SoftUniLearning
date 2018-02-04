import java.util.Scanner;

public class p38_MatchTickets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String type = scan.nextLine();
        double numberPeopleInGroup = Double.parseDouble(scan.nextLine());
        double percentOfBudget = 0.0;
        double priceTickets = 0.0;

        if (type.equals("Normal")) {
            if (numberPeopleInGroup >= 1 && numberPeopleInGroup <= 4) {
                percentOfBudget = budget - (budget * 0.75);
                priceTickets = numberPeopleInGroup * 249.99;
            } else if (numberPeopleInGroup > 4 && numberPeopleInGroup <= 9) {
                percentOfBudget = budget - (budget * 0.60);
                priceTickets = numberPeopleInGroup * 249.99;
            } else if (numberPeopleInGroup > 9 && numberPeopleInGroup <= 24) {
                percentOfBudget = budget - (budget * 0.50);
                priceTickets = numberPeopleInGroup * 249.99;
            } else if (numberPeopleInGroup > 24 && numberPeopleInGroup <= 49) {
                percentOfBudget = budget - (budget * 0.40);
                priceTickets = numberPeopleInGroup * 249.99;
            } else {
                percentOfBudget = budget - (budget * 0.25);
                priceTickets = numberPeopleInGroup * 249.99;
            }
        } else if (type.equals("VIP")) {
            if (numberPeopleInGroup >= 1 && numberPeopleInGroup <= 4) {
                percentOfBudget = budget - (budget * 0.75);
                priceTickets = numberPeopleInGroup * 499.99;
            } else if (numberPeopleInGroup > 4 && numberPeopleInGroup <= 9) {
                percentOfBudget = budget - (budget * 0.60);
                priceTickets = numberPeopleInGroup * 499.99;
            } else if (numberPeopleInGroup > 9 && numberPeopleInGroup <= 24) {
                percentOfBudget = budget - (budget * 0.50);
                priceTickets = numberPeopleInGroup * 499.99;
            } else if (numberPeopleInGroup > 24 && numberPeopleInGroup <= 49) {
                percentOfBudget = budget - (budget * 0.40);
                priceTickets = numberPeopleInGroup * 499.99;
            } else {
                percentOfBudget = budget - (budget * 0.25);
                priceTickets = numberPeopleInGroup * 499.99;
            }
        }
        if (priceTickets <= percentOfBudget) {
            System.out.printf("Yes! You have %.2f leva left.", percentOfBudget - priceTickets);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", priceTickets - percentOfBudget);
        }
    }
}