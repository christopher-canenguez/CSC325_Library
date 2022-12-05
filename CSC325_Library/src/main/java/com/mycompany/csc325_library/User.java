/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csc325_library;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class User extends Person {
    // private Book[] userCheckedOutBooks = new Book[4];

    public int id;
    public int pinCode;
    //public String pin;

    public User(String name, int id, int pin) {
        super(name);
        // this.userCheckedOutBooks = null;
        this.id = id;
        this.pinCode = pin;

    } // End User.

    public int getPinCode() {
        return pinCode;
    } // End getPinCode.

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    } // End setPinCode.

    public int getId() {
        return id;
    } // End getId.

    public void setId(int id) {
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
    public String toString() {
        String myUser;
        myUser = "Name: " + this.getName() + "ID:" + id;
        return myUser;
    } // End toString.

    /**
     * search - will search through array of Users if User with id exists.
     *
     * @param userList
     * @param accountNum
     * @return
     */
    public static User search(User[] userList, int accountNum) {
        for (int i = 0; i < userList.length; i++) {
            if (userList[i].getId() == accountNum) {
                return userList[i];
            } // End if.
        } // End for.
        return null;
    } // End search.
    
    public static User search(ArrayList<User> userList, int accountNum)
    {
        for (int i = 0; i < userList.size(); i++)
        {
            if (userList.get(i).getId() == accountNum)
            {
                return userList.get(i);
            } // End if.
        } // End for.
        return null;
    } // End search.
} // End User.
