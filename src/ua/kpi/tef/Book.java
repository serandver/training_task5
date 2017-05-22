package ua.kpi.tef;

public class Book {
    private String bookName;
    private String author;
    private String year;
    private long edition;
    private int pages;

    public Book() {
        System.out.println("ua.kpi.tef.Book Default Class Constructor");

    }

    public Book(String bookName, String author, String year, long edition, int pages) {
        System.out.println("ua.kpi.tef.Book Class Constructor");
        this.bookName = bookName;
        this.author = author;
        this.year = year;
        this.edition = edition;
        this.pages = pages;
    }

    @MyAnnotation
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

    @MyAnnotation
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
