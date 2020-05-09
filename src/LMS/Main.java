package LMS;

import java.io.*;
import java.util.ArrayList;
import javax.swing.UIManager;

public class Main {

    static public ArrayList<Librarian> Employees = new ArrayList<Librarian>();
    static public ArrayList<Book> Books = new ArrayList<Book>();
    static public ArrayList<LibraryUser> Users = new ArrayList<LibraryUser>();

    static void ReadData() throws Exception {
        FileInputStream fis = new FileInputStream("LibraryUsers.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Users = (ArrayList<LibraryUser>) ois.readObject();
        ois.close();
        fis.close();
        FileInputStream fis2 = new FileInputStream("Librarians.txt");
        ObjectInputStream ois2 = new ObjectInputStream(fis2);
        Employees = (ArrayList<Librarian>) ois2.readObject();
        ois2.close();
        fis2.close();
        FileInputStream fis3 = new FileInputStream("Books.txt");
        ObjectInputStream ois3 = new ObjectInputStream(fis3);
        Books = (ArrayList<Book>) ois3.readObject();
        ois3.close();
        fis3.close();
    }

    static void WriteData() throws Exception {
        FileOutputStream fos = new FileOutputStream("LibraryUsers.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Users);
        oos.close();
        fos.close();
        FileOutputStream fos2 = new FileOutputStream("Librarians.txt");
        ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
        oos2.writeObject(Employees);
        oos2.close();
        fos2.close();
        FileOutputStream fos3 = new FileOutputStream("Books.txt");
        ObjectOutputStream oos3 = new ObjectOutputStream(fos3);
        oos3.writeObject(Books);
        oos3.close();
        fos3.close();
    }

    public boolean IsUsernameExisting(String Username) {
        for (int i = 0; i < Employees.size(); i++) {
            if (Employees.get(i).getUsername().equals(Username)) {
                return true;
            }
        }
        return false;
    }

    public int SearchUsername(String Username) {
        for (int i = 0; i < Employees.size(); i++) {
            if (Employees.get(i).getUsername().equals(Username)) {
                return i;
            }
        }
        return -1;
    }

    public boolean IsAnswerValid(String ans, String Username) {
        for (int i = 0; i < Employees.size(); i++) {
            if (Employees.get(i).getUsername().equals(Username) && Employees.get(i).getAns().equals(ans)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        try {
            ReadData();
        } catch (Exception e) {
            WriteData();
        }
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                /*if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;*/
                UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibrarianLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        LibrarianLogin L = new LibrarianLogin();
        L.setVisible(true);
    }

}
