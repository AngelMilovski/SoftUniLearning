import java.util.Scanner;

public class CrismasHead {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        String dot = doMagic(".", n * 2 - 1);

        System.out.println(dot + "/|\\" + dot);
        System.out.println(dot + "\\|/" + dot);
        System.out.println(dot + "***" + dot);

        for (int i = 0; i < n * 2 - 1; i++)

        {
            System.out.print(doMagic(".",n*2-2-i));
            System.out.print("*");
            System.out.print(doMagic("-", i+1));
            System.out.print("*");
            System.out.print(doMagic("-", i+1));
            System.out.print("*");
            System.out.print(doMagic(".",n*2-2-i));
            System.out.println();
        }

        System.out.println(doMagic("*", n * 4 + 1));
        System.out.print("*");
        System.out.println(doMagic(".*", n * 2 ));
        System.out.println(doMagic("*", n * 4 + 1));
    }

    public static String doMagic(String text, int repeatCount) {
        String output = "";
        for (int i = 0; i < repeatCount; i++) {
            output = output + text;
        }
        return output;
    }
}

