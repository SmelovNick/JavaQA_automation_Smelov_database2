package models.services;

import models.domain.AuthorsEntity;
import models.domain.BooksEntity;
import models.repositories.BooksRepository;

public class BookService {
    private static BooksRepository booksRepository;

    public BookService(){booksRepository = new BooksRepository();}

    public void save (BooksEntity book){
        booksRepository.save(book);
    }

    public void update(BooksEntity book){
        booksRepository.update(book);
    }

    public BooksEntity getById(int id){return booksRepository.findById(id);}

    public int create(BooksEntity book) throws Exception {
        if(book.getTitle().isBlank()) throw new Exception("Title cannot be blank");


        booksRepository.save(book);
        return book.getId();
    }

    public void delete(int bookId) {
        BooksEntity existingBook = booksRepository.findById(bookId);
        if(existingBook!=null)
        booksRepository.delete(existingBook);
    }
}
