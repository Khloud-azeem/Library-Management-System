package com.example.library.service;
import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BookServiceTests {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testGetBookById() {
        MockitoAnnotations.openMocks(this);

        Book book = new Book(1L, "The Catcher in the Rye", "J.D. Salinger", 1951, "978-0-316-76948-0", null);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        Optional<Book> foundBook = bookService.getBookById(1L);

        assertEquals("The Catcher in the Rye", foundBook.get().getTitle());
    }
}
