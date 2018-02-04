import java.util.Scanner;

public class p58_FootballLeague {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double stadiumCapacity = Integer.parseInt(scan.nextLine());
        double numberAllFans = Integer.parseInt(scan.nextLine());
        double A = 0.0;
        double B = 0.0;
        double V = 0.0;
        double G = 0.0;

        for (int i = 0; i < numberAllFans; i++) {
            String sector = scan.nextLine();

            if (sector.equals("A")) {
                A++;
            } else if (sector.equals("B")) {
                B++;
            } else if (sector.equals("V")) {
                V++;
            } else if (sector.equals("G")) {
                G++;
            }
        }
        double percentA = A / numberAllFans * 100;
        double percentB = B / numberAllFans * 100;
        double percentV = V / numberAllFans * 100;
        double percentG = G / numberAllFans * 100;
        double percentAllFans = numberAllFans / stadiumCapacity * 100;

        System.out.printf("%.2f%%%n", percentA);
        System.out.printf("%.2f%%%n", percentB);
        System.out.printf("%.2f%%%n", percentV);
        System.out.printf("%.2f%%%n", percentG);
        System.out.printf("%.2f%%%n", percentAllFans);
    }
}
