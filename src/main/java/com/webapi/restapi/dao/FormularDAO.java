package com.webapi.restapi.dao;

import com.webapi.restapi.models.Formular;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FormularDAO {

    @PersistenceContext(unitName = "restapi_PU")
    EntityManager em;

    public List<Formular> getAll() {
        return em.createNamedQuery("Formular.findAll", Formular.class).getResultList();
    }

    public Formular findById(Long id) {
        return em.find(Formular.class, id);
    }

    public Formular findByName(String name) {
        return em.createNamedQuery("Formular.searchByName", Formular.class)
        .setParameter("name", name).getResultList()
        .stream().findFirst().orElse(null);
    }

    public void update(Formular formular) {
        em.merge(formular);
    }

    public void create(Formular formular) {
        em.persist(formular);
    }
}