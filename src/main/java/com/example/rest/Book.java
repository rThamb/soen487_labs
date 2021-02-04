package com.example.rest;


import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@XmlRootElement
public class Book implements Serializable {
    /**
     * Class that will be used to hold the data for the Rest API Example
     */

    private String title;
    private String author;
    private String isbn;

    public Book(){}

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String newName) {
        this.author = newName;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String toString() {
        return String.format("The title of this book is %s, written by %s, and its isbn is %s",
                this.getTitle(), this.getAuthor(), this.getIsbn());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
