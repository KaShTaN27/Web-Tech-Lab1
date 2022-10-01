package by.bsuir.webtech.task15.model;

public class Book implements Comparable<Book>{
    private String title;
    private String author;
    private int price;
    private int isbn;
    private static int edition;

    public int getIsbn() {
        return isbn;
    }

    @Override
    public int compareTo(Book o) {
        return this.isbn - o.getIsbn();
    }
}
