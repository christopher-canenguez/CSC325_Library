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

    public String id;
    public int pinCode;

    public Librarian(String name, String id, int pin) {
        super(name);
        // this.userCheckedOutBooks = null;
        this.id = id;
        this.pinCode = pin;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
}
