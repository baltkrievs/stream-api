package by.darashchonak.mentoring.stream;

import java.util.HashSet;
import java.util.Set;

public class Book {

    private String title;
    private int numberOfPages;
    private Set<Author> authors;

    public Book(String title, int numberOfPages, Set<Author> authors) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public Set<Author> getAuthors() {
        return new HashSet<>(authors);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", authors=" + authors +
                '}';
    }
}
