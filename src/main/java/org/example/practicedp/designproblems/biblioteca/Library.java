package org.example.practicedp.designproblems.biblioteca;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Library {
    private final Map<Book, Boolean> books;

    public Library() {
        this.books = new HashMap<>();

        addBook(new Book(1L, "Head First Java", "XYZ", 2000));
        addBook(new Book(2L, "Head First Design", "ABC", 2001));
        addBook(new Book(3L, "Head First C", "LMN", 2002));
        addBook(new Book(4L,"Head Second Java", "XYZ", 2003));
        addBook(new Book(5L, "Head Second Design", "ABC", 2004));
        addBook(new Book(6L, "Head Second C", "LMN", 2005));
        addBook(new Book(7L, "Head Third Java", "XYZ", 2006));
        addBook(new Book(8L, "Head Third Design", "ABC", 2007));
        addBook(new Book(9L, "Head Third C", "LMN", 2008));
    }

    public List<Book> getAvailableBooks() {
        return books.keySet().stream().filter(this::isAvailable).toList();
    }

    public String checkout(String enteredBook) {
        Optional<Book> foundBook = getBook(enteredBook);
        if (foundBook.isEmpty()) {
            return "That book is not available.";
        }

        books.put(foundBook.get(), false);
        return "Thank you! Enjoy the book.";
    }

    public String returnBook(String book) {
        Optional<Book> bookToReturn = getBook(book);

        if (bookToReturn.isEmpty()) {
            return "That is not a valid book to return.";
        }

        books.put(bookToReturn.get(), true);
        return "Thank you for returning the book.";
    }


    private Optional<Book> getBook(String title) {
        return books.keySet().stream().filter(book -> book.title().equalsIgnoreCase(title)).findFirst();
    }

    private boolean isAvailable(Book book) {
        return books.get(book);
    }

    private void addBook(Book book) {
        books.put(book, true);
    }
}
