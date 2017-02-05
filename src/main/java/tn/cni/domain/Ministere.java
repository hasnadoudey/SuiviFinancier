package tn.cni.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import tn.cni.commons.domain.BaseEntity;
@Table(name="ministere",schema="cniproject")
@Entity
public class Ministere extends BaseEntity {
	
	
	private static final long serialVersionUID = -8669654841697650469L;
	
	
	
	private String description;
	
	public Ministere() {
		// TODO Auto-generated constructor stub
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
