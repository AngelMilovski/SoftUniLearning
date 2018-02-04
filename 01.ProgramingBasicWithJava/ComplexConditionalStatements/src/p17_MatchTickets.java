import java.util.Scanner;

public class p17_MatchTickets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        String type = scan.nextLine();
        int peopleInTheGroup = Integer.parseInt(scan.nextLine());

        double vipTicket = 499.99;
        double normalTicket = 249.99;
        double budgetForTransport = -1;
        double priceTickets = -1;
        double remainingMoney = -1;


        if (type.equals("Normal")) {
            priceTickets = (normalTicket * peopleInTheGroup);
            if (peopleInTheGroup >= 1 && peopleInTheGroup <= 4) {
                budgetForTransport = ((budget / 100) * 75);
                remainingMoney = Math.abs(budget - budgetForTransport);
            } else if (peopleInTheGroup >= 5 && peopleInTheGroup <= 9) {
                budgetForTransport = ((budget / 100) * 60);
                remainingMoney = Math.abs(budget - budgetForTransport);
            } else if (peopleInTheGroup >= 10 && peopleInTheGroup <= 24) {
                budgetForTransport = ((budget / 100) * 50);
                remainingMoney = Math.abs(budget - budgetForTransport);
            } else if (peopleInTheGroup >= 25 && peopleInTheGroup <= 49) {
                budgetForTransport = ((budget / 100) * 40);
                remainingMoney = Math.abs(budget - budgetForTransport);
            } else if (peopleInTheGroup >= 50) {
                budgetForTransport = ((budget / 100) * 25);
                remainingMoney = (budget - budgetForTransport);
            }

        } else if (type.equals("VIP")) {
            priceTickets = (vipTicket * peopleInTheGroup);
            if (peopleInTheGroup >= 1 && peopleInTheGroup <= 4) {
                budgetForTransport = ((budget / 100) * 75);
                remainingMoney = Math.abs(budget - budgetForTransport);
            } else if (peopleInTheGroup >= 5 && peopleInTheGroup <= 9) {
                budgetForTransport = ((budget / 100) * 60);
                remainingMoney = Math.abs(budget - budgetForTransport);
            } else if (peopleInTheGroup >= 10 && peopleInTheGroup <= 24) {
                budgetForTransport = ((budget / 100) * 50);
                remainingMoney = Math.abs(budget - budgetForTransport);
            } else if (peopleInTheGroup >= 25 && peopleInTheGroup <= 49) {
                budgetForTransport = ((budget / 100) * 40);
                remainingMoney = Math.abs(budget - budgetForTransport);
            } else if (peopleInTheGroup >= 50) {
                budgetForTransport = ((budget / 100) * 25);
                remainingMoney = Math.abs(budget - budgetForTransport);
            }

        }
        if (remainingMoney >= priceTickets) {
            System.out.printf("Yes! You have %.2f leva left.", Math.abs(remainingMoney - priceTickets));
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", Math.abs(remainingMoney - priceTickets));
        }

    }
}