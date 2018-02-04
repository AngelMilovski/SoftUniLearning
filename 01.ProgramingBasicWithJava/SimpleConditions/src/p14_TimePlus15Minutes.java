import java.util.Scanner;

public class p14_TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hour = Integer.parseInt(scan.nextLine());
        int min = Integer.parseInt(scan.nextLine());


        if (min >= 60) {
            min = min - 60;
            hour = hour + 1;

        }
        if (hour > 23) {
            hour -= 24;

        }
        if (min < 10) {
            System.out.println(hour + ":" + "0" + min);
        } else {
            System.out.printf(hour + ":" + min);

        }

    }
}
