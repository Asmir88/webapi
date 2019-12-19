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
@Table(name = "radioButtonFieldVersions")
@NamedQueries({
    @NamedQuery(name = "RadioButtonFieldVersion.findAll", query = "SELECT t FROM RadioButtonFieldVersion t")
})
public class RadioButtonFieldVersion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    
    @ManyToOne
	@JoinColumn(name="formularFieldVersion_id")
	private FormularFieldVersion formularFieldVersion;

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
    
    public FormularFieldVersion getFormularFieldVersion() {
    	return formularFieldVersion;
    }
    
    public void setFormularFieldVersion(FormularFieldVersion formularFieldVersion) {
    	this.formularFieldVersion = formularFieldVersion;
    }
}