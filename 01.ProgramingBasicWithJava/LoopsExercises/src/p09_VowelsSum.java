import java.util.Scanner;

public class p09_VowelsSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        int sum = 0;

        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            switch (currentSymbol){
                case'a':
                    sum++;
                    break;
                case'e':
                    sum += 2;
                    break;
                case'i':
                    sum += 3;
                    break;
                case'o':
                    sum += 4;
                    break;
                case'u':
                    sum += 5;
                    break;
            }
        }
        System.out.println(sum);
    }
}
