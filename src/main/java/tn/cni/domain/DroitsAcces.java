package tn.cni.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import tn.cni.commons.domain.BaseEntity;

@Table(name = "composante", schema = "cniproject")
@Entity
public class DroitsAcces extends BaseEntity{

	private static final long serialVersionUID = 2985455553576551030L;

	private String description;
	private String operation;

	
	
	
	public DroitsAcces() {
		
	}
	
	
	
	
	
	
	
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	
	
	
}
