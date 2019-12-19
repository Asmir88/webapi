package com.webapi.restapi.dao;

import com.webapi.restapi.models.RadioButtonField;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RadioButtonFieldDAO {

    @PersistenceContext(unitName = "restapi_PU")
    EntityManager em;

    public List<RadioButtonField> getAll() {
        return em.createNamedQuery("RadioButtonField.findAll", RadioButtonField.class).getResultList();
    }

    public RadioButtonField findById(Long id) {
        return em.find(RadioButtonField.class, id);
    }

    public void update(RadioButtonField radioButtonField) {
        em.merge(radioButtonField);
    }

    public void create(RadioButtonField radioButtonField) {
        em.persist(radioButtonField);
    }
}