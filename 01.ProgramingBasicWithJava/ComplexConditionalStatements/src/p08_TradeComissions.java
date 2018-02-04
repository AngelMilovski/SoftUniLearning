import java.util.Scanner;

public class p08_TradeComissions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String town = scan.nextLine().toLowerCase();
        double sales = Double.parseDouble(scan.nextLine());
        double comition = -1;

        if (town.equals("sofia")) {
            if (sales >= 0 && sales <= 500) {
                comition = 0.05;
                System.out.printf("%.2f", sales * comition);
            } else if (sales > 500 && sales <= 1000) {
                comition = 0.07;
                System.out.printf("%.2f", sales * comition);
            } else if (sales > 1000 && sales <= 10000) {
                comition = 0.08;
                System.out.printf("%.2f", sales * comition);
            } else if (sales > 10000) {
                comition = 0.12;
                System.out.printf("%.2f", sales * comition);
            } else {
                System.out.println("error");
            }

        } else if (town.equals("varna")) {
            if (sales >= 0 && sales <= 500) {
                comition = 0.045;
                System.out.printf("%.2f", sales * comition);
            } else if (sales > 500 && sales <= 1000) {
                comition = 0.075;
                System.out.printf("%.2f", sales * comition);
            } else if (sales > 1000 && sales <= 10000) {
                comition = 0.10;
                System.out.printf("%.2f", sales * comition);
            } else if (sales > 10000) {
                comition = 0.13;
                System.out.printf("%.2f", sales * comition);
            } else {
                System.out.println("error");
            }

        } else if (town.equals("plovdiv")) {
            if (sales >= 0 && sales <= 500) {
                comition = 0.055;
                System.out.printf("%.2f", sales * comition);
            } else if (sales > 500 && sales <= 1000) {
                comition = 0.08;
                System.out.printf("%.2f", sales * comition);
            } else if (sales > 1000 && sales <= 10000) {
                comition = 0.12;
                System.out.printf("%.2f", sales * comition);
            } else if (sales > 10000) {
                comition = 0.145;
                System.out.printf("%.2f", sales * comition);
            } else {
                System.out.println("error");
            }
        }else {
            System.out.println("error");
        }

    }
}
