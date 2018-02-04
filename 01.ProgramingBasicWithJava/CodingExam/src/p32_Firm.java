import java.util.Scanner;

public class p32_Firm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double neededHours = Double.parseDouble(scan.nextLine());
        double availableDays = Double.parseDouble(scan.nextLine());
        double numberWorkerOutsideWorkingHours = Double.parseDouble(scan.nextLine());

        double workingDays = availableDays - (availableDays * 0.10);
        double workingHours = workingDays * 8;
        double overtime = numberWorkerOutsideWorkingHours * (2 * availableDays);
        double totalWorkingHours = Math.floor(workingHours + overtime);

       if (totalWorkingHours >= neededHours){
           System.out.printf("Yes!%.0f hours left.", totalWorkingHours - neededHours);
       }else {
           System.out.printf("Not enough time!%.0f hours needed.", neededHours - totalWorkingHours);
       }

    }
}
