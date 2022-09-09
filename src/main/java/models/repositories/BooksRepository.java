package models.repositories;

import models.domain.AuthorsEntity;
import models.domain.BooksEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class BooksRepository extends BaseRepository implements IRepository<BooksEntity, Integer>{


    @Override
    public void save(BooksEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(BooksEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.refresh(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public BooksEntity findById(Integer id) {
        return entityManager.find(BooksEntity.class, id);
    }

    @Override
    public void delete(BooksEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<BooksEntity> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
