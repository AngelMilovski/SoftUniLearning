package book_shop;

public class GoldenEditionBook extends Book {

    public GoldenEditionBook(String authorName, String title, double price) {
        super(authorName, title, price);
    }

    @Override
    protected double getPrice() {
        return super.getPrice() + (super.getPrice() * 30 / 100);
    }
}
