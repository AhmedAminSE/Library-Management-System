package LMS;

public class Professor extends LibraryUser {

    public Professor(int ID, String Fname, String Lname, String Gender, String Email, String Address, String PhoneNumber) {
        super(ID, Fname, Lname, "Professor", Gender, Email, Address, PhoneNumber);
    }

    @Override
    public boolean CheckMaxBorrow() {
        return BorrowedBooks.size() == 5;
    }

    @Override
    public String getFaculty() {
        return "";
    }

    @Override
    public void setFaculty(String Faculty) {
    }

    @Override
    public String getYear() {
        return "";
    }

    @Override
    public void setYear(String Year) {
    }
}
