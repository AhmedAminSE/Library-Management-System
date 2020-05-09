package LMS;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Librarian implements Serializable {

    private String Username;
    private String Password;
    private String Name;
    private String Sec_Q;
    private String Ans;

    public Librarian() {
    }

    public Librarian(String Username, String Password, String Name, String Sec_Q, String Ans) {
        this.Username = Username;
        this.Password = Password;
        this.Name = Name;
        this.Sec_Q = Sec_Q;
        this.Ans = Ans;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSec_Q() {
        return Sec_Q;
    }

    public void setSec_Q(String Sec_Q) {
        this.Sec_Q = Sec_Q;
    }

    public String getAns() {
        return Ans;
    }

    public void setAns(String Ans) {
        this.Ans = Ans;
    }

    public int IsBookExisting(String title, String ISBN_Number, ArrayList<Book> Books) {
        for (int i = 0; i < Books.size(); i++) {
            if (Books.get(i).getTitle().toLowerCase().equals(title) && Books.get(i).getISBN_Number().equals(ISBN_Number)) {
                return 2;
            } else if (Books.get(i).getTitle().toLowerCase().equals(title)) {
                return 1;
            } else if (Books.get(i).getISBN_Number().equals(ISBN_Number)) {
                return 3;
            }
        }
        return 0;
    }

    public void AddBook(Book b, ArrayList<Book> Books) {
        switch (IsBookExisting(b.getTitle().toLowerCase(), b.getISBN_Number(), Books)) {
            case 2:
                JOptionPane.showMessageDialog(null, "A book with the same Title and ISBN Number is existing in the Library", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "A book with the same Title is existing in the Library", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "A book with the same ISBN Number is existing in the Library", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            default:
                Books.add(b);
                JOptionPane.showMessageDialog(null, "The Book is successfully added to the Library !", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public int SearchBook(String nameisbn) {
        for (int i = 0; i < Main.Books.size(); i++) {
            if (Main.Books.get(i).getTitle().toLowerCase().equals(nameisbn) || Main.Books.get(i).getISBN_Number().equals(nameisbn)) {
                return i;
            }
        }
        return -1;
    }

    public void DeleteBook(String nisbn) {
        int pos = SearchBook(nisbn);
        if (pos == -1) {
            JOptionPane.showMessageDialog(null, "Wrong Title/ISBN Number !", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Main.Books.remove(SearchBook(nisbn));
            JOptionPane.showMessageDialog(null, "The Book is successfully removed from the Library !", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public int SearchLibraryUser(int UserID) {
        for (int i = 0; i < Main.Users.size(); i++) {
            if (Main.Users.get(i).getID() == UserID) {
                return i;
            }
        }
        return -1;
    }

    public void DeleteUser(int ID) {
        int pos = SearchLibraryUser(ID);
        if (pos == -1) {
            JOptionPane.showMessageDialog(null, "Wrong User ID !", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (Main.Users.get(pos).BorrowedBooks.size() > 0) {
            JOptionPane.showMessageDialog(null, "This user must return all his/her borrowed books before deletion !", null, JOptionPane.ERROR_MESSAGE);
        } else {
            Main.Users.remove(pos);
            JOptionPane.showMessageDialog(null, "The User is successfully removed from the Library !", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
