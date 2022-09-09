import models.domain.AuthorsEntity;
import models.domain.BooksEntity;
import models.services.AuthorsService;
import models.services.BookService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class BaseTest {

    private AuthorsService authorsService;
    private BookService bookService;
    private int authorId;
    private int bookId1;
    private int bookId2;


    @BeforeEach
    public void setup(){
        authorsService = new AuthorsService();
        bookService = new BookService();
    }

    @Test
    public void whenCreateExistingAuthorShouldReturnError() throws Exception{
        AuthorsEntity author = new AuthorsEntity();
        author.setName("F.Scott Fitzgeral");
        author.setCountry("USA");
        authorId = authorsService.create(author);
    }

    @Test
    public void whenCreateBookShouldReturnOk() throws Exception{
        BooksEntity book1 = new BooksEntity();
        book1.setTitle("Python in Action");

        BooksEntity book2 = new BooksEntity();
        book2.setTitle("Python in Action");

        bookId1 = bookService.create(book1);
        bookId2 = bookService.create(book2);

        Assertions.assertNotEquals(bookId1, bookId2);
    }

    @Test
    public void whenGetBookWithTitleShouldReturnExactId(){
        List<BooksEntity> book = bookService.getAllByTitle("Nine Stries");
        Assertions.assertTrue(book.stream().anyMatch(b -> b.getId() ==2));
    }

    @Test
    public void whenGetBookWithSubstringShouldReturnExactId(){
        List<BooksEntity> book = bookService.getAllByTitleContains("Stries");
        Assertions.assertTrue(book.stream().anyMatch(b -> b.getId() ==2));
    }
    @AfterEach
    public void teardown(){
        authorsService.delete(authorId);
        bookService.delete(bookId1);
        bookService.delete(bookId2);
    }
}
