package com.webapi.restapi.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "radioButtonFields")
@NamedQueries({
    @NamedQuery(name = "RadioButtonField.findAll", query = "SELECT t FROM RadioButtonField t")
})
public class RadioButtonField implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "formularField_id")
    private FormularField formularField;

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
    
    public FormularField getFormularField() {
    	return formularField;
    }
    
    public void setFormularField(FormularField formularField) {
    	this.formularField = formularField;
    }
}