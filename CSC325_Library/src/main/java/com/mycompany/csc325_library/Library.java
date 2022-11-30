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

    public ArrayList<Book> bookList;

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

        Librarian[] librarianList = new Librarian[2];

        Librarian Librarian1 = new Librarian("Lucy Lee", 900, 900);
        Librarian1 = librarianList[0];

        Librarian Librarian2 = new Librarian("Marilyn Dot", 800, 800);
        Librarian2 = librarianList[1];

        Librarian Librarian3 = new Librarian("Marilyn Dot", 700, 700);
        Librarian2 = librarianList[2];

        Book book1 = new Book("The Outsiders", author1, user4, 123455, "Not Available");
        bookList.add(book1);
        Book book2 = new Book("Harry Potter and The Sorcerers Stone", author2, user1, 434566, "Not Available");
        bookList.add(book2);
        Book book3 = new Book("Hamlet", author3, null, 76859, "Available");
        bookList.add(book3);
        Book book4 = new Book("Romeo and Juliet", author3, null, 78899, "Available");
        bookList.add(book4);
        Book book5 = new Book("Redburn", author4, null, 75648, "Available");
        bookList.add(book5);
        Book book6 = new Book("Billy Budd", author4, user5, 654322, "Available");
        bookList.add(book6);
        Book book7 = new Book("Harry Potter and  the Chamber of Secrets", author2, null, 423432, "Available");
        bookList.add(book7);
        Book book8 = new Book("Harry Potter and  the Prisioner of Askaban", author2, user4, 42322, "Available");
        bookList.add(book8);
        Book book9 = new Book("Don Quixote", author5, null, 123229, "Available");
        bookList.add(book9);
        Book book10 = new Book("To Kill a Mocking Bird", author6, null, 432543, "Available");
        bookList.add(book10);
    }

    //search 
    public Book findBookByTitle(String title) {
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
        
        

    public Book findBookByIsbn(int isbn) {
        for (Book book : bookList) {
            if (book.getIsbn() == isbn) {
                return book;
            }
        }

        // No book found
        return null;
    }
    

   
        //add books
    public void insertBook(Book theBook) {
        bookList.add(theBook);
    }

    //Take out book
    public boolean takeBook(String user, String title) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getTitle().equalsIgnoreCase(title)) {
                Book book = bookList.get(i);

                // Remove to start fresh and update
                bookList.remove(i);

                // Make the book new again and re add
                book.setStatus("UNAVAILABLE");
                //    book.setId(id);
                bookList.add(book);

                // successfully took the book
                return true;
            }
        }
        // could not find the book to take, title was wrong probably
        return false;
    }
    
    

    public String returnBook(String personId) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getHolder() != null
                    && bookList.get(i).getHolder().equals(personId)) {
                System.out.println("Was this entered");
                Book book = bookList.get(i);

                // Remove to start fresh
                bookList.remove(i);

                // Make the book new again
                book.setStatus("AVAILABLE");
                //     book.setPersonId(" ");
                bookList.add(book);

                // success
                return book.getTitle();
            }
        }

        return "User Not found";

    }
}
