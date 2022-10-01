package by.bsuir.webtech.task12.model;

import java.util.Objects;

public class Book {
    private final String title;
    private final String author;
    private final int price;
    private static int edition;

    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Book book))
            return false;

        return price == book.price &&
                title.equals(book.title) &&
                author.equals(book.author);

    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
