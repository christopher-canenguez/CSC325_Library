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
    private String isbn;
    private String status;
    //  private User holder; 

    public Book(String bookTitle, Person bookAuthor, String bookISBN, String bookStatus) {
        title = bookTitle;
        author = bookAuthor;
        isbn = bookISBN;
        status = bookStatus;
        //holder = bookHolder;
    } // End Book.

    public String getTitle() {
        return title;
    } // End getTitle.

    public void setTitle(String title) {
        this.title = title;
    } // End setTitle.

    public Person getAuthor() {
        return author;
    } // End getAuthor.

    public void setAuthor(Person author) {
        this.author = author;
    } // End setAuthor.

    public String getIsbn() {
        return isbn;
    } // End getIsbn.

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    } // End setIsbn.

    public String getStatus() {
        return status;
    } // End getStaatus.

    public void setStatus(String status) {
        this.status = status;
    } // End setStatus.

    /*
    public Person getHolder() {
        return holder;
    }

    /**
     * constructor for book
     * @param holder
    
    
    public void setHolder(User holder) {
        this.holder = holder;
    }
    
     */
    @Override
    public String toString() {
        String bookInfo = "Book Information - " + "title: " + title + ", author: " + author + ", isbn: " + isbn + ", status: " + status;
        return bookInfo;
    } // End toString.
} // End Book.
