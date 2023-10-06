package ru.igorrodin;


import ru.igorrodin.hw4.Book;
import ru.igorrodin.hw4.BookRepository;
import ru.igorrodin.hw4.BookService;
import ru.igorrodin.hw4.InMemoryBookRepository;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        BookRepository repository = new InMemoryBookRepository();
        BookService bookService = new BookService(repository);

        Book book1 = bookService.findBookById("1");
        System.out.println("Найдена книга: " + book1.getTitle() + " by " + book1.getAuthor());

        List<Book> allBooks = bookService.findAllBooks();
        System.out.println("Все книги:");
        for (Book book : allBooks) {
            System.out.println("- " + book.getTitle() + " от " + book.getAuthor());
        }
    }
}
