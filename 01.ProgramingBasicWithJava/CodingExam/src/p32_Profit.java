import java.util.Scanner;

public class p32_Profit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double workingDayInMonth = Double.parseDouble(scan.nextLine());
        double moneyEarnedPerDay = Double.parseDouble(scan.nextLine());
        double rateDollarAgainstLev = Double.parseDouble(scan.nextLine());

        double monthSalary = workingDayInMonth * moneyEarnedPerDay;
        double yearsSalary = (monthSalary * 12) + (monthSalary * 2.5);
        double scot = yearsSalary - (yearsSalary * 0.25);
        double totalYearsSalary = scot * rateDollarAgainstLev;
        System.out.printf("%.2f", totalYearsSalary / 365);
    }
}
