import java.util.Scanner;

public class p04_Greeting {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String firstName = scan.nextLine();
        if (firstName.isEmpty()){
            firstName = "*****";
        }
        String lastName = scan.nextLine();
        if (lastName.isEmpty()){
            lastName = "*****";
        }
        System.out.println(String.format("Hello, %s %s!", firstName, lastName));
    }
}