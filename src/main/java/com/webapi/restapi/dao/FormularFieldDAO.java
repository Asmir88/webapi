package com.webapi.restapi.dao;

import com.webapi.restapi.models.FormularField;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FormularFieldDAO {

    @PersistenceContext(unitName = "restapi_PU")
    EntityManager em;

    public List<FormularField> getAll() {
        return em.createNamedQuery("FormularField.findAll", FormularField.class).getResultList();
    }

    public FormularField findById(Long id) {
        return em.find(FormularField.class, id);
    }

    public void update(FormularField formularField) {
        em.merge(formularField);
    }

    public FormularField create(FormularField formularField) {
        em.persist(formularField);
        return formularField;
    }
}