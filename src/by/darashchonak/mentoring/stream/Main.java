package by.darashchonak.mentoring.stream;

import by.darashchonak.mentoring.stream.fi.TriFunction;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        TriFunction<Integer, Integer, Integer, Integer> addThemAll = (x, y, z) -> x + y + z;
        TriFunction<Double, Double, Double, Double> multiplyThemAll = (x, y, z) -> x * y * z;
        TriFunction<String, String, String, Integer> countThemAll = (x, y, z) -> x.length() + y.length() + z.length();


        System.out.println(addThemAll.apply(3,4,78));
        System.out.println(multiplyThemAll.apply(3.0 ,4.6,7.8));
        System.out.println(countThemAll.apply("Hello", "damn", "world"));


        Author hawking = new Author("Stephen Hawking");
        Author mlodinow = new Author("Leonard Mlodinow");
        Author rowling = new Author("Joanne Rowling");

        Book brieferHistory = new Book("A Briefer History of Time", 180, new HashSet<Author>(){{
            add(mlodinow);
            add(hawking);
        }});

        Book blackHoles = new Book("Black Holes and Baby Universes and other Essays", 182,
                new HashSet<Author>(){{
            add(hawking);
        }});

        Book prisonerOfAzkaban = new Book("Harry Potter and the Prisoner of Azkaban", 317,
                new HashSet<Author>(){{
            add(rowling);
        }});

        Book[] books = new Book[]{brieferHistory, blackHoles, prisonerOfAzkaban};

        //======================================================================//

        List moreThat200 = Arrays.stream(books).filter(b -> b.getNumberOfPages() > 200).collect(Collectors.toList());

        System.out.println("Books with more than 200 pages: " + moreThat200);

        Book maxPages = Arrays.stream(books).max(Comparator.comparing(Book::getNumberOfPages)).get();

        System.out.println("Book with max pages: " + maxPages);

        List singleAuthor = Arrays.stream(books).filter(b -> b.getAuthors().size() == 1).collect(Collectors.toList());

        System.out.println("Books with a single author: " + singleAuthor);

        List sortedByTitle = Arrays.stream(books)
                .sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());

        System.out.println("Sorted by Title: " + sortedByTitle);

        List titles = Arrays.stream(books).map(Book::getTitle).collect(Collectors.toList());

        System.out.println("Titles only: " + titles);

        // Print titles
        Arrays.stream(books).map(Book::getTitle).forEach(System.out::println);

        List authors = Arrays.stream(books)
                .flatMap(book -> book.getAuthors().stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Distinct Authors " + authors);

        Optional<Book> biggestBookOfHawking = Arrays.stream(books).filter(book -> book.getAuthors().contains(hawking))
                .peek(book -> System.out.println(book.getTitle()))
                .max(Comparator.comparing(Book::getNumberOfPages));

        System.out.println("Biggest book: " + biggestBookOfHawking.orElse(null));

        // Parallel stream
        int sumOfPages = Arrays.stream(books).parallel().mapToInt(Book::getNumberOfPages).sum();

        System.out.println("Total pages amount: " + sumOfPages);

    }
}
