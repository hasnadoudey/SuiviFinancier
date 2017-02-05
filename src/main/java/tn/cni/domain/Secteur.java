package tn.cni.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import tn.cni.commons.domain.BaseEntity;

@Entity
@Table(name = "secteur", schema = "cniproject")
public class Secteur extends BaseEntity {

	private static final long serialVersionUID = 2056492240597894467L;

	private String description;
	
	public Secteur() {
		
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	

	
	
	
}
