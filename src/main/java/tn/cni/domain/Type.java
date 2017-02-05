package tn.cni.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import tn.cni.commons.domain.BaseEntity;






@Entity
@Table(name="type")
public class Type extends BaseEntity{


	private static final long serialVersionUID = 1L;
	
	private String name;
	
	
	public Type() {
		
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}
