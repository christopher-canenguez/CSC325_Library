package com.mycompany.csc325_library;

//testing

import com.mycompany.csc325_library.Book;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kulsomzaraei
 */
public class Library {
   
    
    public void Library(){
       
        //authors
       Person author1 = new Person("S.E", "Hinton");
       Person author2 = new Person("J.K", "Rowling");
       

      //users list 
       User[] userList = new User[4];
       User user1 = new User("Sam", "Hindy", 12);
       user1 = userList[0];
       User user2 = userList[1];
       User user3 = userList[2];
       User user4 = userList[3];
       User user5 = userList[4];
 
       //books list
       Book[] bookList = new Book[10];
       Book book1 = new Book("The Outsiders", author1, 123455, "Not Available", user1);
       Book book2 = new Book("The Sorcerers Stone", author2, 434566, "Not Available", user2);
       book1 = bookList[0];
       book2 = bookList[1];
       Book book3 = bookList[2];
       Book book4 = bookList[3];
       Book book5 = bookList[4];
       Book book6 = bookList[5];
       Book book7 = bookList[6];
       Book book8 = bookList[7];
       Book book9 = bookList[8];
       Book book10 = bookList[9];
       
       

       
       
       
       
       
       
       
         
        
        
    }
    
}
