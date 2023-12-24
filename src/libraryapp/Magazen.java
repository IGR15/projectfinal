/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryapp;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Magazen extends Book{
     private int issueNo;
    private Date releaseDate;

    public Magazen(String title, BookAuthor author, String genre, int version, Date date) {
        super(title, author, genre, version, date);
    }

    
    

    public Magazen(int issueNo, Date releaseDate, String title, BookAuthor author, String genre, int version, Date date) {
        super(title, author, genre, version, date);
        this.issueNo = issueNo;
        this.releaseDate = releaseDate;
    }

    

    public int getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(int issueNo) {
        this.issueNo = issueNo;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    
    public String getInfo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
        String formattedDate = dateFormat.format(releaseDate);
        return "Magazine" + "\nissueNo: " + issueNo + "\nreleaseDate: " + formattedDate;
    }
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
        String formattedDate = dateFormat.format(releaseDate);
        return  issueNo + "," + formattedDate + "," + super.toString() + "," + "65";
    }
    
    
}
