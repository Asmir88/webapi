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
@Table(name = "formularField")
@NamedQueries({
    @NamedQuery(name = "FormularField.findAll", query = "SELECT t FROM FormularField t")
})
public class FormularField implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
    private String validator;
    private Long quantity;

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
	
    public Long getQuantity() {
        return quantity;
    }
	
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
	
    public String getType() {
        return type;
    }
	
    public void setType(String type) {
        this.type = type;
    }
	
    public String getValidator() {
        return validator;
    }
	
    public void setValidator(String validator) {
        this.validator = validator;
    }

    @Override
    public String toString() {
        return "Type{" + "id=" + id + ", name=" + name + '}';
    }
}