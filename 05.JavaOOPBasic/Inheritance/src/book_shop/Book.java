package book_shop;

public class Book {

    private static final String PATTERN = "\\d";
    private static final int VALID_TITLE_LENGTH = 3;
    private static final double VALID_PRICE = 0.0D;
    private static final String INVALID_AUTHOR_MESSAGE = "Author not valid!";
    private final String INVALID_TITLE_MESSAGE = "Title not valid!";
    private static final String INVALID_PRICE_MESSAGE = "Price not valid!";
    private static final String NEW_LINE = System.lineSeparator();

    private String authorName;
    private String title;
    private double price;


    public Book(String authorName, String title, double price) {
        this.setAuthorName(authorName);
        this.setTitle(title);
        this.setPrice(price);
    }

    private String getAuthorName() {
        return this.authorName;
    }

    private void setAuthorName(String authorName) {
        String[] authorTokens = authorName.split("\\s+");
        String lastName = "";
        if (authorTokens.length == 2) {
            lastName = authorTokens[1];
        }
        if (authorTokens.length == 2 && Character.isDigit(lastName.charAt(0))) {
            throw new IllegalArgumentException(INVALID_AUTHOR_MESSAGE);
        }
        this.authorName = authorName;
    }

    private String getTitle() {
        return this.title;
    }

    private void setTitle(String title) {
        if (title.length() < VALID_TITLE_LENGTH) {
            throw new IllegalArgumentException(INVALID_TITLE_MESSAGE);
        }
        this.title = title;
    }

    protected double getPrice() {
        return this.price;
    }

    private void setPrice(double price) {
        if (price <= VALID_PRICE) {
            throw new IllegalArgumentException(INVALID_PRICE_MESSAGE);
        }
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ")
                .append(this.getClass().getSimpleName())
                .append(NEW_LINE)
                .append("Title: ")
                .append(this.getTitle())
                .append(NEW_LINE)
                .append("Author: ")
                .append(this.getAuthorName())
                .append(NEW_LINE)
                .append("Price: ")
                .append(this.getPrice())
                .append(NEW_LINE);
        return sb.toString();
    }
}
