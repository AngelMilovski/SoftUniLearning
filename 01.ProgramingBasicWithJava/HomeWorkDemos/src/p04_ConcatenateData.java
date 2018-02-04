import java.util.Scanner;

public class p04_ConcatenateData {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String firstName = scan.nextLine();

        String secondName = scan.nextLine();

        int age = Integer.parseInt(scan.nextLine());
        String town = scan.nextLine();


        System.out.printf("You are %s %s, a %d-years old person from %s. ", firstName, secondName, age, town);
    }
}
