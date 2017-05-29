package ua.kpi.tef.model.entity;

import ua.kpi.tef.view.View;

import java.io.Serializable;

public class Book implements Serializable{
    private String bookName;

    @MyFieldAnnotation
    private String author;

    private String year;

    private long edition;

    @MyFieldAnnotation
    private int pages;

    public Book() {
        View.print("ua.kpi.tef.model.entity.Book Default Class Constructor");
    }

    public Book(String bookName, String author, String year, long edition, int pages) {
        View.print("ua.kpi.tef.model.entity.Book Class Constructor with parameters");
        this.bookName = bookName;
        this.author = author;
        this.year = year;
        this.edition = edition;
        this.pages = pages;
    }

    @MyMethodAnnotation
    public String getBookName() {
        return bookName;
    }

    public String getYear() {
        return year;
    }

    public long getEdition() {
        return edition;
    }

    public int getPages() {
        return pages;
    }

    @MyMethodAnnotation
    private String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                ", edition=" + edition +
                ", pages=" + pages +
                '}';
    }
}
