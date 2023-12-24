/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Library {
   private static List<Book> books=new ArrayList<>();
    private static List<Student> students=new ArrayList<>();
    private static List<BookAuthor> authors=new ArrayList<>();
    private static List<Loan> loans=new ArrayList<>();



    
     private static Book addBook(Book book) {
        books.add(book);
        return book;
    }
     private static Magazen addMagazen(Magazen magazen) {
        books.add(magazen);
        return magazen;
    }
    private static Juranle addJuranle(Juranle juranle) {
        books.add(juranle);
        return juranle;
    }

    public static Book  addBook(String title, String genre, int version, String date ,int authorId, String authorName, String authorAddress, String birthDate ) throws ParseException {
       addAuthor(authorId,authorName,authorAddress,birthDate);
      return   addBook(new Book(title,authors.get(authors.size()-1),genre,version,new SimpleDateFormat("dd/MM/yyyy").parse(date)));
    }
   
     public static Magazen addMagazen (int issueNo, Date releaseDate, String title, BookAuthor author, String genre, int version, String date,int authorId, String authorName, String authorAddress, String birthDate ) throws ParseException {
       addAuthor(authorId,authorName,authorAddress,birthDate);
      return   addMagazen(new Magazen(issueNo,new SimpleDateFormat("DD/MM/YYYY").parse(date),title,authors.get(authors.size()-1),genre,version,new SimpleDateFormat("dd/mm/yyyy").parse(date)));
     }
     
     public static Juranle  addJuranle(int ConferenceNo, String ConferenceName, String title, BookAuthor author, String genre, int version, String date ,int authorId, String authorName, String authorAddress, String birthDate ) throws ParseException {
       addAuthor(authorId,authorName,authorAddress,birthDate);
      return   addJuranle(new Juranle(ConferenceNo,ConferenceName,title,authors.get(authors.size()-1),genre,version,(Date) new SimpleDateFormat("dd/MM/yyyy").parse(date)));
    }

    public static Book searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static List<Book> searchByAuthor(String authorName) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().getName().equalsIgnoreCase(authorName)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public static Book SearchBookByNo(int number){
        for (Book book : books)
            if (book.getNo()==number) return book;

        return null;
     }

    
    private static void addStudent(Student student) {
        students.add(student);
    }

    public static void  addStudent(int id, String name, String address, Date birthDate, String major){
      addStudent(new Student(id, name, address, birthDate, major));
    }

    public static Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
    
    private static void addAuthor(BookAuthor author) {
        authors.add(author);
    }

    public static void  addAuthor(int id, String name, String address, String birthDate) throws ParseException {
       addAuthor(new BookAuthor(id, name, address, new SimpleDateFormat("dd/MM/yyyy").parse(birthDate)));
    };


    public static boolean loanBook(int loannum,String student,String Book, String dueDate) throws ParseException {
        Student requiredStudent=new Student();
        Book book=searchByTitle(Book);
        Date dueDate1=new SimpleDateFormat("dd/MM/yyyy").parse(dueDate);

        for (Student stu: students)
            if (stu.getName().equalsIgnoreCase(student))  requiredStudent= stu ;

            return loanBook(requiredStudent,book,dueDate1);


    }

    
    
    private static boolean loanBook(Student student, Book book, Date dueDate) {
        if (student.getNumLoans() < 3 && !book.inLoan()) {
            Loan loan = new Loan(book, student, dueDate);
            loans.add(loan);
            book.setOnLoan(true);
            student.incrementNumLoans();
            return true;
        }
        return false;
    }

    static void getBooksOnLoan() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static void addStudent(int id, String studnetName, String address, String date, String major) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean returnBook(String bookName){
        Book book=searchByTitle(bookName);

        return returnBook(book);
    }


    private static boolean returnBook(Book book) {
        for (Loan loan : loans) {
            if (loan.getBook().equals(book)) {
                loans.remove(loan);
                book.setOnLoan(false);
                loan.getStudent().decrementNumLoans();
                return true;
            }
        }
        return false;
    }

    
    public static List<Loan> getOverdueLoans() {
        List<Loan> overdueLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.isOverdue()) {
                overdueLoans.add(loan);
            }
        }
        return overdueLoans;
    }

    private static Loan getBookLoan(String title){
        for (Loan loan: loans){
            if (loan.getBook().getTitle().equalsIgnoreCase(title)){
                return loan;
            }
        }
        return null;
    }

  public static void getBookStatus(String bookTitle){
        Book book=searchByTitle(bookTitle);
        Loan loan =getBookLoan(bookTitle);

        if (book.inLoan()) {
            System.out.println(
                    String.format("%s is on loan and it is over due %s",bookTitle,loan.getDueDate())
            );

        }
        else System.out.println(String.format("%s is not on loan ",bookTitle));

  }


    public static List<Book> getBooks() {
        return books;
    }

    public  static List<Student> getStudents() {
        return students;
    }

    public static List<Loan> getLoans() {
        return loans;
    }

    public static List<BookAuthor> getAuthors() {
        return authors;
    }
    
    public static BookAuthor  getAuthorByName(String nameToFind) {
        for (BookAuthor author : authors)
            if (author.getName().equalsIgnoreCase(nameToFind))
                return author; 
        return null; 
    }

    }

   
    



