import java.util.Scanner;

public class p03_Hotel {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String month = scan.nextLine();
        int numberSpendingTheNights = Integer.parseInt(scan.nextLine());
        double studioForNight = 0.0;
        double doubleRoomForNight = 0.0;
        double suiteForNight = 0.0;
        double priceStudioForStay = 0.0;
        double priceDoubleRoomForStay = 0.0;
        double priceSuiteForStay = 0.0;

        if (numberSpendingTheNights > 14) {
            if (month.equals("June")) {
                priceStudioForStay = 60.0 * numberSpendingTheNights;
                doubleRoomForNight = 72.0 - (72.0 * 0.10);
                priceDoubleRoomForStay = doubleRoomForNight * numberSpendingTheNights;
                priceSuiteForStay = 82.0 * numberSpendingTheNights;
            } else if (month.equals("July") || month.equals("August") || month.equals("December")) {
                priceStudioForStay = 68.0 * numberSpendingTheNights;
                priceDoubleRoomForStay = 77.0 * numberSpendingTheNights;
                suiteForNight = 89.0 - (89.0 * 0.15);
                priceSuiteForStay = suiteForNight * numberSpendingTheNights;
            } else if (month.equals("September")) {
                studioForNight = 60.0;
                priceStudioForStay = (studioForNight * numberSpendingTheNights) - 60.0;
                doubleRoomForNight = 72.0 - (72.0 * 0.10);
                priceDoubleRoomForStay = doubleRoomForNight * numberSpendingTheNights;
                priceSuiteForStay = 82.0 * numberSpendingTheNights;
            } else if (month.equals("October")) {
                studioForNight = 50.0 - (50.0 * 0.05);
                priceStudioForStay = (studioForNight * numberSpendingTheNights) - studioForNight ;
                priceDoubleRoomForStay = 65.0 * numberSpendingTheNights;
                priceSuiteForStay = 75.0 * numberSpendingTheNights;
            }
        } else if (numberSpendingTheNights > 7) {
            if (month.equals("May")) {
                studioForNight = 50.0 - (50.0 * 0.05);
                priceStudioForStay = studioForNight * numberSpendingTheNights;
                priceDoubleRoomForStay = 65.0 * numberSpendingTheNights;
                priceSuiteForStay = 75.0 * numberSpendingTheNights;
            } else if (month.equals("October")){
                studioForNight = 50.0 - (50.0 * 0.05);
                priceStudioForStay = (studioForNight * numberSpendingTheNights) - studioForNight;
                priceDoubleRoomForStay = 65.0 * numberSpendingTheNights;
                priceSuiteForStay = 75.0 * numberSpendingTheNights;
            }else if (month.equals("September")){
                priceStudioForStay = (60.0 * numberSpendingTheNights) - 60.0;
                priceDoubleRoomForStay = 72.0 * numberSpendingTheNights;
                priceSuiteForStay = 82.0 * numberSpendingTheNights;
            }
        }else {
            if (month.equals("May") || month.equals("October")){
                priceStudioForStay = 50.0 * numberSpendingTheNights;
                priceDoubleRoomForStay = 65.0 * numberSpendingTheNights;
                priceSuiteForStay = 75.0 * numberSpendingTheNights;
            }else if (month.equals("June") || month.equals("September")){
                priceStudioForStay = 60.0 * numberSpendingTheNights;
                priceDoubleRoomForStay = 72.0 * numberSpendingTheNights;
                priceSuiteForStay = 82.0 * numberSpendingTheNights;
            }else if (month.equals("July") || month.equals("August") || month.equals("December")){
                priceStudioForStay = 68.0 * numberSpendingTheNights;
                priceDoubleRoomForStay = 77.0 * numberSpendingTheNights;
                priceSuiteForStay = 89.0 * numberSpendingTheNights;
            }
        }
        System.out.println(String.format("Studio: %.2f lv.", priceStudioForStay));
        System.out.println(String.format("Double: %.2f lv.", priceDoubleRoomForStay));
        System.out.println(String.format("Suite: %.2f lv.", priceSuiteForStay));
    }
}

