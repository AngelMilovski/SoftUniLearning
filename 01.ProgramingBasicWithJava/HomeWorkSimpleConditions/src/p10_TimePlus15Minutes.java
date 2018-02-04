import java.util.Scanner;

public class p10_TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hour = Integer.parseInt(scan.nextLine());
        int min = Integer.parseInt(scan.nextLine());
        min = min + 15;

        if (min > 59) {
            min -=  60;
            hour += 1;
            
        }
        if (hour > 23) {
            hour -= 24;

        }
        if (min < 10) {
            System.out.println(hour + ":" + "0" + min);
        } else {
            System.out.println(hour + ":" + min);
        }
    }
}
