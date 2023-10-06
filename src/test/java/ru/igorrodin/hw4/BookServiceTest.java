package ru.igorrodin.hw4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private BookService bookService;

    @Test
    void findBookById() {
        String bookId = "id_1";
        Book bookId1 = new Book(bookId, "Book", "Author");
        when(bookRepository.findById(bookId)).thenReturn(bookId1);

        assertThat(bookService.findBookById(bookId)).isEqualTo(bookId1);
        verify(bookRepository, times(1)).findById(bookId);
    }

    @Test
    void findAllBooks() {
        List<Book> allBooks = List.of(new Book("id_1", "Book", "Author"),
                new Book("id_2", "Book2", "Author"));
        when(bookRepository.findAll()).thenReturn(allBooks);
        assertThat(bookService.findAllBooks()).isEqualTo(allBooks);
    }
}