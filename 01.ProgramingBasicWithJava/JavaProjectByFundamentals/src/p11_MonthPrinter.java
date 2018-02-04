import java.util.Scanner;

public class p11_MonthPrinter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        String[] months = {"", "January", "February", "March", "April", "May", "June",
                            "July", "August", "September", "October", "November", "December"};

        String result = "";
        if (number < 1 || number > 12){
            System.out.println("Error!");
        }
        else {
            result = months[number];
        }
        System.out.println(result);
    }
}
