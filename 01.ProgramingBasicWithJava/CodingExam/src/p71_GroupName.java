import java.util.Scanner;

public class p71_GroupName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char firstLatter = scan.nextLine().charAt(0);
        char secondLatter = scan.nextLine().charAt(0);
        char thirdLetter = scan.nextLine().charAt(0);
        char fourthLetter = scan.nextLine().charAt(0);
        int number = Integer.parseInt(scan.nextLine());
        int combination = 0;

        for (char i = 'A'; i <= firstLatter; i++) {
            for (char j = 'a'; j <= secondLatter; j++) {
                for (char k = 'a'; k <= thirdLetter; k++) {
                    for (char l = 'a'; l <= fourthLetter; l++) {
                        for (int m = 0; m <= number; m++) {
                            combination++;
                            if (i == firstLatter && j == secondLatter && k == thirdLetter &&
                                    l == fourthLetter && m == number -1){
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(combination);
    }
}

