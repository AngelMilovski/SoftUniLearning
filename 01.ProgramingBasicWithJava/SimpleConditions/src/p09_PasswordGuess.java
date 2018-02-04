import java.util.Scanner;

public class p09_PasswordGuess {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String password = scan.nextLine();

        //s3cr3t!P@ssw0rd

        if(password.equals("s3cr3t!P@ssw0rd")){
            System.out.println("Welcome");
        }
        else {
            System.out.println("Wrong password!");
        }
    }
}
