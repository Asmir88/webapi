package com.webapi.restapi.dao;

import com.webapi.restapi.models.FormularFieldVersion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FormularFieldVersionDAO {

    @PersistenceContext(unitName = "restapi_PU")
    EntityManager em;

    public List<FormularFieldVersion> getAll() {
        return em.createNamedQuery("FormularFieldVersion.findAll", FormularFieldVersion.class).getResultList();
    }

    public FormularFieldVersion findById(Long id) {
        return em.find(FormularFieldVersion.class, id);
    }

    public void update(FormularFieldVersion formularFieldVersion) {
        em.merge(formularFieldVersion);
    }

    public void create(FormularFieldVersion formularFieldVersion) {
        em.persist(formularFieldVersion);
    }
}