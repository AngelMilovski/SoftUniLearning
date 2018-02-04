import java.util.Scanner;

public class p15_EqualNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int num3 = Integer.parseInt(scan.nextLine());

        if (num1 == num2 && num2 == num3){
            System.out.println("yes");

        }else{
            System.out.println("no");
        }


    }
}
