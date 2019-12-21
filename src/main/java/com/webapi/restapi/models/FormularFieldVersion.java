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
@Table(name = "formularFieldVersions")
@NamedQueries({
    @NamedQuery(name = "FormularFieldVersion.findAll", query = "SELECT t FROM FormularFieldVersion t")
})
public class FormularFieldVersion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
    private String validator;
    private Long quantity;
    private String value;
    
    @ManyToOne
    @JoinColumn(name = "formularVersion_id")
    private FormularVersion formularVersion;
    
    @OneToMany( targetEntity=RadioButtonFieldVersion.class, cascade = CascadeType.ALL, mappedBy = "formularFieldVersion")
    private List<RadioButtonFieldVersion> radioButtonFields;

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
	
    public String getValue() {
        return value;
    }
	
    public void setValue(String value) {
        this.value = value;
    }
    
    public FormularVersion getFormularVersion() {
    	return formularVersion;
    }
    
    public void setFormularVersion(FormularVersion formularVersion) {
    	this.formularVersion = formularVersion;
    }
    
    public List<RadioButtonFieldVersion> getRadioButtonFields() {
    	return radioButtonFields;
    }
    
    public void setRadioButtonFields(List<RadioButtonFieldVersion> radioButtonFields) {
    	this.radioButtonFields = radioButtonFields;
    }
}