package models.services;

import models.domain.AuthorsEntity;
import models.repositories.AuthorsRepository;

import java.util.List;
import java.util.stream.Stream;

public class AuthorsService {
    private static AuthorsRepository authorsRepository;

    public AuthorsService(){
        authorsRepository = new AuthorsRepository();
    }

    public void save(AuthorsEntity author){
        authorsRepository.save(author);
    }

    public void update(AuthorsEntity author){
        authorsRepository.update(author);
    }

    public AuthorsEntity getById(int id){
        return authorsRepository.findById(id);
    }

    public int create(AuthorsEntity author) throws Exception {
        var existingAuthor = authorsRepository
                .findAll()
                .stream()
                .filter(
                        auth -> auth.getName().equals(author.getName())
                                && auth.getCountry().equals(author.getCountry()))
                .findFirst();

        if (existingAuthor.isPresent()){
            throw new Exception("This author is already exist");
        }
        authorsRepository.save(author);

        return author.getId();
    }
    public void delete(int id){
        AuthorsEntity author = authorsRepository.findById(id);
        authorsRepository.delete(author);
    }

    public List<AuthorsEntity> findAll(){
        return authorsRepository.findAll();
    }

    public void deleteAll(){
        authorsRepository.deleteAll();
    }
}
