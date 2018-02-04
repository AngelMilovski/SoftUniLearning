import java.util.Scanner;

public class p05_InvalidNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());


        boolean inRange =(number >= 100 && number <= 200) || number == 0;

        if (! inRange){
            System.out.println("invalid");
        }
        }

        }


