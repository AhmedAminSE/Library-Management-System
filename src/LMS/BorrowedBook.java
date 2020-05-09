package LMS;

public class BorrowedBook extends Book {

    public BorrowedBook(String title, String author, String ISBN_Number) {
        super(title, author, ISBN_Number, 1);
    }
}
