package com.webapi.restapi.dao;

import com.webapi.restapi.models.FormularVersion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FormularVersionDAO {

    @PersistenceContext(unitName = "restapi_PU")
    EntityManager em;

    public List<FormularVersion> getAll() {
        return em.createNamedQuery("FormularVersion.findAll", FormularVersion.class).getResultList();
    }

    public FormularVersion findById(Long id) {
        return em.find(FormularVersion.class, id);
    }

    public FormularVersion findByName(String name) {
        return em.createNamedQuery("FormularVersion.searchByName", FormularVersion.class)
        .setParameter("name", name).getResultList()
        .stream().findFirst().orElse(null);
    }

    public void update(FormularVersion formularVersion) {
        em.merge(formularVersion);
    }

    public void create(FormularVersion formularVersion) {
        em.persist(formularVersion);
    }
}