import java.util.Scanner;

public class p01_GrapeAndRakia {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double areaTheVineyard = Double.parseDouble(scan.nextLine());
        double kgPerSquareMeter = Double.parseDouble(scan.nextLine());
        double scrap = Double.parseDouble(scan.nextLine());

        double kgGrapes = areaTheVineyard * kgPerSquareMeter - scrap;
        double percentForRakia = (kgGrapes * 0.45);
        double litersRakia = percentForRakia / 7.5;
        double issueRakia = litersRakia * 9.80;
        System.out.printf("%.2f%n", issueRakia);
        double forSale = kgGrapes * 0.55;
        double issueGrapes = forSale * 1.5;
        System.out.printf("%.2f%n",issueGrapes);

    }
}
