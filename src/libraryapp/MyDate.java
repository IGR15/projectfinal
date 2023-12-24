/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryapp;

import java.util.Date;

/**
 *
 * @author MSI
 */
public class MyDate extends Date{
    

    public MyDate(int year, int month, int date) {
        super(year, month, date);
    }

    
    @Override

   
    public String toString() {
        return super.getYear()+"/"+super.getMonth()+"/"+super.getDay();
    }
    
    
    
}
