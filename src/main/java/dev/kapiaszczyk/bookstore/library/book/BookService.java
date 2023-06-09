package dev.kapiaszczyk.bookstore.library.book;

import dev.kapiaszczyk.bookstore.library.book.dto.BookDTO;
import dev.kapiaszczyk.bookstore.library.book.dto.BookMapper;
import dev.kapiaszczyk.bookstore.library.book.projections.BookInformationProjection;
import dev.kapiaszczyk.bookstore.library.loan.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookDTO> findAll() {
        List<Book> results = bookRepository.findAll();
        return BookMapper.INSTANCE.mapToDTOList(results);
    }

    public List<BookInformationProjection> getAllBooksWithTitleIsbnAuthors() {
        return bookRepository.findAllBooksWithTitleIsbnAuthors();
    }

    public List<BookDTO> getBooksByTitleAndInventoryLibraryName(String title, String name) {
        List<Book> results = bookRepository.findBooksByTitleAndInventoryLibraryName(title, name);
        return BookMapper.INSTANCE.mapToDTOList(results);
    }

    public List<String> getBooksByAuthorNameAndSurname(String firstName, String lastName) {
        return bookRepository.findByCreditsAuthorFirstNameAndCreditsAuthorLastName(firstName, lastName);
    }

    public List<BookDTO> getAllByLoanStatus(Loan.Status status) {
        List<Book> results = bookRepository.findALlByLoanStatus(status);
        return BookMapper.INSTANCE.mapToDTOList(results);
    }
}
