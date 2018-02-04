import java.util.Scanner;

public class DoWhileFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        long factorial = 1;
        do{
            factorial *= n;
            n--;
        }while (n > 1);

        System.out.println(factorial);
    }

}
