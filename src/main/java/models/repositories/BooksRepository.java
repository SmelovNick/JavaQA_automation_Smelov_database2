package models.repositories;

import models.domain.BooksEntity;

import java.util.List;

public class BooksRepository extends BaseRepository<BooksEntity>{

    @Override
    public BooksEntity findById(Integer id){
        return entityManager.find(BooksEntity.class, id);
    }

    public List<BooksEntity> findAllByTitle(String title) {
        String query = String.format("from BooksEntity where Title is '%s'", title);
        return entityManager.createQuery(query).getResultList();
    }


    public List<BooksEntity> findAllByTitleContains(String substr) {
        String query = "from BooksEntity where Title like '%" +substr+"%'";
        return entityManager.createQuery(query).getResultList();
    }
}
