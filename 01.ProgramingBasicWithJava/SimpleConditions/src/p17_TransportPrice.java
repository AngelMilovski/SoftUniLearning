import java.util.Scanner;

public class p17_TransportPrice {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        String time = scan.nextLine();
        double price = 0.0;

        if(time.equals("day") && n <= 19){
            price = 0.70 + (n * 0.79);

        }
        else if (time.equals("night") && n <= 19){
            price = 0.70 +(n * 0.90);
        }
        else if (n >= 20 && n < 100){
            price = n * 0.09;
        }
        else if (n >= 100 && n <= 5000){
            price = n * 0.06;
        }
        System.out.printf("%.2f", price);

    }
}




