package tn.cni.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import tn.cni.commons.domain.BaseEntity;

@Entity
@Table(name = "nature", schema = "cniproject")
public class Nature extends BaseEntity {

	private static final long serialVersionUID = 4585896413808214551L;

	
	private String description;
	
	public Nature() {
		
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getDescription() {
		return description;
	}
}
