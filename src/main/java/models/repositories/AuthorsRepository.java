package models.repositories;

import models.domain.AuthorsEntity;
import java.util.List;

public class AuthorsRepository extends BaseRepository<AuthorsEntity>{

    @Override
    public AuthorsEntity findById(Integer id){
        return entityManager.find(AuthorsEntity.class, id);
    }

    public List<AuthorsEntity> findAll() {
        return entityManager.createQuery("from AuthorsEntity").getResultList();
    }

    public void deleteAll() {
        List<AuthorsEntity> authors = findAll();
        for(var author : authors){
            delete(author);
        }
    }
}