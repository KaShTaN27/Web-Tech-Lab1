package by.bsuir.webtech.task13.model;

import by.bsuir.webtech.task12.model.Book;

import java.util.Objects;

public class ProgrammerBook extends Book {
    private final String language;
    private final int level;

    public ProgrammerBook(String title, String author, int price, String language, int level) {
        super(title, author, price);
        this.language = language;
        this.level = level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(language, level);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof ProgrammerBook programmerBook))
            return false;
        return level == programmerBook.level &&
                language.equals(programmerBook.language);
    }

    @Override
    public String toString() {
        return "ProgrammerBook{" +
                "language='" + language + '\'' +
                ", level=" + level +
                '}';
    }
}
