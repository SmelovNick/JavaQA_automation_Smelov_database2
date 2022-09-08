package models.repositories;

import models.domain.AuthorsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AuthorsRepository implements IRepository<AuthorsEntity,Integer>{

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public AuthorsRepository(){
        entityManagerFactory = Persistence.createEntityManagerFactory("library");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void save(AuthorsEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(AuthorsEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.refresh(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public AuthorsEntity findById(Integer id) {
        return entityManager.find(AuthorsEntity.class, id);
    }

    @Override
    public void delete(AuthorsEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<AuthorsEntity> findAll() {
        return entityManager.createQuery("from AuthorsEntity").getResultList();
    }

    @Override
    public void deleteAll() {
        List<AuthorsEntity> authors = findAll();
        for(var author : authors){
            delete(author);
        }
    }
}