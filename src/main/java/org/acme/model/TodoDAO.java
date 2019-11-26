package org.acme.model;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;

/**
 * TodoDAO
 */
@Singleton
public class TodoDAO {

    @Inject
    private EntityManager entityManager;

    public void persist(Todo todo) {
        entityManager.persist(todo);
    }

    public void delete(Todo todo){
        entityManager.remove(todo);
    }

    public List<Todo> FindByName(String title) {
        return entityManager.createQuery("FROM Person WHERE title = : title", Todo.class).setParameter("title", title).getResultList();
    }
    
}