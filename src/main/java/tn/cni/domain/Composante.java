package tn.cni.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import tn.cni.commons.domain.BaseEntity;

@Table(name = "composante", schema = "cniproject")
@Entity
public class Composante extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	
	private Integer parentComposanteId;
	private Integer code_comp;
	private String designation;
	private String ordre_aff;
	private Long cout_total;
	private Long cout_act;
	private Date date_debut_act;
	private Date date_fin_act;
	private Date date_actualisation;
	private Date date_debut;
	private Date date_fin;
	private String taux_rent_economique;
	private String categorie;
	private String ministère;
	private String structure;
	private String observation;
	private String type_decoupage;
	private Integer pereid;
	
	
	@Column(name="projet_id")
	private Long projetId;
	
	
	@ManyToOne
	@JoinColumn(name="projet_id",referencedColumnName="id",insertable=false,updatable=false)
	private Projet projet;
	
	
	
	@Column(name="stade_id")
	private Long stadeId;
	
	
	@ManyToOne
	@JoinColumn(name="stade_id",referencedColumnName="id",insertable=false,updatable=false)
	private Stade stade;
	
	
	@Column(name="ministere_id")
	private Long ministereId;
	
	
	@ManyToOne
	@JoinColumn(name="ministere_id",referencedColumnName="id",insertable=false,updatable=false)
	private Ministere ministere;
	
	@ManyToOne
    @JoinColumn(name="activite")
	private Composante activite;
	
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Fe> fes;
	
	
	
	
	public Composante() {
		
	}

	

	public Integer getParentComposanteId() {
		return parentComposanteId;
	}

	public void setParentComposanteId(Integer parentComposanteId) {
		this.parentComposanteId = parentComposanteId;
	}

	public Integer getCode_comp() {
		return code_comp;
	}

	public void setCode_comp(Integer code_comp) {
		this.code_comp = code_comp;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getOrdre_aff() {
		return ordre_aff;
	}

	public void setOrdre_aff(String ordre_aff) {
		this.ordre_aff = ordre_aff;
	}

	public Long getCout_total() {
		return cout_total;
	}

	public void setCout_total(Long cout_total) {
		this.cout_total = cout_total;
	}

	public Long getCout_act() {
		return cout_act;
	}

	public void setCout_act(Long cout_act) {
		this.cout_act = cout_act;
	}

	public Date getDate_debut_act() {
		return date_debut_act;
	}

	public void setDate_debut_act(Date date_debut_act) {
		this.date_debut_act = date_debut_act;
	}

	public Date getDate_fin_act() {
		return date_fin_act;
	}

	public void setDate_fin_act(Date date_fin_act) {
		this.date_fin_act = date_fin_act;
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

	

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	

	public Stade getStade() {
		return stade;
	}



	public void setStade(Stade stade) {
		this.stade = stade;
	}



	public String getMinistère() {
		return ministère;
	}

	public void setMinistère(String ministère) {
		this.ministère = ministère;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getType_decoupage() {
		return type_decoupage;
	}

	public void setType_decoupage(String type_decoupage) {
		this.type_decoupage = type_decoupage;
	}

	public Integer getPereid() {
		return pereid;
	}

	public void setPereid(Integer pereid) {
		this.pereid = pereid;
	}

	public Long getProjetId() {
		return projetId;
	}

	public void setProjetId(Long projetId) {
		this.projetId = projetId;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Composante getActivite() {
		return activite;
	}

	public void setActivite(Composante activite) {
		this.activite = activite;
	}

	public List<Fe> getFes() {
		return fes;
	}

	public void setFes(List<Fe> fes) {
		this.fes = fes;
	}

	



	public void setStadeId(Long stadeId) {
		this.stadeId = stadeId;
	}



	public Long getStadeId() {
		return stadeId;
	}



	public void setMinistereId(Long ministereId) {
		this.ministereId = ministereId;
	}



	public Long getMinistereId() {
		return ministereId;
	}



	public void setMinistere(Ministere ministere) {
		this.ministere = ministere;
	}



	public Ministere getMinistere() {
		return ministere;
	}



	public void setTaux_rent_economique(String taux_rent_economique) {
		this.taux_rent_economique = taux_rent_economique;
	}



	public String getTaux_rent_economique() {
		return taux_rent_economique;
	}



	public void setDate_actualisation(Date date_actualisation) {
		this.date_actualisation = date_actualisation;
	}



	public Date getDate_actualisation() {
		return date_actualisation;
	}
	

	
	
}
