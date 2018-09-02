package book_shop;

import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    private static final int VALID_NUMBER_OF_GOLDEN_BOOK_DECLARED_METHOD = 1;
    private static final String CODE_DUPLICATE_MESSAGE = "Code duplication in GoldenEditionBook!";
    public static void main(String[] args) throws IllegalClassFormatException {
        String debug = "";
        try {
            Scanner scan = new Scanner(System.in);
            String author = scan.nextLine();
            String title = scan.nextLine();
            double price = Double.parseDouble(scan.nextLine());
            scan.close();

            Book book = new Book(author, title, price);

            Book goldenEditionBook = new GoldenEditionBook(author, title, price);

            Method[] goldenBookDeclaredMethod = GoldenEditionBook.class.getDeclaredMethods();
            System.out.println(goldenBookDeclaredMethod.length);
            if (goldenBookDeclaredMethod.length > VALID_NUMBER_OF_GOLDEN_BOOK_DECLARED_METHOD) {
                throw new IllegalClassFormatException(CODE_DUPLICATE_MESSAGE);
            }

            System.out.println(book.toString());
            System.out.println(goldenEditionBook.toString());

        } catch (IllegalArgumentException | IllegalClassFormatException error) {
            System.out.println(error.getMessage());
        }
    }
}
