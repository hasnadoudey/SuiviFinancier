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
@Table(name = "fournisseur", schema = "cniproject")
public class Fournisseur implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String matricule;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private String fax;
	private String nationalite;
	private String mail;
	private String pays; 
	private String fournisseur_Rep;
	private String taux;
	
	private Integer idOperateur;
	private String operation;
	private String compte;
	
	private String typeList;
	private String projetList;
	
	@Column(name="type_id")
	private Long typeId;
	
	
	@ManyToOne
	@JoinColumn(name="type_id",referencedColumnName="id",insertable=false,updatable=false)
	private Type type;
	
	
	

	@Column(name="country_id")
	private Long countryId;
	
	
	@ManyToOne
	@JoinColumn(name="country_id",referencedColumnName="id",insertable=false,updatable=false)
	private Country country;


	

	@Column(name="projet_id")
	private Long projetId;

	
	@ManyToOne
	@JoinColumn(name="projet_id",referencedColumnName="id",insertable=false,updatable=false)
	private Projet projet;


	
	
	
	
	public Fournisseur() {
		
		
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}



	


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public String getTelephone() {
		return telephone;
	}



	public void setFax(String fax) {
		this.fax = fax;
	}



	public String getFax() {
		return fax;
	}








	public void setPays(String pays) {
		this.pays = pays;
	}



	public String getPays() {
		return pays;
	}





	public void setTaux(String taux) {
		this.taux = taux;
	}



	public String getTaux() {
		return taux;
	}





	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}



	public String getNationalite() {
		return nationalite;
	}





	public void setFournisseur_Rep(String fournisseur_Rep) {
		this.fournisseur_Rep = fournisseur_Rep;
	}



	public String getFournisseur_Rep() {
		return fournisseur_Rep;
	}



	



	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}



	public String getMatricule() {
		return matricule;
	}



	public void setIdOperateur(Integer idOperateur) {
		this.idOperateur = idOperateur;
	}



	public Integer getIdOperateur() {
		return idOperateur;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getId() {
		return id;
	}



	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}



	public Long getTypeId() {
		return typeId;
	}



	public void setType(Type type) {
		this.type = type;
	}



	public Type getType() {
		return type;
	}



	public void setOperation(String operation) {
		this.operation = operation;
	}



	public String getOperation() {
		return operation;
	}



	public String getTypeList() {
		return typeList;
	}



	public void setTypeList(String typeList) {
		this.typeList = typeList;
	}



	public void setCompte(String compte) {
		this.compte = compte;
	}



	public String getCompte() {
		return compte;
	}






	public void setCountry(Country country) {
		this.country = country;
	}



	public Country getCountry() {
		return country;
	}



	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}



	public Long getCountryId() {
		return countryId;
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

	

	
	

	


