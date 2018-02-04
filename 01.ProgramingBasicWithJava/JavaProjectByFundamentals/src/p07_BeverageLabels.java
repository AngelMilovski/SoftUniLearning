import java.text.DecimalFormat;
        import java.util.Scanner;

public class p07_BeverageLabels {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");
        String name = scan.nextLine();
        double volume = Double.parseDouble(scan.nextLine());
        double energyContent = Double.parseDouble(scan.nextLine());
        double sugarContent = Double.parseDouble(scan.nextLine());

        double energyTotal = energyContent * volume * 1 / 100;
        double sugarTotal = sugarContent * volume * 1 / 100;

        System.out.printf("%.0fml %s:%n", volume, name);
        System.out.printf("%skcal, %sg sugars",df.format(energyTotal), df.format(sugarTotal));

    }
}
