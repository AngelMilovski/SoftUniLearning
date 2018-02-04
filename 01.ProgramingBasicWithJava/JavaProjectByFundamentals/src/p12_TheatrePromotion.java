import java.util.Scanner;

public class p12_TheatrePromotion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String day = scan.nextLine().toLowerCase();
        int age = Integer.parseInt(scan.nextLine());
        int price = 0;

        if (day.equals("weekday")){
            if (age >= 0 && age <= 18 || age > 64 && age <= 122){
                price = 12;
            }
            else if (age > 18 && age <= 64) {
                price = 18;
            }
        }else if (day.equals("weekend")){
            if (age >= 0 && age <= 18 || age > 64 && age <= 122){
                price = 15;
            }
            else if (age > 18 && age <= 64){
                price = 20;
            }
        }else if (day.equals("holiday")){
            if  (age >= 0 && age <= 18){
                price = 5;
            }else if (age > 18 && age <= 64){
                price = 12;
            }else if (age > 64 && age <= 122){
                price = 10;
            }
        }
        if (price != 0){
            System.out.println(price + "$");
        }
        else {
            System.out.println("Error!");
        }
    }
}
