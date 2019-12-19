package com.webapi.restapi.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "formularFields")
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
    
    @ManyToOne
    @JoinColumn(name = "formular_id")
    private Formular formular;
    
    @OneToMany( targetEntity=RadioButtonField.class, cascade = CascadeType.ALL )
    @JoinColumn(name = "formularField_id")
    private List<RadioButtonField> radioButtonFields;

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
    
    public Formular getFormular() {
    	return formular;
    }
    
    public void setFormular(Formular formular) {
    	this.formular = formular;
    }
    
    public List<RadioButtonField> getRadioButtonFields() {
    	return radioButtonFields;
    }
    
    public void setRadioButtonFields(List<RadioButtonField> radioButtonFields) {
    	this.radioButtonFields = radioButtonFields;
    }

    @Override
    public String toString() {
        return "Type{" + "id=" + id + ", name=" + name + '}';
    }
}