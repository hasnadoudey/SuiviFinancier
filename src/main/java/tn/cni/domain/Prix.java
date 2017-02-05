package tn.cni.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import tn.cni.commons.domain.BaseEntity;
@Entity
@Table(name = "prix", schema = "cniproject")
public class Prix extends BaseEntity{

	private static final long serialVersionUID = 5957369066396953672L;
	
	
	private String description;


	public void setDescription(String description) {
		this.description = description;
	}


	public String getDescription() {
		return description;
	}
	
	

}
