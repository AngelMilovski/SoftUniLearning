import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p01_CalculateTriangleAreaMethod {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String[] input = reader.readLine().split(" ");
        double area = getTheTriangleArea(input);
        System.out.println(String.format("Area = %.2f", area));
    }

    private static double getTheTriangleArea(String[] input) {
        double base = Double.parseDouble(input[0]);
        double height = Double.parseDouble(input[1]);
        double area = (base * height) / 2;
        return area;
    }
}
