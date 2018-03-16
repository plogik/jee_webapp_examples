package com.demo.webapp.repositories;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import java.util.List;

import com.demo.webapp.domain.entities.PhoneBookEntry;

public class PhoneBookEntryRepository {
    private EntityManagerFactory emf;

    public PhoneBookEntryRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void save(PhoneBookEntry entry) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(entry);
        em.getTransaction().commit();
        em.close();
    }

    public List<PhoneBookEntry> findAll() {
        EntityManager em = emf.createEntityManager();
        List<PhoneBookEntry> entries = 
            em.createQuery("select e from PhoneBookEntry e", PhoneBookEntry.class)
                        .getResultList();
        em.close();

        return entries;
    }
}