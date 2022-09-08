import models.domain.AuthorsEntity;
import models.services.AuthorsService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

public class BaseTest {

    private AuthorsService authorsService;
    private int id;

    @BeforeEach
    public void setup(){
        authorsService = new AuthorsService();
    }

    @Test
    public void whenCreateExistingAuthorShouldReturnError() throws Exception{
        AuthorsEntity author = new AuthorsEntity();
        author.setName("F.Scott Fitzgeral");
        author.setCountry("USA");
        id = authorsService.create(author);
    }

    @AfterEach
    public void teardown(){
        authorsService.delete(id);
    }
}
