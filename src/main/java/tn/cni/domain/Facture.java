

package tn.cni.domain;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import tn.cni.commons.domain.BaseEntity;




@Entity
@Table(name = "facture", schema = "cniproject")
public class Facture extends BaseEntity{


	private static final long serialVersionUID = 1L;
	
	private String ref_Fact;
	private String ref_Bordereau;
	private Date date_Fact;
	private Date date_Recep;
	private Date date_Recep_Cellule_Resp;
	private Date date_Recep_Comptable_Inter;
	private Date date_Envoi_DAF;
	private Date date_Recep_Ordonnateur;
	private String monnaie_paiement;
	private String type_Prix;
	private String mnt_Fact_TTC;
	private String taux_TVA;
	private String mnt_Fact_HT;
	private String mnt_Ordonnance;
	private String total_Fin_Ext;
	private String total_Tresor;
	private String total_AF;
	private String marche;
	private String ordre_Fact;
	private String mnt_Payer;
	private String observations;
	private Facture selectedFacture;
	private String opList;
	private String deviseList;
	private String compte_bud;
	private String mnt_fact_pay;
	private String num_vir;
	private Date pai_sur_tresr;
	private Type type_pai;
	private String fe_comp;
	private String reference;
	private TypePaiement type_dec;
	private String refFact;
	private String prixList;
	private String fournisseurList;
	private String etatPaiementList;
	private String typePaiementList;
	private String projetList;
	@Column(name="type_id")
	private Long typeId;
	
	@Column(name="operateur_id")
	private Long operateurId;
	
	@Column(name="fournisseur_id")
	private Long fournisseurId;
	
	@Column(name="devise_id")
	private Long deviseId;
	
	@Column(name="prix_id")
	private Long prixId;
	
	@Column(name="typePaiement_id")
	private Long typePaiementId;
	
	@Column(name="etatPaiement_id")
	private Long etatPaiementId;
	
	@Column(name="compte_id")
	private Long compteId;
	
	@Column(name="projet_id")
	private Long projetId;
	
	@ManyToOne
	@JoinColumn(name="typePaiement_id",referencedColumnName="id",insertable=false,updatable=false)
	private TypePaiement typePaiement;
	
	@ManyToOne
	@JoinColumn(name="etatPaiement_id",referencedColumnName="id",insertable=false,updatable=false)
	private EtatPaiement etatPaiement;
	
	@ManyToOne
	@JoinColumn(name="compte_id",referencedColumnName="id",insertable=false,updatable=false)
	private Compte compte;
	
	
	@ManyToOne
	@JoinColumn(name="projet_id",referencedColumnName="id",insertable=false,updatable=false)
	private Projet projet;
	
	@ManyToOne
	@JoinColumn(name="type_id",referencedColumnName="id",insertable=false,updatable=false)
	private Type type;
	
	@ManyToOne
	@JoinColumn(name="operateur_id",referencedColumnName="id",insertable=false,updatable=false)
	private Operateur operateur;
	
	@ManyToOne
	@JoinColumn(name="devise_id",referencedColumnName="id",insertable=false,updatable=false)
	private Devise devise;
	
	@ManyToOne
	@JoinColumn(name="fournisseur_id",referencedColumnName="id",insertable=false,updatable=false)
	private Fournisseur fournisseur;
	
	@ManyToOne
	@JoinColumn(name="prix_id",referencedColumnName="id",insertable=false,updatable=false)
	private Prix prix;
	
	
	


	public Facture() {
		
	
	}

	


	public Date getDate_Fact() {
		return date_Fact;
	}





	public void setDate_Fact(Date date_Fact) {
		this.date_Fact = date_Fact;
	}





	public Date getDate_Recep() {
		return date_Recep;
	}





	public void setDate_Recep(Date date_Recep) {
		this.date_Recep = date_Recep;
	}





	public Date getDate_Recep_Cellule_Resp() {
		return date_Recep_Cellule_Resp;
	}





	public void setDate_Recep_Cellule_Resp(Date date_Recep_Cellule_Resp) {
		this.date_Recep_Cellule_Resp = date_Recep_Cellule_Resp;
	}





	public Date getDate_Recep_Comptable_Inter() {
		return date_Recep_Comptable_Inter;
	}





	public void setDate_Recep_Comptable_Inter(Date date_Recep_Comptable_Inter) {
		this.date_Recep_Comptable_Inter = date_Recep_Comptable_Inter;
	}





	public Date getDate_Envoi_DAF() {
		return date_Envoi_DAF;
	}





	public void setDate_Envoi_DAF(Date date_Envoi_DAF) {
		this.date_Envoi_DAF = date_Envoi_DAF;
	}





	public Date getDate_Recep_Ordonnateur() {
		return date_Recep_Ordonnateur;
	}





	public void setDate_Recep_Ordonnateur(Date date_Recep_Ordonnateur) {
		this.date_Recep_Ordonnateur = date_Recep_Ordonnateur;
	}





	public String getMonnaie_paiement() {
		return monnaie_paiement;
	}





	public void setMonnaie_paiement(String monnaie_paiement) {
		this.monnaie_paiement = monnaie_paiement;
	}





	public String getType_Prix() {
		return type_Prix;
	}





	public void setType_Prix(String type_Prix) {
		this.type_Prix = type_Prix;
	}





	



	public String getMarche() {
		return marche;
	}





	public void setMarche(String marche) {
		this.marche = marche;
	}










	public String getRef_Fact() {
		return ref_Fact;
	}




	public void setRef_Fact(String ref_Fact) {
		this.ref_Fact = ref_Fact;
	}




	public String getRef_Bordereau() {
		return ref_Bordereau;
	}




	public void setRef_Bordereau(String ref_Bordereau) {
		this.ref_Bordereau = ref_Bordereau;
	}




	public String getMnt_Fact_TTC() {
		return mnt_Fact_TTC;
	}




	public void setMnt_Fact_TTC(String mnt_Fact_TTC) {
		this.mnt_Fact_TTC = mnt_Fact_TTC;
	}




	public String getTaux_TVA() {
		return taux_TVA;
	}




	public void setTaux_TVA(String taux_TVA) {
		this.taux_TVA = taux_TVA;
	}




	public String getMnt_Fact_HT() {
		return mnt_Fact_HT;
	}




	public void setMnt_Fact_HT(String mnt_Fact_HT) {
		this.mnt_Fact_HT = mnt_Fact_HT;
	}




	public String getMnt_Ordonnance() {
		return mnt_Ordonnance;
	}




	public void setMnt_Ordonnance(String mnt_Ordonnance) {
		this.mnt_Ordonnance = mnt_Ordonnance;
	}




	public String getTotal_Fin_Ext() {
		return total_Fin_Ext;
	}




	public void setTotal_Fin_Ext(String total_Fin_Ext) {
		this.total_Fin_Ext = total_Fin_Ext;
	}




	public String getTotal_Tresor() {
		return total_Tresor;
	}




	public void setTotal_Tresor(String total_Tresor) {
		this.total_Tresor = total_Tresor;
	}




	public String getTotal_AF() {
		return total_AF;
	}




	public void setTotal_AF(String total_AF) {
		this.total_AF = total_AF;
	}




	public String getOrdre_Fact() {
		return ordre_Fact;
	}




	public void setOrdre_Fact(String ordre_Fact) {
		this.ordre_Fact = ordre_Fact;
	}




	public String getMnt_Payer() {
		return mnt_Payer;
	}




	public void setMnt_Payer(String mnt_Payer) {
		this.mnt_Payer = mnt_Payer;
	}




	public String getObservations() {
		return observations;
	}





	public void setObservations(String observations) {
		this.observations = observations;
	}





	public Facture getSelectedFacture() {
		return selectedFacture;
	}





	public void setSelectedFacture(Facture selectedFacture) {
		this.selectedFacture = selectedFacture;
	}





	public String getOpList() {
		return opList;
	}





	public void setOpList(String opList) {
		this.opList = opList;
	}





	public String getDeviseList() {
		return deviseList;
	}





	public void setDeviseList(String deviseList) {
		this.deviseList = deviseList;
	}





	public String getCompte_bud() {
		return compte_bud;
	}





	public void setCompte_bud(String compte_bud) {
		this.compte_bud = compte_bud;
	}





	public String getMnt_fact_pay() {
		return mnt_fact_pay;
	}





	public void setMnt_fact_pay(String mnt_fact_pay) {
		this.mnt_fact_pay = mnt_fact_pay;
	}





	public String getNum_vir() {
		return num_vir;
	}





	public void setNum_vir(String num_vir) {
		this.num_vir = num_vir;
	}





	public Date getPai_sur_tresr() {
		return pai_sur_tresr;
	}





	public void setPai_sur_tresr(Date pai_sur_tresr) {
		this.pai_sur_tresr = pai_sur_tresr;
	}





	public Type getType_pai() {
		return type_pai;
	}





	public void setType_pai(Type type_pai) {
		this.type_pai = type_pai;
	}





	public String getFe_comp() {
		return fe_comp;
	}





	public void setFe_comp(String fe_comp) {
		this.fe_comp = fe_comp;
	}





	public String getReference() {
		return reference;
	}





	public void setReference(String reference) {
		this.reference = reference;
	}





	public TypePaiement getType_dec() {
		return type_dec;
	}





	public void setType_dec(TypePaiement type_dec) {
		this.type_dec = type_dec;
	}





	public String getRefFact() {
		return refFact;
	}





	public void setRefFact(String refFact) {
		this.refFact = refFact;
	}





	public Long getTypeId() {
		return typeId;
	}





	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}





	public Long getOperateurId() {
		return operateurId;
	}





	public void setOperateurId(Long operateurId) {
		this.operateurId = operateurId;
	}





	public Long getFournisseurId() {
		return fournisseurId;
	}





	public void setFournisseurId(Long fournisseurId) {
		this.fournisseurId = fournisseurId;
	}





	public Long getDeviseId() {
		return deviseId;
	}





	public void setDeviseId(Long deviseId) {
		this.deviseId = deviseId;
	}





	public Long getPrixId() {
		return prixId;
	}





	public void setPrixId(Long prixId) {
		this.prixId = prixId;
	}





	public Type getType() {
		return type;
	}





	public void setType(Type type) {
		this.type = type;
	}





	public Operateur getOperateur() {
		return operateur;
	}





	public void setOperateur(Operateur operateur) {
		this.operateur = operateur;
	}





	public Devise getDevise() {
		return devise;
	}





	public void setDevise(Devise devise) {
		this.devise = devise;
	}





	
	public Fournisseur getFournisseur() {
		return fournisseur;
	}





	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}





	public Prix getPrix() {
		return prix;
	}





	public void setPrix(Prix prix) {
		this.prix = prix;
	}





	public void setTypePaiementId(Long typePaiementId) {
		this.typePaiementId = typePaiementId;
	}





	public Long getTypePaiementId() {
		return typePaiementId;
	}





	public void setEtatPaiementId(Long etatPaiementId) {
		this.etatPaiementId = etatPaiementId;
	}





	public Long getEtatPaiementId() {
		return etatPaiementId;
	}





	public void setCompteId(Long compteId) {
		this.compteId = compteId;
	}





	public Long getCompteId() {
		return compteId;
	}





	public void setTypePaiement(TypePaiement typePaiement) {
		this.typePaiement = typePaiement;
	}





	public TypePaiement getTypePaiement() {
		return typePaiement;
	}





	public void setEtatPaiement(EtatPaiement etatPaiement) {
		this.etatPaiement = etatPaiement;
	}





	public EtatPaiement getEtatPaiement() {
		return etatPaiement;
	}





	public void setCompte(Compte compte) {
		this.compte = compte;
	}





	public Compte getCompte() {
		return compte;
	}





	public void setPrixList(String prixList) {
		this.prixList = prixList;
	}





	public String getPrixList() {
		return prixList;
	}





	public void setFournisseurList(String fournisseurList) {
		this.fournisseurList = fournisseurList;
	}





	public String getFournisseurList() {
		return fournisseurList;
	}





	





	public void setTypePaiementList(String typePaiementList) {
		this.typePaiementList = typePaiementList;
	}





	public String getTypePaiementList() {
		return typePaiementList;
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

	public void setEtatPaiementList(String etatPaiementList) {
		this.etatPaiementList = etatPaiementList;
	}

	public String getEtatPaiementList() {
		return etatPaiementList;
	}





	

	
	
	
	
	
}
