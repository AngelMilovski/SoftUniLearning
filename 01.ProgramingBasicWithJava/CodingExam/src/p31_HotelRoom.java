import java.util.Scanner;

public class p31_HotelRoom {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String month = scan.nextLine();
        int numberOfNights = Integer.parseInt(scan.nextLine());
        double priceApartment = 0;
        double priceStudio = 0.0;

        if (month.equals("May") || month.equals("October")) {
            if (numberOfNights > 14) {
                priceApartment = 65 - (65 * 0.10);
                priceStudio = 50 - (50 * 0.30);
            } else if (numberOfNights > 7) {
                priceApartment = 65;
                priceStudio = 50 - (50 * 0.05);
            } else {
                priceApartment = 65;
                priceStudio = 50;
            }
        } else if (month.equals("June") || month.equals("September")) {
            if (numberOfNights > 14) {
                priceApartment = 68.70 - (68.70 * 0.10);
                priceStudio = 75.20 - (75.20 * 0.20);
            } else {
                priceApartment = 68.70;
                priceStudio = 75.20;
            }
        } else if (month.equals("July") || month.equals("August")){
            if (numberOfNights > 14){
                priceApartment = 77 - (77 * 0.10);
                priceStudio = 76;
            }else {
                priceApartment = 77;
                priceStudio = 76;
            }
        }
        System.out.printf("Apartment: %.2f lv.%n", priceApartment * numberOfNights);
        System.out.printf("Studio: %.2f lv.%n", priceStudio * numberOfNights);

    }

}

