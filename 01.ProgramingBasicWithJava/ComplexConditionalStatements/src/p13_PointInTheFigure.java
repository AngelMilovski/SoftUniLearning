import java.util.Scanner;

public class p13_PointInTheFigure {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int h = Integer.parseInt(scan.nextLine());
        int x = Integer.parseInt(scan.nextLine());
        int y = Integer.parseInt(scan.nextLine());

        boolean isInside = ((x > 0 && x < h * 3) && y > 0 && y < h)
                || ((x > h && x < h * 3) && y > 0 && y < h * 4);

        boolean isOutside = ((x < 0 || x > h * 3) && y > h)
                || ((x > 0 || x < h * 2) && y > h)
                || ((y < 0) || y < h * 4);

        if (isInside) {
            System.out.println("inside");
        } else if (isOutside) {
            System.out.println("outside");
        } else {
            System.out.println("border");
        }
    }
}
