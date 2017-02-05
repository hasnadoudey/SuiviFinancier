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
@Table(name = "responsable", schema = "cniproject")
public class Responsable implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String nom;
	private String prenom;
	private String fonction;
	private String observation;
	private String tel;
	private String fax;
	private String mail;
	private String projetList;
	
	
	
	@Column(name="projet_id")
	private Long projetId;

	
	@ManyToOne
	@JoinColumn(name="projet_id",referencedColumnName="id",insertable=false,updatable=false)
	private Projet projet;
	
	
	public Responsable() {
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setProjetId(Long projetId) {
		this.projetId = projetId;
	}

	public Long getProjetId() {
		return projetId;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjetList(String projetList) {
		this.projetList = projetList;
	}

	public String getProjetList() {
		return projetList;
	}

	

	


	

}
