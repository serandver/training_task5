package ua.kpi.tef.model.entity;

import ua.kpi.tef.view.View;

import java.io.Serializable;

public class LibraryBook extends Book implements Serializable{

    private long inventoryNumber;
    private String readerName;

    public LibraryBook() {
        super();
        View.print("ua.kpi.tef.model.entity.LibraryBook Default Class Constructor");
    }

    public LibraryBook(String bookName, String author, String year, long edition, int pages, long inventoryNumber, String readerName) {
        super(bookName, author, year, edition, pages);
        View.print("ua.kpi.tef.model.entity.LibraryBook Class Constructor with parameters");
        this.inventoryNumber = inventoryNumber;
        this.readerName = readerName;
    }

    @MyMethodAnnotation
    public long getInventoryNumber() {
        return inventoryNumber;
    }

    @MyMethodAnnotation
    private String getReaderName() {
        return readerName;
    }

    @Override
    public String toString() {
        return "LibraryBook{" +
                "inventoryNumber=" + inventoryNumber +
                ", readerName='" + readerName + '\'' +
                '}';
    }
}
