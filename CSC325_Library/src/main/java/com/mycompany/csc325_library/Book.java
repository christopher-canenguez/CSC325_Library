package com.mycompany.csc325_library;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * Title: Book Class Description: Contains the attributes of a Book object
 *
 * @author Kulsom Zaraei
 */
public class Book {

    /**
     * instance variables
     */
    private String title;
    private Person author;
    private String holder;
    private String isbn;
    private String status;

    /**
     * Book Constructor
     * @param bookTitle
     * @param bookAuthor
     * @param bookHolder
     * @param bookISBN
     * @param bookStatus 
     */
    public Book(String bookTitle, Person bookAuthor, String bookHolder, String bookISBN, String bookStatus) {
        title = bookTitle;
        author = bookAuthor;
        isbn = bookISBN;
        status = bookStatus;
        holder = bookHolder;
    } // End Book.

    /**
     * Method to return the title of the book.
     * @return 
     */
    public String getTitle() {
        return title;
    } // End getTitle.

    /**
     * Method to set the title of the book.
     * @param title 
     */
    public void setTitle(String title) {
        this.title = title;
    } // End setTitle.

    /**
     * Method to return the author of the book.
     * @return 
     */
    public Person getAuthor() {
        return author;
    } // End getAuthor.

    /**
     * Method to set the author of the book.
     * @param author 
     */
    public void setAuthor(Person author) {
        this.author = author;
    } // End setAuthor.

    /**
     * Method that returns the isbn of the book.
     * @return 
     */
    public String getIsbn() {
        return isbn;
    } // End getIsbn.

    /**
     * Method that sets the isbn of the book.
     * @param isbn 
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    } // End setIsbn.

    /**
     * Method that returns the availability status of the book.
     * @return 
     */
    public String getStatus() {
        return status;
    } // End getStaatus.

    /**
     * Method that changes the status of availability of the book.
     * @param status 
     */
    public void setStatus(String status) {
        this.status = status;
    } // End setStatus.

    /**
     * Method that returns the name of the user who currently has the book.
     * @return 
     */
    public String getHolder() {
        return holder;
    }

    /**
     * Method that sets the holder for the book.
     * @param holder 
     */
    public void setHolder(String holder) {
        this.holder = holder;
    }

    @Override
    public String toString() {
        String bookInfo = "Book Information - " + "title: " + title + ", author: " + author + ", isbn: " + isbn + ", status: " + status + "Book Holder: " + holder;
        return bookInfo;
    } // End toString.
} // End Book.
