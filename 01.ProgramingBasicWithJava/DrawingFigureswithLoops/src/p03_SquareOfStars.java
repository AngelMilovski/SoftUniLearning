
import java.util.Scanner;

public class p03_SquareOfStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++){
            System.out.println(repeatStr("* ", n));
        }
    }
    public static String repeatStr(String str, int count){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++){
            sb.append(str);
        }
        return sb.toString();
    }
}
