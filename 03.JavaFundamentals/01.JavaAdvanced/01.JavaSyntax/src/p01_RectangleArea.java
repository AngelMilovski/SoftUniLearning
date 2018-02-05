import java.util.*;

public class p01_RectangleArea {

    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//
//        int sizeA = scan.nextInt();
//        int sizeB = scan.nextInt();
//        double rectangleArea = sizeA * sizeB;
//
//        System.out.println(String.format("%.2f", rectangleArea));
        HashMap<Integer, Double> test = new HashMap<>();
        test.put(2, 2.4);
        test.put(3, 3.4);
        test.put(4, 3.5);
        test.put(1, 34.3);
        for (Map.Entry<Integer, Double> sad:test.entrySet()) {
            System.out.println(sad.getKey());
        }

    }
}