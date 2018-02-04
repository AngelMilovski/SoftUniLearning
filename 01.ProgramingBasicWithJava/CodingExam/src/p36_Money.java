import java.util.Scanner;

public class p36_Money {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double numberBitkoini = Double.parseDouble(scan.nextLine());
        double numberChineseUana = Double.parseDouble(scan.nextLine());
        double commission = Double.parseDouble(scan.nextLine());

        double fromBitkoiniToLv = numberBitkoini * 1168;
        double fromUanaToDollar = numberChineseUana * 0.15;
        double fromDollarToLv = fromUanaToDollar * 1.76;
        double fromLvToEuro = (fromBitkoiniToLv + fromDollarToLv) / 1.95;

        double percentFromCommission = (commission / 100) * fromLvToEuro;
        double result = fromLvToEuro - percentFromCommission;
        System.out.printf("%.2f", result);
    }
}
