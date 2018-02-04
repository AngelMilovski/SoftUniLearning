import java.util.Scanner;

public class p06_WordInPlural {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();

        if (word.endsWith("y")) {
            word = word.substring(0, word.length() - 1);
            word += "ies";
        }else if (word.endsWith("o") ||
                  word.endsWith("ch")||
                  word.endsWith("s") ||
                  word.endsWith("sh")||
                  word.endsWith("x") ||
                  word.endsWith("z")){
            word += "es";
        }else {
            word += "s";
        }
        System.out.println(word);
    }
}
