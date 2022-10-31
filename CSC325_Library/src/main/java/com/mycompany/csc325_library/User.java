/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csc325_library;

/**
 *
 * @author user
 */
public class User extends Person 
{
    // private Book[] userCheckedOutBooks = new Book[4];

    public int id;
    //public String pin;

    public User(String name, int id) 
    {
        super(name);
        // this.userCheckedOutBooks = null;
        this.id = 0;
    } // End User.

    public int getId()
    {
        return id;
    } // End getId.

    public void setId(int id) 
    {
        this.id = id;
    } // End setId.

    //public void setName(String name) 
    //{
    //    this.name = name;
    //} // End setName.

    //public Book[] getUserCheckedOutBooks() {
    //      return userCheckedOutBooks;
    //  }
    //   public void setUserCheckedOutBooks(Book[] userCheckedOutBooks) {
    //       this.userCheckedOutBooks = userCheckedOutBooks;
    //  }
    @Override
    public String toString() 
    {
        String myUser;
        myUser = "Name: " + this.getName() + "ID:" + id;
        return myUser;
    } // End toString.
} // End User.
