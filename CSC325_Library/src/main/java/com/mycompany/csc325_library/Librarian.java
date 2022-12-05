/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csc325_library;

/**
 *
 * @author kulsomzaraei
 */
public class Librarian extends Person {

    public int id;
    public int pinCode;

    /**
     * Librarian Constructor.
     * @param name
     * @param id
     * @param pin 
     */
    public Librarian(String name, int id, int pin) {
        super(name);
        // this.userCheckedOutBooks = null;
        this.id = id;
        this.pinCode = pin;

    } // End Librarian.

    public int getId() {
        return id;
    } // End getId.

    public void setId(int id) {
        this.id = id;
    } // End setId.

    public int getPinCode() {
        return pinCode;
    } // End getPinCode.

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    } // End setPinCode.
} // End Librarian.
