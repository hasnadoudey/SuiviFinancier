package tn.cni.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import tn.cni.commons.domain.BaseEntity;

@Entity
@Table(name = "compte", schema = "cniproject")
public class Compte extends BaseEntity {

	private static final long serialVersionUID = -2061068799637877234L;
	
	private String type;
	private String numero;
	private String banque;
	private String devise;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBanque() {
		return banque;
	}

	public void setBanque(String banque) {
		this.banque = banque;
	}

	public String getDevise() {
		return devise;
	}

	public void setDevise(String devise) {
		this.devise = devise;
	}

	public Compte() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	
}
