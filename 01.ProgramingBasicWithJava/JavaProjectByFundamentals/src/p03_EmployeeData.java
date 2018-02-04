import java.text.DecimalFormat;
import java.util.Scanner;

public class p03_EmployeeData {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#0.00");
        String name = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        int employeeID = Integer.parseInt(scan.nextLine());
        double salary = Double.parseDouble(scan.nextLine());

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println(String.format("Employee ID: %08d", employeeID));
        System.out.println("Salary: " + df.format(salary));
    }
}
