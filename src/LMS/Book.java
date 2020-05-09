package LMS;

import java.io.Serializable;
import java.util.ArrayList;

public class Book implements Serializable {

    private String title;
    private String Author;
    private String ISBN_Number;
    protected int Quantity;
    protected int AvailableBooks;

    public Book(String title, String Author, String ISBN_Number, int Quantity) {
        this.title = title;
        this.Author = Author;
        this.ISBN_Number = ISBN_Number;
        this.Quantity = Quantity;
        AvailableBooks = Quantity - 1;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getISBN_Number() {
        return ISBN_Number;
    }

    public void setISBN_Number(String ISBN_Number) {
        this.ISBN_Number = ISBN_Number;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public int getAvailableBooks() {
        return AvailableBooks;
    }

    public void setAvailableBooks(int AvailableBooks) {
        this.AvailableBooks = AvailableBooks;
    }
}
