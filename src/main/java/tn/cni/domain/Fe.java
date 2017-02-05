package tn.cni.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import tn.cni.commons.domain.BaseEntity;

@Table(name="fe",schema="cniproject")
@Entity
public class Fe extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	private String feList;
	private String designation;
	private String reference;
	private String montant;
	private String monnaie;
	private String taux_change;
	private String mnt_actualise;
	private String bailleur;
	private String loi;
	private Date date_loi;
	private Date date_signature;
	private Date date_entree;
	private Date date_entree_Vigueur;
	private Date date_cloture;
	private Date date_cloture_Actualise;
	private Date date_clo_Actualise;
	private Date date_dernier_engagement;
	private String commission_Engagement;
	private Date date_dernier_pai;
	private Date date_dernier_pai_Actualise;
	private Date date_dernier_engagement_Actualise;
	private String nature;
	private String taux_interet;
	private String duree_remboursement;
	private String delai_grace;
	private String monnaie_tnd;
	private Date date_actualisation;
	private String observation;
	private String operation;
	private String projetList;
	
	@Column(name="projet_id")
	private Long projetId;

	
	@ManyToOne
	@JoinColumn(name="projet_id",referencedColumnName="id",insertable=false,updatable=false)
	private Projet projet;


   
public Fe() {

}

	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getReference() {
		return reference;
	}


	public void setReference(String reference) {
		this.reference = reference;
	}


	public String getMontant() {
		return montant;
	}


	public void setMontant(String montant) {
		this.montant = montant;
	}


	public String getMonnaie() {
		return monnaie;
	}


	public void setMonnaie(String monnaie) {
		this.monnaie = monnaie;
	}


	

	public String getMnt_actualise() {
		return mnt_actualise;
	}


	public void setMnt_actualise(String mnt_actualise) {
		this.mnt_actualise = mnt_actualise;
	}


	public String getBailleur() {
		return bailleur;
	}


	public void setBailleur(String bailleur) {
		this.bailleur = bailleur;
	}


	public String getLoi() {
		return loi;
	}


	public void setLoi(String loi) {
		this.loi = loi;
	}


	public Date getDate_loi() {
		return date_loi;
	}


	public void setDate_loi(Date date_loi) {
		this.date_loi = date_loi;
	}


	public Date getDate_signature() {
		return date_signature;
	}


	public void setDate_signature(Date date_signature) {
		this.date_signature = date_signature;
	}


	public Date getDate_entree() {
		return date_entree;
	}


	public void setDate_entree(Date date_entree) {
		this.date_entree = date_entree;
	}


	public Date getDate_entree_Vigueur() {
		return date_entree_Vigueur;
	}


	public void setDate_entree_Vigueur(Date date_entree_Vigueur) {
		this.date_entree_Vigueur = date_entree_Vigueur;
	}


	public Date getDate_cloture() {
		return date_cloture;
	}


	public void setDate_cloture(Date date_cloture) {
		this.date_cloture = date_cloture;
	}


	public Date getDate_cloture_Actualise() {
		return date_cloture_Actualise;
	}


	public void setDate_cloture_Actualise(Date date_cloture_Actualise) {
		this.date_cloture_Actualise = date_cloture_Actualise;
	}


	public Date getDate_clo_Actualise() {
		return date_clo_Actualise;
	}


	public void setDate_clo_Actualise(Date date_clo_Actualise) {
		this.date_clo_Actualise = date_clo_Actualise;
	}


	public Date getDate_dernier_engagement() {
		return date_dernier_engagement;
	}


	public void setDate_dernier_engagement(Date date_dernier_engagement) {
		this.date_dernier_engagement = date_dernier_engagement;
	}


	public String getCommission_Engagement() {
		return commission_Engagement;
	}


	public void setCommission_Engagement(String commission_Engagement) {
		this.commission_Engagement = commission_Engagement;
	}


	public Date getDate_dernier_pai() {
		return date_dernier_pai;
	}


	public void setDate_dernier_pai(Date date_dernier_pai) {
		this.date_dernier_pai = date_dernier_pai;
	}


	public Date getDate_dernier_pai_Actualise() {
		return date_dernier_pai_Actualise;
	}


	public void setDate_dernier_pai_Actualise(Date date_dernier_pai_Actualise) {
		this.date_dernier_pai_Actualise = date_dernier_pai_Actualise;
	}


	public Date getDate_dernier_engagement_Actualise() {
		return date_dernier_engagement_Actualise;
	}


	public void setDate_dernier_engagement_Actualise(
			Date date_dernier_engagement_Actualise) {
		this.date_dernier_engagement_Actualise = date_dernier_engagement_Actualise;
	}


	public String getNature() {
		return nature;
	}


	public void setNature(String nature) {
		this.nature = nature;
	}


	public String getTaux_interet() {
		return taux_interet;
	}


	public void setTaux_interet(String taux_interet) {
		this.taux_interet = taux_interet;
	}


	public String getDuree_remboursement() {
		return duree_remboursement;
	}


	public void setDuree_remboursement(String duree_remboursement) {
		this.duree_remboursement = duree_remboursement;
	}





	public String getMonnaie_tnd() {
		return monnaie_tnd;
	}


	public void setMonnaie_tnd(String monnaie_tnd) {
		this.monnaie_tnd = monnaie_tnd;
	}


	public Date getDate_actualisation() {
		return date_actualisation;
	}


	public void setDate_actualisation(Date date_actualisation) {
		this.date_actualisation = date_actualisation;
	}


	public String getObservation() {
		return observation;
	}


	public void setObservation(String observation) {
		this.observation = observation;
	}


	public void setDelai_grace(String delai_grace) {
		this.delai_grace = delai_grace;
	}


	public String getDelai_grace() {
		return delai_grace;
	}


	public void setTaux_change(String taux_change) {
		this.taux_change = taux_change;
	}


	public String getTaux_change() {
		return taux_change;
	}


	public void setFeList(String feList) {
		this.feList = feList;
	}


	public String getFeList() {
		return feList;
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
