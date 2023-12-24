/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryapp;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BookAuthor implements Serializable {
      private int id;
    private String name;
    private String address;
    private Date   birthDate;

    public BookAuthor(int id, String name, String address, Date birthDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
    public String getInfo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
        String formattedDate = dateFormat.format(birthDate);
        return  "BookAuthor" + "\nid: " + id + "\nname: " + name + "\naddress: " + address + "\nbirthDate: " + formattedDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
        String formattedDate = dateFormat.format(birthDate);
        return id + "," + name + "," + address +  "," + formattedDate;
    }
    
}
