package by.bsuir.webtech.task14.model;

public class Book implements Cloneable {
    private String title;
    private String author;
    private int price;
    private static int edition;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Book book = new Book();
        book.author = this.author;
        book.price = this.price;
        book.title = this.title;
        return book;
    }
}
