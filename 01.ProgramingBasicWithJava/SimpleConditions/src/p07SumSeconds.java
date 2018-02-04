import java.util.Scanner;

public class p07SumSeconds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = Integer.parseInt(scan.nextLine());
        int second = Integer.parseInt(scan.nextLine());
        int third = Integer.parseInt(scan.nextLine());

        int summed = first + second + third;
        int min = 0;
        int seconds = 0;

        if (summed <= 59) {
            seconds = summed;
        } else if (summed > 59 && summed <= 119) {
            min = summed / 60;
            seconds = summed % 60;
        } else if (summed > 119 && summed <= 179) {
            min = summed / 60;
            seconds = summed % 60;
        }
        if (seconds < 10) {
            System.out.println(min + ":" + "0" + seconds);
        } else {
            System.out.printf("%s:%s", min, seconds);
        }


    }
}
