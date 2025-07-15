package com.mycompany.userregistr.dao;

import com.mycompany.userregistr.model.Ware;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WareDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Ware ware) {
        entityManager.persist(ware);
    }

    public Ware findById(Long id) {
        return entityManager.find(Ware.class, id);
    }

    public List<Ware> findAll() {
        return entityManager.createQuery("SELECT a FROM Ware a", Ware.class).getResultList();
    }

    public void update(Ware ware) {
        entityManager.merge(ware);
    }

    public void delete(Long id) {
        Ware ware = findById(id);
        if (ware != null) {
            entityManager.remove(ware);
        }
    }
}
