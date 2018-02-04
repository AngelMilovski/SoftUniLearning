import java.util.Scanner;

public class p01_SquareArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("a = ");
        int a = Integer.parseInt(scan.nextLine());
        int area = a * a;
        System.out.println("Area = " + area);
    }
}
