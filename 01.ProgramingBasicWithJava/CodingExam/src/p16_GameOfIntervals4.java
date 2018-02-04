import java.util.Scanner;

public class p16_GameOfIntervals4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        double result = 0.0;
        double from1To9 = 0.0;
        double from10To19 = 0.0;
        double from20To29 = 0.0;
        double from30To39 = 0.0;
        double from40To50 = 0.0;
        double invalidNumbers = 0.0;


        for (int i = 0; i < n; i++) {
            int numbers = Integer.parseInt(scan.nextLine());
            if (numbers >= 0 && numbers <=9){
                from1To9++;
                result += numbers * 0.2;
            }else if (numbers > 9 && numbers <= 19){
                from10To19++;
                result += numbers * 0.3;
            }else if (numbers > 19 && numbers <= 29){
                from20To29++;
                result += numbers * 0.4;
            }else if (numbers > 29 && numbers <= 39){
                from30To39++;
                result += 50;
            }else if (numbers > 39 && numbers <= 50){
                from40To50++;
                result += 100;
            }else if (numbers < 0 || numbers > 50){
                invalidNumbers++;
                result /= 2;
            }

        }
        double percentFrom0To9 = from1To9 / n * 100;
        double percentFrom10To19 = from10To19 / n * 100;
        double percentFrom20To29 = from20To29 / n * 100;
        double percentFrom30To39 = from30To39 / n * 100;
        double percentFrom40To50 = from40To50 / n * 100;
        double percentInvalidNumber = invalidNumbers / n * 100;
        System.out.printf("%.2f%n", result);
        System.out.printf("From 0 to 9: %.2f%%%n", percentFrom0To9);
        System.out.printf("From 10 to 19: %.2f%%%n", percentFrom10To19);
        System.out.printf("From 20 to 29: %.2f%%%n",percentFrom20To29);
        System.out.printf("From 30 to 39: %.2f%%%n", percentFrom30To39);
        System.out.printf("From 40 to 50: %.2f%%%n", percentFrom40To50);
        System.out.printf("Invalid numbers: %.2f%%%n", percentInvalidNumber);
    }
}
