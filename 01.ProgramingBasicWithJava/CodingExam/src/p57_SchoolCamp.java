import java.util.Scanner;

public class p57_SchoolCamp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        String groupType = scanner.nextLine();
        int studentsCount = Integer.parseInt(scanner.nextLine());
        int nightsCount = Integer.parseInt(scanner.nextLine());

        double priceForNigh = 0.0;

        if (season.equals("Winter")) {
            if (groupType.equals("girls") || groupType.equals("boys")) {
                priceForNigh = 9.60;
            } else {
                priceForNigh = 10;
            }
        } else if (season.equals("Spring")) {
            if (groupType.equals("girls") || groupType.equals("boys")) {
                priceForNigh = 7.20;
            } else {
                priceForNigh = 9.50;
            }
        } else if (season.equals("Summer")) {
            if (groupType.equals("girls") || groupType.equals("boys")) {
                priceForNigh = 15;
            } else {
                priceForNigh = 20;
            }
        }
        double totalPrice = priceForNigh * studentsCount * nightsCount;
        if (studentsCount >= 50) {
            totalPrice -= totalPrice * 0.50;
        } else if (studentsCount >= 20 && studentsCount < 50) {
            totalPrice -= totalPrice * 0.15;
        } else if (studentsCount >= 10 && studentsCount < 20){
            totalPrice -= totalPrice * 0.05;
        }
        String sport = "";
        if (season.equals("Winter")){
            if (groupType.equals("boys")){
                sport = "Judo";
            }else if (groupType.equals("girls")){
                sport = "Gymnastics";
            }else {
                sport = "Ski";
            }
        }else if (season.equals("Spring")){
            if (groupType.equals("boys")){
                sport = "Tennis";
            }else if (groupType.equals("girls")){
                sport = "Athletics";
            }else {
                sport = "Cycling";
            }
        }else {
            if (groupType.equals("girls")){
                sport = "Volleyball";
            }else if (groupType.equals("boys")){
                sport = "Football";
            }else {
                sport = "Swimming";
            }
        }
        System.out.printf("%s %.2f lv.", sport, totalPrice);
    }
}