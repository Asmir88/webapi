package com.webapi.restapi.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "radioButtonField")
@NamedQueries({
    @NamedQuery(name = "RadioButtonField.findAll", query = "SELECT t FROM RadioButtonField t")
})
public class RadioButtonField implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
	
    @Override
    public String toString() {
        return "Type{" + "id=" + id + ", name=" + name + '}';
    }
}