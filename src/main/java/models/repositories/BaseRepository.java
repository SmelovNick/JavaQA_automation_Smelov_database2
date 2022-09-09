package models.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseRepository {
    protected EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;

    public BaseRepository(){
        entityManagerFactory = Persistence.createEntityManagerFactory("library");
        entityManager = entityManagerFactory.createEntityManager();
    }
}
