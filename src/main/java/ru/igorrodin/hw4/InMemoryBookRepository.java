package ru.igorrodin.hw4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryBookRepository implements BookRepository {
    private final Map<String, Book> books;

    public InMemoryBookRepository() {
        this.books = new HashMap<>();
        this.books.put("1", new Book("1", "Book1", "Author1"));
        this.books.put("2", new Book("2", "Book2", "Author2"));
    }

    @Override
    public Book findById(String id) {
        return this.books.get(id);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(this.books.values());
    }
}
