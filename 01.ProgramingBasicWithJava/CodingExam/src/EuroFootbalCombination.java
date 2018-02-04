import java.util.Scanner;

public class EuroFootbalCombination {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int combinations = 0;

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3 ; j++) {
                for (int k = 1; k <= 3 ; k++) {
                    for (int l = 1; l <= 3 ; l++) {
                        for (int m = 1; m <= 3 ; m++) {
                            for (int n = 1; n <= 3 ; n++) {
                                for (int o = 1; o <= 3 ; o++) {
                                    for (int p = 1; p <= 3 ; p++) {
                                        for (int q = 1; q <= 3 ; q++) {
                                            for (int r = 1; r <= 3 ; r++) {
                                                for (int s = 1; s <= 3 ; s++) {
                                                    for (int t = 1; t <= 3 ; t++) {
                                                        combinations++;

                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(combinations);
    }
}
