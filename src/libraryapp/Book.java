/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryapp;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Book implements Display , Serializable {

    private String title;
    private BookAuthor author;
    private int no;
    private String genre;
    private int version;
    private Date date;
    private boolean onLoan;
    private static int count = 0;
    

    
    public Book(String title, BookAuthor author, String genre, int version, Date date) {
        this.title = title;
        this.author = author;
        this.no = count++;
        this.genre = genre;
        this.version = version;
        this.date = date; 
        this.onLoan = false;
    } 
    public Book(String line) {
        
        String[] data = line.split(",");
 
        this.title = data[0];
        
        BookAuthor bookAuthor = new BookAuthor(
                Integer.parseInt(data[1]),
                data[2],
                data[3],
                new Date(data[4])
        );
        
        this.author = bookAuthor;
        this.no = count++;
        this.genre = data[6];
        this.version = Integer.parseInt(data[7]);
        this.date = new Date(data[8]);
        this.onLoan = false;
        
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BookAuthor getAuthor() {
        return author;
    }

    public void setAuthor(BookAuthor author) {
        this.author = author;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isOnLoan() {
        return onLoan;
    }

    public void setOnLoan(boolean onLoan) {
        this.onLoan = onLoan;
    }
  
    @Override
    public boolean inLoan() {
       return onLoan;
    }
    
    @Override
    public String getinfo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
        String formattedDate = dateFormat.format(date);
        return "Book\ntitle: " + title + "\nauthor:  {\n" + author.getInfo() + "\n}\nno: " + no + "\ngenre: " + genre + "\nversion: " + version + "\ndate: " + formattedDate + "\n";
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
        String formattedDate = dateFormat.format(date);
        return title + "," + author.toString() + "," + no + "," + genre + "," + version + "," + formattedDate;
    }
  
}
    
    
