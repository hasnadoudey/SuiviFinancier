package tn.cni.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import tn.cni.commons.domain.BaseEntity;

@Entity
@Table(name = "devise", schema = "cniproject")
public class Devise extends BaseEntity {

	private static final long serialVersionUID = -6755421733904804583L;
	
	
	private String description;
	
	
	public Devise() {
		


	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
