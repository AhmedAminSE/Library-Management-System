package LMS;

public class Student extends LibraryUser {

    private String Faculty;
    private String Year;

    public Student(String Faculty, String Year, int ID, String Fname, String Lname, String Gender, String Email, String Address, String PhoneNumber) {
        super(ID, Fname, Lname, "Student", Gender, Email, Address, PhoneNumber);
        this.Faculty = Faculty;
        this.Year = Year;
    }

    @Override
    public String getFaculty() {
        return Faculty;
    }

    @Override
    public void setFaculty(String Faculty) {
        this.Faculty = Faculty;
    }

    @Override
    public String getYear() {
        return Year;
    }

    @Override
    public void setYear(String Year) {
        this.Year = Year;
    }

    @Override
    public boolean CheckMaxBorrow() {
        return BorrowedBooks.size() == 3;
    }
}
