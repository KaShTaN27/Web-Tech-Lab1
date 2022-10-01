package by.bsuir.webtech.task16.comparator;

import by.bsuir.webtech.task16.model.Book;

import java.util.Comparator;

public class BookComparatorByTitle implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
