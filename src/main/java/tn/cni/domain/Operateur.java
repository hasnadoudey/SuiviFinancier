package tn.cni.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;






@Entity
@Table(name = "operateur", schema = "cniproject")
public class Operateur implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private static final long serialVersionUID = 1L;
	private Operateur selectedOperateur;
	private String designation;
	private String responsable_oper;
	private String ugcp;
	private String projetList;
	private String operation;
	
	@Column(name="projet_id")
	private Long projetId;

	
	@ManyToOne
	@JoinColumn(name="projet_id",referencedColumnName="id",insertable=false,updatable=false)
	private Projet projet;

	public Operateur() {
		
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getResponsable_oper() {
		return responsable_oper;
	}

	public void setResponsable_oper(String responsable_oper) {
		this.responsable_oper = responsable_oper;
	}

	public String getUgcp() {
		return ugcp;
	}

	public void setUgcp(String ugcp) {
		this.ugcp = ugcp;
	}

	

	

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getOperation() {
		return operation;
	}

	public void setProjetId(Long projetId) {
		this.projetId = projetId;
	}

	public Long getProjetId() {
		return projetId;
	}



	public void setProjetList(String projetList) {
		this.projetList = projetList;
	}

	public String getProjetList() {
		return projetList;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setSelectedOperateur(Operateur selectedOperateur) {
		this.selectedOperateur = selectedOperateur;
	}

	public Operateur getSelectedOperateur() {
		return selectedOperateur;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	


	
	
	
	

}
