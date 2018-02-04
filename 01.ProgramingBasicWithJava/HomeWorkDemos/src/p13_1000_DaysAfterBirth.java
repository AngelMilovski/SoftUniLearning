import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class p13_1000_DaysAfterBirth {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String text = scan.nextLine();

        LocalDate parsedDate = LocalDate.parse(text, formatter);

        LocalDate after1k = parsedDate.plusDays(999);

        System.out.printf("%1$td-%1$tm-%1$tY", after1k);

    }
}

