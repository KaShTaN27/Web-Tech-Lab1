package by.bsuir.webtech.task16.comparator;

import by.bsuir.webtech.task16.model.Book;

import java.util.Comparator;

public class BookComparatorByAuthorThenTitle implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        int compareByAuthor = compareByAuthor(o1, o2);
        return compareByAuthor != 0 ? compareByAuthor : compareByTitle(o1, o2);
    }

    private int compareByTitle(Book o1, Book o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }

    private int compareByAuthor(Book o1, Book o2) {
        return o1.getAuthor().compareTo(o2.getAuthor());
    }
}
