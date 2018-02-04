import java.util.Scanner;

public class p13_BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hour = Integer.parseInt(scan.nextLine());
        int minute = Integer.parseInt(scan.nextLine());
        int hours = hour;
        int minutes = minute + 30;

        if (minutes >= 60){
            hours++;

            if (hours >= 24){
                hours = 0;
            }
            minutes = minutes % 60;
        }

        System.out.println(String.format("%d:%02d", hours, minutes));
    }
}
