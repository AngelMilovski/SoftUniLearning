import java.util.Scanner;

public class p11_EqualWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String first = scan.nextLine().toUpperCase();
        String second = scan.nextLine().toUpperCase();

        if (first.equals(second)){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }
}
