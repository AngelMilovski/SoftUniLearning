import java.util.HashMap;
import java.util.Scanner;

public class p16_CurrencyConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double input = Double.parseDouble(scan.nextLine());
        String from = scan.nextLine();
        String to = scan.nextLine();

        HashMap<String, Double> countOfCurrency = new HashMap();
        countOfCurrency.put("BGN", 1.0);
        countOfCurrency.put("USD", 1.79549);
        countOfCurrency.put("EUR", 1.95583);
        countOfCurrency.put("GBP", 2.53405);

        System.out.printf("%.2f %s", input * countOfCurrency.get(from) / countOfCurrency.get(to), to);
    }
}
