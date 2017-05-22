package ua.kpi.tef;

public class LibraryBook extends Book {

    private long inventoryNumber;
    private String readerName;

    public LibraryBook() {
        super();
        System.out.println("ua.kpi.tef.LibraryBook Default Class Constructor");
    }

    public LibraryBook(String bookName, String author, String year, long edition, int pages, long inventoryNumber, String readerName) {
        super(bookName, author, year, edition, pages);
        System.out.println("ua.kpi.tef.LibraryBook Class Constructor");
        this.inventoryNumber = inventoryNumber;
        this.readerName = readerName;
    }

    @MyAnnotation
    public long getInventoryNumber() {
        return inventoryNumber;
    }

    @MyAnnotation
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
