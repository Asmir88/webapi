package com.webapi.restapi.dao;

import com.webapi.restapi.models.RadioButtonFieldVersion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RadioButtonFieldVersionDAO {

    @PersistenceContext(unitName = "restapi_PU")
    EntityManager em;

    public List<RadioButtonFieldVersion> getAll() {
        return em.createNamedQuery("RadioButtonFieldVersion.findAll", RadioButtonFieldVersion.class).getResultList();
    }

    public RadioButtonFieldVersion findById(Long id) {
        return em.find(RadioButtonFieldVersion.class, id);
    }

    public void update(RadioButtonFieldVersion radioButtonFieldVersion) {
        em.merge(radioButtonFieldVersion);
    }

    public void create(RadioButtonFieldVersion radioButtonFieldVersion) {
        em.persist(radioButtonFieldVersion);
    }
}