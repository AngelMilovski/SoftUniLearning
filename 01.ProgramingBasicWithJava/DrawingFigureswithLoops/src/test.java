import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String mykey = "*";
        int n = Integer.parseInt(sc.nextLine());

        for(int i = n-1; i>0; i--){
            System.out.print(printer(" ",i));
            System.out.print(printer("* ", n-i));
            System.out.println();
        }

        for(int i = 0; i<n; i++){
            System.out.print(printer(" ",i));
            System.out.print(printer("* ", n-i));
            System.out.println();
        }

        printer(mykey,n);
    }

    private static String printer(String mykey, int n) {

        String result = "";

        for(int i =0; i<n; i++){
            result+=mykey;
        }

        return result;

    }
}