package tn.cni.mbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import tn.cni.domain.Compte;
import tn.cni.domain.Devise;
import tn.cni.domain.EtatPaiement;
import tn.cni.domain.Facture;
import tn.cni.domain.Fournisseur;
import tn.cni.domain.Operateur;
import tn.cni.domain.Prix;
import tn.cni.domain.Projet;
import tn.cni.domain.Type;
import tn.cni.domain.TypePaiement;
import tn.cni.services.CompteService;
import tn.cni.services.DeviseService;
import tn.cni.services.EtatPaiementService;
import tn.cni.services.FactureService;
import tn.cni.services.FournisseurService;
import tn.cni.services.OperateurService;
import tn.cni.services.PrixService;
import tn.cni.services.ProjetService;
import tn.cni.services.TypePaiementService;
import tn.cni.services.impl.CompteServiceImpl;
import tn.cni.services.impl.DeviseServiceImpl;
import tn.cni.services.impl.EtatPaiementServiceImpl;
import tn.cni.services.impl.FactureServiceImpl;
import tn.cni.services.impl.FournisseurServiceImpl;
import tn.cni.services.impl.OperateurServiceImpl;
import tn.cni.services.impl.PrixServiceImlp;
import tn.cni.services.impl.ProjetServiceImpl;
import tn.cni.services.impl.TypePaiementServiceImpl;


@ManagedBean(name="factureBean")
@ViewScoped
public class FactureBean {
	public Logger log = Logger.getLogger(FactureBean.class);
	
	
	
	FournisseurService fournisseurService = new FournisseurServiceImpl();
	PrixService prixService = new PrixServiceImlp();
	DeviseService deviseService = new DeviseServiceImpl();
	OperateurService operateurService = new OperateurServiceImpl();
	FactureService factureService = new FactureServiceImpl();
	CompteService compteService = new CompteServiceImpl();
	EtatPaiementService etatPaiementService = new EtatPaiementServiceImpl();
	TypePaiementService typePaiementService = new TypePaiementServiceImpl();
	ProjetService projetService = new ProjetServiceImpl();
	
	
	private String operateur;
	
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
	
	private List<Facture> filteredFactures;
	private String refFact;
	
	private Facture selectedFacture;
	private String id;
	private String operation;
	
	
	private String compte_bud;
	private String mnt_fact_pay;
	private String num_vir;
	private Date pai_sur_tresr;
	private Type type_pai;
	private String fe_comp;
	private String reference;
	
	private Long projetId;
	private Long operateurId;
	private Long typeId;
	private Long fournisseurId;
	private Long deviseId;
	private Long prixId;
	
	private Long compteId;
	private Long etatPaiementId;
	private Long typePaiementId;
	
	
	private List<SelectItem> compteList;
	private List<SelectItem> etatPaiementList;
	private List<SelectItem> typePaiementList;
	private List<SelectItem> opList;
	private List<SelectItem> deviseList;
	private List<SelectItem> prixList;
	private List<Facture> factureList;
	private List<SelectItem> fournisseurList;
	private List<SelectItem> projetList;
	
	

	
	
	
	public FactureBean() {
		
	}
	//################delete Fe#################//
	public void deleteFacture(ActionEvent e){
		log.info("delete Fe");
		
		
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
		log.info("id : "+param.get("id"));
		log.info("ref : "+param.get("ref"));
		
		
		factureService.delete(selectedFacture.getId());
		factureList=factureService.findAll();
	}
	@PostConstruct
	    public void init(){
		
		 selectedFacture = new Facture();
		
	    factureList = factureService.findAll();

	  //################op#################// 
	    opList = new ArrayList<SelectItem>();
	    opList.add(new SelectItem("","")) ;

		
		 List<Operateur> listServices = operateurService.findAll();

	  for(Operateur o:listServices){
		  opList.add(new SelectItem(o.getId(),o.getDesignation()));

	  }
	  //################op#################// 
	    projetList = new ArrayList<SelectItem>();
	    projetList.add(new SelectItem("","")) ;

		
		 List<Projet> projetServices = projetService.findAll();

	  for(Projet o:projetServices){
		  projetList.add(new SelectItem(o.getId(),o.getRef()));

	  }
		//################devise #################// 
	  deviseList = new ArrayList<SelectItem>();
	  deviseList.add(new SelectItem("","")) ;

		
		 List<Devise> deviseServices = deviseService.findAll();

	  for(Devise d:deviseServices){
		  deviseList.add(new SelectItem(d.getId(),d.getDescription()));

	  }
		//################prix #################// 
	  prixList = new ArrayList<SelectItem>();
	  prixList.add(new SelectItem("","")) ;

		
		 List<Prix> prixServices = prixService.findAll();

	  for(Prix p:prixServices){
		  prixList.add(new SelectItem(p.getId(),p.getDescription()));

	  }
	//################four #################// 
	  fournisseurList = new ArrayList<SelectItem>();
	  fournisseurList.add(new SelectItem("","")) ;

		
		 List<Fournisseur> fournisseurServices = fournisseurService.findAll();

	  for(Fournisseur p:fournisseurServices){
		  fournisseurList.add(new SelectItem(p.getId(),p.getCompte()));

	  }
	  

	//################compte #################// 
	  compteList = new ArrayList<SelectItem>();
	  compteList.add(new SelectItem("","")) ;

		
		 List<Compte> compteServices = compteService.findAll();

	  for(Compte p:compteServices){
		  compteList.add(new SelectItem(p.getId(),p.getNumero()));

	  }
	//################etatPaiement #################// 
	  etatPaiementList = new ArrayList<SelectItem>();
	  etatPaiementList.add(new SelectItem("","")) ;

		
		 List<EtatPaiement> etatPaiementServices = etatPaiementService.findAll();

	  for(EtatPaiement p:etatPaiementServices){
		  etatPaiementList.add(new SelectItem(p.getId(),p.getName()));

	  }
	//################typePaiement #################// 
	  typePaiementList = new ArrayList<SelectItem>();
	  typePaiementList.add(new SelectItem("","")) ;

		
		 List<TypePaiement> typePaiementServices = typePaiementService.findAll();

	  for(TypePaiement p:typePaiementServices){
		  typePaiementList.add(new SelectItem(p.getId(),p.getName()));

	  }
	 }
	
	//################add fe #################// 
	 public void addFacture(ActionEvent e){
		
		
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
		log.info("id : "+param.get("id"));
		log.info("ref : "+param.get("ref"));
		
		Facture facture = null;
		System.out.println("addFacture : "+operation+"-"+id);
		 
		if("edit".equalsIgnoreCase(operation)){
			
			facture  = factureService.findById(new Long(id));
			
			System.out.println("edit");
		}else{
			facture = new Facture();
			System.out.println("new");
		}
		facture.setCompte_bud(compte_bud);
		facture.setDate_Envoi_DAF(date_Envoi_DAF);
		facture.setDate_Fact(date_Fact);
		facture.setDate_Recep(date_Recep);
		facture.setDate_Recep_Cellule_Resp(date_Recep_Cellule_Resp);
		facture.setDate_Recep_Comptable_Inter(date_Recep_Comptable_Inter);
		facture.setDate_Recep_Ordonnateur(date_Recep_Ordonnateur);
		facture.setFe_comp(fe_comp);
		facture.setMarche(marche);
		facture.setMnt_Fact_HT(mnt_Fact_HT);
		facture.setMnt_fact_pay(mnt_fact_pay);
		facture.setMnt_Fact_TTC(mnt_Fact_TTC);
		facture.setMnt_Ordonnance(mnt_Ordonnance);
		facture.setMnt_Payer(mnt_Payer);
		facture.setMonnaie_paiement(monnaie_paiement);
		facture.setNum_vir(num_vir);
		facture.setObservations(observations);
		facture.setOrdre_Fact(ordre_Fact);
		facture.setPai_sur_tresr(pai_sur_tresr);
		facture.setRef_Bordereau(ref_Bordereau);
		facture.setReference(reference);
		facture.setTaux_TVA(taux_TVA);
		facture.setTotal_AF(total_AF);
		facture.setTotal_Fin_Ext(total_Fin_Ext);
		facture.setTotal_Tresor(total_Tresor);
		facture.setDeviseId(deviseId);
		facture.setOperateurId(operateurId);
		facture.setPrixId(prixId);
		facture.setFournisseurId(fournisseurId);
		facture.setRefFact(refFact);
		facture.setCompteId(compteId);
		facture.setEtatPaiementId(etatPaiementId);
		facture.setTypePaiementId(typePaiementId);
		facture.setProjetId(projetId);
		
		factureService.add(facture);
		
		compte_bud=null;
		date_Envoi_DAF=null;
		date_Fact=null;
		date_Recep=null;
		date_Recep_Cellule_Resp=null;
		date_Recep_Comptable_Inter=null;
		date_Recep_Ordonnateur=null;
		fe_comp=null;
		marche=null;
		mnt_Fact_HT=null;
		mnt_fact_pay=null;
		mnt_Fact_TTC=null;
		mnt_Ordonnance=null;
		mnt_Payer=null;
		monnaie_paiement=null;
		num_vir=null;
		observations=null;
		ordre_Fact=null;
		pai_sur_tresr=null;
		ref_Bordereau=null;
		reference=null;
		taux_TVA=null;
		total_AF=null;
		total_Fin_Ext=null;
		total_Tresor=null;
		refFact="";
	
	 }

	
	  public void update() {  
          this.factureService.edit(this.selectedFacture);
          
	   }
	
	  
		public FournisseurService getFournisseurService() {
		return fournisseurService;
	}
	public void setFournisseurService(FournisseurService fournisseurService) {
		this.fournisseurService = fournisseurService;
	}
	public PrixService getPrixService() {
		return prixService;
	}
	public void setPrixService(PrixService prixService) {
		this.prixService = prixService;
	}
	public DeviseService getDeviseService() {
		return deviseService;
	}
	public void setDeviseService(DeviseService deviseService) {
		this.deviseService = deviseService;
	}
	public FactureService getFactureService() {
		return factureService;
	}
	public void setFactureService(FactureService factureService) {
		this.factureService = factureService;
	}
	public CompteService getCompteService() {
		return compteService;
	}
	public void setCompteService(CompteService compteService) {
		this.compteService = compteService;
	}
	public EtatPaiementService getEtatPaiementService() {
		return etatPaiementService;
	}
	public void setEtatPaiementService(EtatPaiementService etatPaiementService) {
		this.etatPaiementService = etatPaiementService;
	}
	public TypePaiementService getTypePaiementService() {
		return typePaiementService;
	}
	public void setTypePaiementService(TypePaiementService typePaiementService) {
		this.typePaiementService = typePaiementService;
	}
		public String getParam(String name){
			FacesContext fc = FacesContext.getCurrentInstance();
			Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
			return params.get(name);
		}

		public void onFactureRowSelect(SelectEvent event) {
	        setSelectedFacture((Facture) event.getObject());
	    }
		   
		   public void onFactureRowUnselect(UnselectEvent event) {
		        setSelectedFacture(null);
		    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void setOpList(List<SelectItem> opList) {
		this.opList = opList;
	}

	public List<SelectItem> getOpList() {
		return opList;
	}


	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}


	public String getOperateur() {
		return operateur;
	}


	public OperateurService getOperateurService() {
		return operateurService;
	}


	public void setOperateurService(OperateurService operateurService) {
		this.operateurService = operateurService;
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


	



	public String getMarche() {
		return marche;
	}


	public void setMarche(String marche) {
		this.marche = marche;
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


	public Long getFournisseurId() {
		return fournisseurId;
	}


	public void setFournisseurId(Long fournisseurId) {
		this.fournisseurId = fournisseurId;
	}


	public void setDeviseList(List<SelectItem> deviseList) {
		this.deviseList = deviseList;
	}


	public List<SelectItem> getDeviseList() {
		return deviseList;
	}


	public void setPrixList(List<SelectItem> prixList) {
		this.prixList = prixList;
	}


	public List<SelectItem> getPrixList() {
		return prixList;
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
	public void setRefFact(String refFact) {
		this.refFact = refFact;
	}





















































	public String getRefFact() {
		return refFact;
	}
	public void setFactureList(List<Facture> factureList) {
		this.factureList = factureList;
	}
	public List<Facture> getFactureList() {
		return factureList;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public void setDeviseId(Long deviseId) {
		this.deviseId = deviseId;
	}
	public Long getDeviseId() {
		return deviseId;
	}
	public void setOperateurId(Long operateurId) {
		this.operateurId = operateurId;
	}
	public Long getOperateurId() {
		return operateurId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setFournisseurList(List<SelectItem> fournisseurList) {
		this.fournisseurList = fournisseurList;
	}
	public List<SelectItem> getFournisseurList() {
		return fournisseurList;
	}
	public void setPrixId(Long prixId) {
		this.prixId = prixId;
	}
	public Long getPrixId() {
		return prixId;
	}
	public void setCompteId(Long compteId) {
		this.compteId = compteId;
	}
	public Long getCompteId() {
		return compteId;
	}

	public void setCompteList(List<SelectItem> compteList) {
		this.compteList = compteList;
	}
	public List<SelectItem> getCompteList() {
		return compteList;
	}
	public void setEtatPaiementList(List<SelectItem> etatPaiementList) {
		this.etatPaiementList = etatPaiementList;
	}
	public List<SelectItem> getEtatPaiementList() {
		return etatPaiementList;
	}
	public void setTypePaiementList(List<SelectItem> typePaiementList) {
		this.typePaiementList = typePaiementList;
	}
	public List<SelectItem> getTypePaiementList() {
		return typePaiementList;
	}
	public void setEtatPaiementId(Long etatPaiementId) {
		this.etatPaiementId = etatPaiementId;
	}
	public Long getEtatPaiementId() {
		return etatPaiementId;
	}
	public void setTypePaiementId(Long typePaiementId) {
		this.typePaiementId = typePaiementId;
	}
	public Long getTypePaiementId() {
		return typePaiementId;
	}
	public void setFilteredFactures(List<Facture> filteredFactures) {
		this.filteredFactures = filteredFactures;
	}
	public List<Facture> getFilteredFactures() {
		return filteredFactures;
	}
	public void setProjetList(List<SelectItem> projetList) {
		this.projetList = projetList;
	}
	public List<SelectItem> getProjetList() {
		return projetList;
	}
	public void setProjetId(Long projetId) {
		this.projetId = projetId;
	}
	public Long getProjetId() {
		return projetId;
	}


	public ProjetService getProjetService() {
		return projetService;
	}
	public void setProjetService(ProjetService projetService) {
		this.projetService = projetService;
	}





	
	
	
	

}
