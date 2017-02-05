package tn.cni.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import tn.cni.commons.domain.BaseEntity;

@Entity
@Table(name="etatPaiement")
public class EtatPaiement extends BaseEntity {

	
	private static final long serialVersionUID = 2734764923678033586L;
	private String name;
	
	public EtatPaiement() {
	
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
