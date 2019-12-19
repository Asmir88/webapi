package com.webapi.restapi.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import java.util.List;
import com.webapi.restapi.models.FormularField;

@Entity
@Table(name = "formulars")
@NamedQueries({
	@NamedQuery(name = "Formular.findAll", query = "SELECT f FROM Formular f"),
    @NamedQuery(name = "Formular.searchByName", query = "SELECT f FROM Formular f WHERE LOWER(f.name) = LOWER(:name)")
})
public class Formular implements Serializable {
	
    private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    
    @OneToMany( targetEntity=FormularField.class, cascade = CascadeType.ALL, mappedBy = "formular" )
    @JoinColumn(name = "formular_id")
    private List<FormularField> fields;
    
    @OneToMany( targetEntity=FormularVersion.class, cascade = CascadeType.ALL, mappedBy = "formular" )
    private List<FormularVersion> versions;
	
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
    
    public List<FormularField> getFields() {
    	return fields;
    }
    
    public void setFields(List<FormularField> fields) {
    	this.fields = fields;
    }
	
    @Override
    public String toString() {
		return "Formular{" + "id=" + id + ", name=" + name + '}';
    }
	
}