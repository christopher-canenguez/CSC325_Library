package com.mycompany.csc325_library;

//testing
import com.mycompany.csc325_library.Book;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author kulsomzaraei
 */
public class Library {

    private ArrayList<Book> bookList;

    public Library() {

        //authorss
        Person author1 = new Person("S.E Hinton");
        Person author2 = new Person("J.K Rowling");
        Person author3 = new Person("William Shakespear");
        Person author4 = new Person("Herman Melville");
        Person author5 = new Person("Miguel de Cervantes");
        Person author6 = new Person("Harper Lee");

        //users list and populating array
        User[] userList = new User[4];
        User user1 = new User("Sam Hindy", 231, 231);
        user1 = userList[0];
        User user2 = new User("Kelly Lane", 222, 222);
        user2 = userList[1];
        User user3 = new User("Christopher Canenguez", 333, 333);
        user3 = userList[2];
        User user4 = new User("Shameed Jobb", 444, 444);
        user4 = userList[3];

        User user5 = new User("Kulsom Zaraei", 555, 555);
        user5 = userList[4];
  

        Book book1 = new Book("The Outsiders", author1, user4, 123455, "Not Available");
        bookList.add(book1);
        Book book2 = new Book("Harry Potter and The Sorcerers Stone", author2, user1 ,434566, "Not Available");
        bookList.add(book2);
        Book book3 = new Book("Hamlet", author3, null, 76859, "Available");
        bookList.add(book3);
        Book book4 = new Book("Romeo and Juliet", author3, null, 78899, "Available");
        bookList.add(book4);
        Book book5 = new Book("Redburn", author4, null,75648, "Available");
        bookList.add(book5);
        Book book6 = new Book("Billy Budd", author4, user5, 654322, "available");
        bookList.add(book6);
        Book book7 = new Book("Harry Potter and  the Chamber of Secrets", author2,null, 423432, "available");
        bookList.add(book7);
        Book book8 = new Book("Harry Potter and  the Prisioner of Askaban", author2, user4, 42322, "available");
        bookList.add(book8);
        Book book9 = new Book("Don Quixote", author5, null, 123229, "Available");
        bookList.add(book9);
        Book book10 = new Book("To Kill a Mocking Bird", author6, null, 432543, "Available");
        bookList.add(book10);
    }
           

    public Book findBook(String title){
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }

        // No book found
        return null;
    }
    
     // Person can take one book only in the library
    public boolean takeBook(String user, String title) {
        for (int i = 0; i < bookList.size(); i++) {
             if (bookList.get(i).getTitle().equalsIgnoreCase(title)) {
               Book book = bookList.get(i);
               
               // Remove to start fresh
               bookList.remove(i);
               
               // Make the book new again
               book.setStatus("UNAVAILABLE");
             //  book.setId(personId);
               bookList.add(book);
               
               // successfully took the book
               return true;
            }
        }
        // could not find the book to take, title was wrong probably
        return false;
    }


    private String getStatus(String title) {
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book.getStatus();
            }
        }

        // No book found
        return null;
    }
    /*
        //books list
        Book[] bookList = new Book[10];
      
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
        
        
     */

} // End Library.
