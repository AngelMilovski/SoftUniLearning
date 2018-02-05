import java.util.Scanner;

public class p05_OddAndEvenPairs {

    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        if (input.length % 2 == 1){
            System.out.println("invalid length");
            return;
        }

        int[] numbers = new int[input.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        for (int i = 1; i < numbers.length; i += 2) {
            int prev = numbers[i - 1];
            int current = numbers[i];
            if (prev % 2 == 0 && current % 2 == 0){
                System.out.println(String.format("%d, %d -> both are even", prev, current));
            }else if (prev % 2 == 1 && current % 2 == 1){
                System.out.println(String.format("%d, %d -> both are odd", prev, current));
            }else{
                System.out.println(String.format("%d, %d -> different", prev, current));
            }
        }
    }
}