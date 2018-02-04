import java.util.Scanner;

public class p16_IntervalsDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        if ((number > 0) && (number <= 100)){
            System.out.println("The number is in interval (0, 100]");
        }
        else if ((number > 100) && (number <= 500)){
            System.out.println("The number is in interval (100, 500]");
        }
        else if (number > 500){
            System.out.println("The number is in interval (500, +Infinity]");
        }

    }
}
