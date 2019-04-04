import java.util.Scanner;

public class p02_EncryptSortAndPrintArray {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] names = new String[n];
        int[] sum = new int[n];
        for (int i = 0; i < names.length; i++) {
            names[i] = scan.nextLine();
            char[] letter = names[i].toCharArray();
            for (char c : letter) {
                boolean isVowel = isVowelOrNot(c);
                if (isVowel) {
                    sum[i] += c * letter.length;
                } else {
                    sum[i] += c / letter.length;
                }
            }
        }
        boolean isSwapped = false;
        do {
            isSwapped = false;
            for (int i = 0; i < sum.length - 1; i++) {
                int current = sum[i];
                int next = sum[i + 1];

                if (current > next) {
                    isSwapped = true;
                    sum[i] = next;
                    sum[i + 1] = current;
                }
            }
        } while (isSwapped);

        for (int number : sum) {
            System.out.println(number);
        }
    }

    private static boolean isVowelOrNot(char c) {
        byte i = 0;
        switch (c) {
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                i++;
                break;
        }
        if (i == 1) {
            return true;
        }
        return false;
    }
}
