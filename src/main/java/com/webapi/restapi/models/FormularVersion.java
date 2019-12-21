package com.webapi.restapi.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import java.util.List;
import com.webapi.restapi.models.FormularFieldVersion;

@Entity
@Table(name = "formularVersions")
@NamedQueries({
	@NamedQuery(name = "FormularVersion.findAll", query = "SELECT f FROM FormularVersion f"),
    @NamedQuery(name = "FormularVersion.searchByName", query = "SELECT f FROM FormularVersion f WHERE LOWER(f.version) = LOWER(:version)"),
    @NamedQuery(name = "FormularVersion.searchFormularVersion", query = "SELECT fv FROM FormularVersion fv LEFT JOIN FETCH fv.formular WHERE LOWER(fv.version) = LOWER(:version) AND fv.formular.id = :id")
})
public class FormularVersion implements Serializable {
	
    private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String version;
    
    @OneToMany( targetEntity=FormularFieldVersion.class, cascade = CascadeType.ALL, mappedBy = "formularVersion" )
    private List<FormularFieldVersion> fields;
    
    @ManyToOne
    @JoinColumn(name = "formular_id")
    private Formular formular;
	
    public Long getId() {
        return id;
    }
	
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getVersion() {
    	return version;
    }
    
    public void setVersion(String version) {
    	this.version = version;
    }
    
    public List<FormularFieldVersion> getFields() {
    	return fields;
    }
    
    public void setFields(List<FormularFieldVersion> fields) {
    	this.fields = fields;
    }
    
    public Formular getFormular() {
    	return formular;
    }
    
    public void setFormular(Formular formular) {
    	this.formular = formular;
    }
}