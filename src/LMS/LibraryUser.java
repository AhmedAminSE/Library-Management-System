package LMS;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public abstract class LibraryUser implements Serializable {

    private int ID;
    private String Fname;
    private String Lname;
    private String Role;
    private String Gender;
    private String Email;
    private String Address;
    private String PhoneNumber;
    protected ArrayList<BorrowedBook> BorrowedBooks = new ArrayList<>();

    public LibraryUser() {
    }

    public LibraryUser(int ID, String Fname, String Lname, String Role, String Gender, String Email, String Address, String PhoneNumber) {
        this.ID = ID;
        this.Fname = Fname;
        this.Lname = Lname;
        this.Role = Role;
        this.Gender = Gender;
        this.Email = Email;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    abstract public String getFaculty();

    abstract public void setFaculty(String Faculty);

    abstract public String getYear();

    abstract public void setYear(String Year);

    public boolean IsBorrowed(String ni) {
        for (int i = 0; i < BorrowedBooks.size(); i++) {
            if (BorrowedBooks.get(i).getISBN_Number().equals(ni) || BorrowedBooks.get(i).getTitle().toLowerCase().equals(ni)) {
                return true;
            }
        }
        return false;
    }

    abstract public boolean CheckMaxBorrow();

    public void BorrowBook(String nameisbn, ArrayList<Book> books) {
        if (CheckMaxBorrow()) {
            JOptionPane.showMessageDialog(null, "You reached your maximum limit of borrowed books !", "Warning", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (IsBorrowed(nameisbn)) {
            JOptionPane.showMessageDialog(null, "This user already borrowed a copy of this book ! , You can't borrow 2 copies of the same book at the same time !", "Warning", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            for (int i = 0; i < books.size(); i++) {
                if ((books.get(i).getTitle().toLowerCase().equals(nameisbn) || books.get(i).getISBN_Number().equals(nameisbn))
                        && books.get(i).getAvailableBooks() > 0) {
                    books.get(i).AvailableBooks--;
                    BorrowedBooks.add(new BorrowedBook(books.get(i).getTitle(), books.get(i).getAuthor(), books.get(i).getISBN_Number()));
                    JOptionPane.showMessageDialog(null, "You successfully borrowed the book " + nameisbn + " !", "Success", JOptionPane.INFORMATION_MESSAGE);
                    return;
                } else if ((books.get(i).getTitle().toLowerCase().equals(nameisbn) || books.get(i).getISBN_Number().equals(nameisbn))
                        && books.get(i).getAvailableBooks() == 0) {
                    JOptionPane.showMessageDialog(null, "All the copies of " + nameisbn + " are borrowed now !", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "The book " + nameisbn + " is not existing in the library !", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    public void ReturnBook(String nameisbn) {
        if (!IsBorrowed(nameisbn)) {
            JOptionPane.showMessageDialog(null, "The user didn't borrow this book to return ! ", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            for (int i = 0; i < Main.Books.size(); i++) {
                if (Main.Books.get(i).getTitle().toLowerCase().equals(nameisbn) || Main.Books.get(i).getISBN_Number().equals(nameisbn)) {
                    Main.Books.get(i).AvailableBooks++;
                    JOptionPane.showMessageDialog(null, "The book is successfully returned !", "Success", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
            for (int i = 0; i < BorrowedBooks.size(); i++) {
                if (BorrowedBooks.get(i).getTitle().toLowerCase().equals(nameisbn) || BorrowedBooks.get(i).getISBN_Number().equals(nameisbn)) {
                    BorrowedBooks.remove(i);
                    break;
                }
            }
        }
    }
}
