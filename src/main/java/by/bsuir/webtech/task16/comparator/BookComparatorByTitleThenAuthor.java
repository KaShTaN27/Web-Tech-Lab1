package by.bsuir.webtech.task16.comparator;

import by.bsuir.webtech.task16.model.Book;

import java.util.Comparator;

public class BookComparatorByTitleThenAuthor implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        int compareByTitle = compareByTitle(o1, o2);
        return compareByTitle != 0 ? compareByTitle : compareByAuthor(o1, o2);
    }

    private int compareByTitle(Book o1, Book o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }

    private int compareByAuthor(Book o1, Book o2) {
        return o1.getAuthor().compareTo(o2.getAuthor());
    }
}
