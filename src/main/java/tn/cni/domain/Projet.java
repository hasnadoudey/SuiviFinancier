package tn.cni.domain;







import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="projet", schema = "cniproject")
public class Projet implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	private String ref;
	private String intitule;
	private String description;
	private String maitre_ouvrage;
	private String maitre_oeuvre;
	private String taux_rent_economique;
	private String taux_rent_interne;
	private float cout;
	private String cout_actualise;
	private Date date_act_cout;
	private Date date_debut;
	private Date date_fin;
	private Date date_fin_actualise;
	private String observations;
	private String deviseList;
	private String stadeList;
	private String secteurList;
	
	
	
	
	
	@Column(name="stade_id")
	private Long stadeId;
	
	@Column(name="secteur_id")
	private Long secteurId;
	
	@Column(name="nature_id")
	private Long natureId;
	
	
	
	@ManyToOne
	@JoinColumn(name="secteur_id",referencedColumnName="id",insertable=false,updatable=false)
	private Secteur secteur;
	
	@ManyToOne
	@JoinColumn(name="stade_id",referencedColumnName="id",insertable=false,updatable=false)
	private Stade stade;
	

	
	
	
	
public Projet() {
	
}


public String getRef() {
	return ref;
}


public void setRef(String ref) {
	this.ref = ref;
}


public String getIntitule() {
	return intitule;
}


public void setIntitule(String intitule) {
	this.intitule = intitule;
}





public String getMaitre_ouvrage() {
	return maitre_ouvrage;
}


public void setMaitre_ouvrage(String maitre_ouvrage) {
	this.maitre_ouvrage = maitre_ouvrage;
}


public String getMaitre_oeuvre() {
	return maitre_oeuvre;
}


public void setMaitre_oeuvre(String maitre_oeuvre) {
	this.maitre_oeuvre = maitre_oeuvre;
}







public String getTaux_rent_economique() {
	return taux_rent_economique;
}


public void setTaux_rent_economique(String taux_rent_economique) {
	this.taux_rent_economique = taux_rent_economique;
}


public String getTaux_rent_interne() {
	return taux_rent_interne;
}


public void setTaux_rent_interne(String taux_rent_interne) {
	this.taux_rent_interne = taux_rent_interne;
}




public float getCout() {
	return cout;
}


public void setCout(float cout) {
	this.cout = cout;
}


public String getCout_actualise() {
	return cout_actualise;
}


public void setCout_actualise(String cout_actualise) {
	this.cout_actualise = cout_actualise;
}


public Date getDate_act_cout() {
	return date_act_cout;
}


public void setDate_act_cout(Date date_act_cout) {
	this.date_act_cout = date_act_cout;
}


public Date getDate_debut() {
	return date_debut;
}


public void setDate_debut(Date date_debut) {
	this.date_debut = date_debut;
}


public Date getDate_fin() {
	return date_fin;
}


public void setDate_fin(Date date_fin) {
	this.date_fin = date_fin;
}


public Date getDate_fin_actualise() {
	return date_fin_actualise;
}


public void setDate_fin_actualise(Date date_fin_actualise) {
	this.date_fin_actualise = date_fin_actualise;
}










public Secteur getSecteur() {
	return secteur;
}


public void setSecteur(Secteur secteur) {
	this.secteur = secteur;
}


public Stade getStade() {
	return stade;
}


public void setStade(Stade stade) {
	this.stade = stade;
}





public void setObservations(String observations) {
	this.observations = observations;
}


public String getObservations() {
	return observations;
}


public void setDescription(String description) {
	this.description = description;
}


public String getDescription() {
	return description;
}




public void setId(Long id) {
	this.id = id;
}


public Long getId() {
	return id;
}




public void setNatureId(Long natureId) {
	this.natureId = natureId;
}


public Long getNatureId() {
	return natureId;
}





public void setStadeId(Long stadeId) {
	this.stadeId = stadeId;
}


public Long getStadeId() {
	return stadeId;
}


public void setSecteurId(Long secteurId) {
	this.secteurId = secteurId;
}


public Long getSecteurId() {
	return secteurId;
}






public void setDeviseList(String deviseList) {
	this.deviseList = deviseList;
}


public String getDeviseList() {
	return deviseList;
}


public void setStadeList(String stadeList) {
	this.stadeList = stadeList;
}


public String getStadeList() {
	return stadeList;
}


public void setSecteurList(String secteurList) {
	this.secteurList = secteurList;
}


public String getSecteurList() {
	return secteurList;
}









	
}