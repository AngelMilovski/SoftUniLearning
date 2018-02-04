import java.util.Scanner;

public class p05_WorkHours {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int neededHours = Integer.parseInt(scan.nextLine());
        int numbersOfWorkers = Integer.parseInt(scan.nextLine());
        int workingDays = Integer.parseInt(scan.nextLine());

        int workingHours = numbersOfWorkers * (workingDays * 8);

        if (workingHours >= neededHours){
            System.out.println(workingHours - neededHours + " hours left");
        }
        else {
            int penalties = Math.abs(neededHours - workingHours) * workingDays;
            System.out.println(Math.abs(neededHours - workingHours) + " overtime");
            System.out.println("Penalties: " + penalties);
        }
    }
}
