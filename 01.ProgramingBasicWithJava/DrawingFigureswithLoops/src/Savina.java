import java.util.Scanner;

public class Savina {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        System.out.println("@" + metod(" ", (2 * n - 1 - 3) / 2) + "@"
                + metod(" ", (2 * n - 1 - 3) / 2) + "@");
        System.out.println("**" + metod(" ", (2 * n - 1 - 4) / 2) + "*" + metod(" ", (2 * n - 1 - 4) / 2) + "**");

        for (int i = 0, j = n - 5; i < n / 2 - 1; i++, j -= 2) {

            if(i==n/2-2){
                if(n%2==0){
                    System.out.println("*" + metod(".", i + 1) + "*" + metod(" ", j)
                            + metod(".", i) + "." + metod(".", i) + "*" + metod(" ", j)
                            + metod(".", i + 1) + "*");
                }
                else{
                    System.out.println("*" + metod(".", i + 1) + "*" + metod(" ", j)
                            + metod(".", i+1) + "." + metod(".", i+1)  + metod(" ", j)
                            + "*" + metod(".", i + 1) + "*");
                }
            }else{

                System.out.println("*" + metod(".", i + 1) + "*" + metod(" ", j)
                        + "*" + metod(".", i) + "." + metod(".", i) + "*" + metod(" ", j)
                        + "*" + metod(".", i + 1) + "*");

            }
        }
        if(n%2==0){
            System.out.println("*" + metod(".", n / 2) + metod("*", n / 2-2) + "." + metod("*", n / 2-2) + metod(".", n / 2) + "*");
        }else{
            System.out.println("*" + metod(".", n / 2) + metod("*", n / 2-1) + "." + metod("*", n / 2-1) + metod(".", n / 2) + "*");
        }
        System.out.println(metod("*", n * 2 - 1));
        System.out.println(metod("*", n * 2 - 1));

    }

    public static String metod(String n, int k) {
        String result = "";
        for (int i = 0; i < k; i++) {
            result += n;
        }
        return result;
    }
}


