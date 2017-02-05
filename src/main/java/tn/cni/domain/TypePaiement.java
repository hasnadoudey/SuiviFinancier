package tn.cni.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import tn.cni.commons.domain.BaseEntity;

@Entity
@Table(name="typePaiement")
public class TypePaiement extends BaseEntity {

	
	private static final long serialVersionUID = 3572982959556104867L;

	private String name;
	public TypePaiement() {
		// TODO Auto-generated constructor stub
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
