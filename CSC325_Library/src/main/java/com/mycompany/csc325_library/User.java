/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csc325_library;

/**
 *
 * @author user
 */
public abstract class User extends Person {
    private Book[] userCheckedOutBooks = new Book[4];
    private String id;
    
    public User(String fName, String lName) {
    super(fName, lName);
    this.userCheckedOutBooks = null;
    this.id = "0";
    }
    
      public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public Book[] getUserCheckedOutBooks() {
        return userCheckedOutBooks;
    }

    public void setUserCheckedOutBooks(Book[] userCheckedOutBooks) {
        this.userCheckedOutBooks = userCheckedOutBooks;
    }
   
    
}
