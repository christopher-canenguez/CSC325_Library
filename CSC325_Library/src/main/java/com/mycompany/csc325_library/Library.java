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

    public void Library() 
    {

        //authorss
        Person author1 = new Person("S.E Hinton");
        Person author2 = new Person("J.K Rowling");
        Person author3 = new Person("William Shakespear");
        Person author4 = new Person("Herman Melville");
        Person author5 = new Person("Miguel de Cervantes");
        Person author6 = new Person("Harper Lee");

        // users list and populating array
        User[] userList = new User[4];
        User user1 = new User("Sam Hindy", 231);
        user1 = userList[0];
        User user2 = new User("Kelly Lane", 222);
        user2 = userList[1];
        User user3 = new User("Christopher Canenguez", 333);
        user3 = userList[2];
        User user4 = new User("Shameed Jobb", 444);
        user4 = userList[3];

        User user5 = new User("Kulsom Zaraei", 555);
        user5 = userList[4];

        //books list
        Book[] bookList = new Book[10];
        Book book1 = new Book("The Outsiders", author1, 123455, "Not Available");
        book1 = bookList[0];
        Book book2 = new Book("Harry Potter and The Sorcerers Stone", author2, 434566, "Not Available");
        book2 = bookList[1];
        Book book3 = new Book("Hamlet", author3, 76859, "Available");
        book3 = bookList[2];
        Book book4 = new Book("Romeo and Juliet", author3, 78899, "Available");
        book4 = bookList[3];
        Book book5 = new Book("Redburn", author4, 75648, "Available");
        book5 = bookList[4];
        Book book6 = new Book("Billy Budd", author4, 654322, "available");
        book6 = bookList[5];
        Book book7 = new Book("Harry Potter and  the Chamber of Secrets", author2, 423432, "available");
        book7 = bookList[6];
        Book book8 = new Book("Harry Potter and  the Prisioner of Askaban", author2, 42322, "available");
        book8 = bookList[7];
        Book book9 = new Book("Don Quixote", author5, 123229, "Available");
        book9 = bookList[8];
        Book book10 = new Book("To Kill a Mocking Bird", author6, 432543, "Available");
        book10 = bookList[9];

    } // End Library.
} // End Library.
