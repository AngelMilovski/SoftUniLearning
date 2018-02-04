import java.util.Scanner;

public class p08_MetricConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double size = Double.parseDouble(scan.nextLine());
        String metric1 = scan.nextLine();
        String metric2 = scan.nextLine();

        if (metric1.equals("km")){
            size = size / 0.001;
        }
        else if (metric1.equals("mm")){
            size = size / 1000;
        }
        else if (metric1.equals("cm")){
            size = size / 100;
        }
        else if (metric1.equals("mi")){
            size = size / 0.000621371192;
        }
        else if (metric1.equals("in")){
            size = size / 39.3700787;
        }
        else if (metric1.equals("ft")){
            size = size / 3.2808399;
        }
        else if (metric1.equals("yd")){
            size = size / 1.0936133;
        }

        if (metric2.equals("mm")){
            size = size * 1000;
        }
        else if (metric2.equals("cm")){
            size = size *100;
        }
        else if (metric2.equals("mi")){
            size = size * 0.000621371192;
        }
        else if (metric2.equals("in")){
            size = size * 39.3700787;
        }
        else if (metric2.equals("km")){
            size = size * 0.001;
        }
        else if (metric2.equals("ft")){
            size = size * 3.2808399;
        }
        else if (metric2.equals("yd")){
            size = size * 1.0936133;
        }
        System.out.printf("%f %s", size, metric2);


    }

}
