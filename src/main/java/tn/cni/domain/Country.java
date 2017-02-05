package tn.cni.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import tn.cni.commons.domain.BaseEntity;


@Table(name = "country", schema = "cniproject")
@Entity
public class Country extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private String description;

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}


}
