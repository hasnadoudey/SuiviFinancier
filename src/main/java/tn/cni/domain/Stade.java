package tn.cni.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import tn.cni.commons.domain.BaseEntity;

@Entity
@Table(name = "stade", schema = "cniproject")
public class Stade extends BaseEntity {

	private static final long serialVersionUID = 2141187858845514757L;
	
	
	private String description;
	
	public Stade() {
	
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}



}
