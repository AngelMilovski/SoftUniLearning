import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int result = 0;



        if (num % 2 == 0){
            result = num + 7;
        }if (num % 5 == 0){
            result= num + 10;
        }
        System.out.println(result);
    }
}

