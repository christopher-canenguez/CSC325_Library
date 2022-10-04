package com.mycompany.csc325_library;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * Title: Book Class
 * Description: Contains the attributes of a Book object
 *
 * @author Kulsom Zaraei
 */

public class Book {
    
    /**
     * instance variables
     */
    private String title;
    private String author;
    private int isbn;
    private String status;
    private Person holder; //person who has book taken out, should be user when user is created 

    

    public Book(String bookTitle, String bookAuthor, int bookISBN, String bookStatus, Person bookHolder) {
        title = bookTitle;
        author = bookAuthor;
        isbn = bookISBN;
        status = bookStatus;
        holder = bookHolder;
    }
     public String getTitle() {    
        return title;
        
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Person getHolder() {
        return holder;
    }

    /**
     * constructor for book
     * @param holder
     */
    
    public void setHolder(Person holder) {
        this.holder = holder;
    }
    
    
    @Override
    public String toString() {
       String bookInfo =  "Book Information :" +  "title=" + title + ", author=" + author + ", isbn=" + isbn + ", status=" + status + ", holder=" + holder;
        return bookInfo;
    }

    
}
