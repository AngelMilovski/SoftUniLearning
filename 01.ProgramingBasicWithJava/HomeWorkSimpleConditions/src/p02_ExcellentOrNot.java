import java.util.Scanner;

public class p02_ExcellentOrNot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
         double num = Double.parseDouble(scan.nextLine());

         if (num >= 5.50){
             System.out.println("Excellent!");
         }
         else {
             System.out.println("Not excellent.");
         }
    }
}
