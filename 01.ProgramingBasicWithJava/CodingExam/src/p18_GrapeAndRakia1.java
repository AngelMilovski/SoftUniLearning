import java.util.Scanner;

public class p18_GrapeAndRakia1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double areaGrapes = Double.parseDouble(scan.nextLine());
        double kgPerMeters = Double.parseDouble(scan.nextLine());
        double warm = Double.parseDouble(scan.nextLine());

        double totalKgGrapes = areaGrapes * kgPerMeters - warm;
        double percentForRakia = totalKgGrapes * 0.45;
        double forRakia = percentForRakia / 7.5;
        double income = forRakia * 9.80;

        System.out.printf("%.2f%n", income);
        double percentGrapes =  totalKgGrapes * 0.55;

        System.out.printf("%.2f%n", percentGrapes * 1.50);
    }
}
