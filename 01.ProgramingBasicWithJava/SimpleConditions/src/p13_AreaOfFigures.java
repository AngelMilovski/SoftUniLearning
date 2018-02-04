import java.util.Scanner;

public class p13_AreaOfFigures {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String figures = scan.nextLine();


        if (figures.equals("square")) {
            double a = Double.parseDouble(scan.nextLine());
            double areaSquare = a * a;
            System.out.printf("%.3f", areaSquare);
        } else if (figures.equals("rectangle")) {
            double a = Double.parseDouble(scan.nextLine());
            double b = Double.parseDouble(scan.nextLine());
            double areaRectangle = a * b;
            System.out.printf("%.3f", areaRectangle);
        } else if (figures.equals("circle")) {
            double r = Double.parseDouble(scan.nextLine());
            double areaCircle = Math.PI * r * r;
            System.out.printf("%.3f", areaCircle);
        } else if (figures.equals("triangle")) {
            double a = Double.parseDouble(scan.nextLine());
            double h = Double.parseDouble(scan.nextLine());
            double areaTriangle = (a * h) / 2;
            System.out.printf("%.3f", areaTriangle);
        }


    }
}
