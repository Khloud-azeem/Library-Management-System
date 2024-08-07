package com.example.library.service;
import com.example.library.entity.BorrowingRecord;
import com.example.library.repository.BorrowingRecordRepository;
import com.example.library.repository.BookRepository;
import com.example.library.repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowingRecordService {

    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PatronRepository patronRepository;

    @Transactional
    public BorrowingRecord borrowBook(Long bookId, Long patronId) {
        BorrowingRecord record = new BorrowingRecord();
        record.setBook(bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found")));
        record.setPatron(patronRepository.findById(patronId).orElseThrow(() -> new RuntimeException("Patron not found")));
        record.setBorrowDate(LocalDate.now());
        return borrowingRecordRepository.save(record);
    }

    @Transactional
    public BorrowingRecord returnBook(Long bookId, Long patronId) {
        List<BorrowingRecord> records = borrowingRecordRepository.findAll();
        for (BorrowingRecord record : records) {
            if (record.getBook().getId().equals(bookId) && record.getPatron().getId().equals(patronId) && record.getReturnDate() == null) {
                record.setReturnDate(LocalDate.now());
                return borrowingRecordRepository.save(record);
            }
        }
        throw new RuntimeException("Borrowing record not found or book already returned");
    }

    public List<BorrowingRecord> getAllBorrowingRecords() {
        return borrowingRecordRepository.findAll();
    }
}
