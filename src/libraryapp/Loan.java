/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryapp;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Loan {
    final int loannum;
    private Book book;
    private Student student;
    private Date dueDate;
    private static int count = 0;

    public Loan(Book book, Student student, Date dueDate) {
        this.loannum = count++;
        this.book = book;
        this.student = student;
        this.dueDate = dueDate;
    }
    
    public int getLoannum() {
        return loannum;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getInfo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
        String formattedDate = dateFormat.format(dueDate);
        return "loan number "+ loannum + "\nBook: " + book.getTitle() + "\nStudent: " + student.getName() + "\nID:"+student.getId()+ "\nDue Date: " + formattedDate;
    }
    
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
        String formattedDate = dateFormat.format(dueDate);
        
        return book.getNo() + "," + student.getId() + "," + formattedDate;
    }
    
    public boolean isOverdue() {
        Date currentDate = new Date();
        return currentDate.after(dueDate);
    }
}
