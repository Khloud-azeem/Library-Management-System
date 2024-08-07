package com.example.library.service;
import com.example.library.entity.Patron;
import com.example.library.repository.PatronRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PatronServiceTests {

    @Mock
    private PatronRepository patronRepository;

    @InjectMocks
    private PatronService patronService;

    @Test
    public void testGetPatronById() {
        MockitoAnnotations.openMocks(this);

        Patron patron = new Patron(1L, "John Doe", "john.doe@example.com", null);
        when(patronRepository.findById(1L)).thenReturn(Optional.of(patron));

        Optional<Patron> foundPatron = patronService.getPatronById(1L);

        assertEquals("John Doe", foundPatron.get().getName());
    }
}
