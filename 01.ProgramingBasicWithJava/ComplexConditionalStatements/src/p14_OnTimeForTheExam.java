import java.util.Scanner;

public class p14_OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hourOfExam = Integer.parseInt(scan.nextLine());
        int minuteOfExam = Integer.parseInt(scan.nextLine());
        int hourOfArrival = Integer.parseInt(scan.nextLine());
        int minuteOfArrival = Integer.parseInt(scan.nextLine());

        int examTime = hourOfExam * 60 + minuteOfExam;
        int comeTime = hourOfArrival * 60 + minuteOfArrival;
        int difference = Math.abs((examTime) - (comeTime));

        if (examTime < comeTime) {
            System.out.println("Late");
            if (difference < 60) {
                System.out.printf("%d minutes after the start", difference);
            } else {
                int hours = difference / 60;
                int min = difference % 60;
                System.out.printf("%d:%02d hours after the start", hours, min);
            }
        } else if (difference == 0 || difference <= 30){
            System.out.println("On time");
            if (difference != 0 ){
                System.out.printf("%d minutes before the start", difference);
            }
        }else {
            System.out.println("Early");
            if (difference < 60){
                System.out.printf("%d minutes before the start", difference);
            }else {
                int hour = difference / 60;
                int min = difference % 60;
                System.out.printf("%d:%02d hours before the start", hour, min);
            }
        }
    }
}


