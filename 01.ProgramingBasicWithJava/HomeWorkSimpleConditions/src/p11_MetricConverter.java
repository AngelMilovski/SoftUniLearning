import java.util.HashMap;
        import java.util.Scanner;

public class p11_MetricConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double input = Double.parseDouble(scan.nextLine());
        String from = scan.nextLine();
        String to = scan.nextLine();

        HashMap <String, Double> countOfMetric = new HashMap<String, Double>();
        countOfMetric.put("mm", 1000.0);
        countOfMetric.put("cm", 100.0);
        countOfMetric.put("mi", 0.000621371192);
        countOfMetric.put("in", 39.3700787);
        countOfMetric.put("km", 0.001);
        countOfMetric.put("ft", 3.2808399);
        countOfMetric.put("yd", 1.0936133);
        countOfMetric.put("m", 1.0);
        double result =  input / countOfMetric.get(from) * countOfMetric.get(to);

        System.out.printf("%f %s",result, to);
    }
}
