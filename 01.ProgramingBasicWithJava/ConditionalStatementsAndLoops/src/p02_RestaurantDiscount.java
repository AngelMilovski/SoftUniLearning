import java.util.Scanner;

public class p02_RestaurantDiscount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countOfPeople = Integer.parseInt(scan.nextLine());
        String servicePackage = scan.nextLine();
        String typeHall = "";
        double priceForGroup = 0.0;
        double pricePackage = 0.0;
        double totalPrice = 0.0;
        double priceWithDiscount = 0.0;

        if (countOfPeople <= 50) {
            typeHall = "Small Hall";
            priceForGroup = 2500.0;
            switch (servicePackage){
                case "Normal":
                    pricePackage = 500.0;
                    totalPrice = priceForGroup + pricePackage;
                    priceWithDiscount = totalPrice - (totalPrice * 0.05);
                    break;
                case "Gold":
                    pricePackage = 750.0;
                    totalPrice = priceForGroup + pricePackage;
                    priceWithDiscount = totalPrice - (totalPrice * 0.10);
                    break;
                case"Platinum":
                    pricePackage = 1000.0;
                    totalPrice = priceForGroup + pricePackage;
                    priceWithDiscount = totalPrice - (totalPrice * 0.15);
                    break;
            }
        }else if (countOfPeople > 50 && countOfPeople <= 100){
            typeHall = "Terrace";
            priceForGroup = 5000.0;
            switch (servicePackage){
                case "Normal":
                    pricePackage = 500.0;
                    totalPrice = priceForGroup + pricePackage;
                    priceWithDiscount = totalPrice - (totalPrice * 0.05);
                    break;
                case "Gold":
                    pricePackage = 750.0;
                    totalPrice = priceForGroup + pricePackage;
                    priceWithDiscount = totalPrice - (totalPrice * 0.10);
                    break;
                case"Platinum":
                    pricePackage = 1000.0;
                    totalPrice = priceForGroup + pricePackage;
                    priceWithDiscount = totalPrice - (totalPrice * 0.15);
                    break;
            }
        }else if (countOfPeople > 100 && countOfPeople <= 120){
            typeHall = "Great Hall";
            priceForGroup = 7500.0;
            switch (servicePackage){
                case "Normal":
                    pricePackage = 500.0;
                    totalPrice = priceForGroup + pricePackage;
                    priceWithDiscount = totalPrice - (totalPrice * 0.05);
                    break;
                case "Gold":
                    pricePackage = 750.0;
                    totalPrice = priceForGroup + pricePackage;
                    priceWithDiscount = totalPrice - (totalPrice * 0.10);
                    break;
                case"Platinum":
                    pricePackage = 1000.0;
                    totalPrice = priceForGroup + pricePackage;
                    priceWithDiscount = totalPrice - (totalPrice * 0.15);
                    break;
            }
        }
        if (countOfPeople > 120){
            System.out.println("We do not have an appropriate hall.");
        }else {
            System.out.println(String.format("We can offer you the %s%n" +
                    "The price per person is %.2f$", typeHall, priceWithDiscount / countOfPeople));
        }
    }
}

