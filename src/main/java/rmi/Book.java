package main.java.rmi;

import java.io.Serializable;

public class Book implements Serializable {
    private String author;
    private String title;

    public Book(String autor, String title) {
        this.author = autor;
        this.title = title;
    }

    private Book() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return author + " : " + title;
    }

}
