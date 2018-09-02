import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        List<Book> books = new ArrayList<>() {{
            add(bookOne);
            add(bookTwo);
            add(bookThree);
        }};


//        for (Book book : books) {
//            System.out.println(book.getTitle());
//        }

//        if (bookOne.compareTo(bookTwo) > 0) {
//            System.out.println(String.format("%s is before %n%s", bookOne, bookTwo));
//        } else if (bookOne.compareTo(bookTwo) < 0) {
//            System.out.println(String.format("%s is before %n%s", bookTwo, bookOne));
//        } else {
//            System.out.println("Book are equal");
//        }
//        books.sort((a, b) -> a.getTitle().compareTo(b.getTitle()));

        books.sort(new BookComparator());

        for (Book book : books) {
            System.out.println(book.getTitle() + book.getYear());
        }
    }
}