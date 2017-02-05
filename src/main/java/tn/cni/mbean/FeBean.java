package tn.cni.mbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import tn.cni.domain.Fe;
import tn.cni.domain.Projet;
import tn.cni.services.FeService;
import tn.cni.services.ProjetService;
import tn.cni.services.impl.FeServiceImpl;
import tn.cni.services.impl.ProjetServiceImpl;

@ManagedBean(name="feBean")
@SessionScoped
public class FeBean {
	
	public Logger log = Logger.getLogger(FeBean.class);
	
	
	
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
	
	
	private String id;
	private String operation;
	
	ProjetService projetService = new ProjetServiceImpl();
	private Long projetId;
	
	private List<SelectItem> projetList;
	private List<Fe> filteredFes;
	
	FeService feService = new FeServiceImpl();
	private List<Fe>feList;
	private Fe selectedFe;
	
	public FeBean() {
		
	}

	//################delete Fe#################//
		public void deleteFe(ActionEvent e){
			log.info("delete Fe");
			
			
			FacesContext fc = FacesContext.getCurrentInstance();
			Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
			log.info("id : "+param.get("id"));
			log.info("ref : "+param.get("ref"));
			
			
			feService.delete(selectedFe.getId());
		    feList=feService.findAll();
		}
	@PostConstruct
	public void init(){
		 selectedFe = new Fe();
		 
		//################op#################// 
		    projetList = new ArrayList<SelectItem>();
		    projetList.add(new SelectItem("","")) ;

			
			 List<Projet> projetServices = projetService.findAll();

		  for(Projet o:projetServices){
			  projetList.add(new SelectItem(o.getId(),o.getRef()));

		  }
	//################Preparer fe list#################// 
    
		feList= feService.findAll();
		System.out.println("id : "+ getParam("id"));
		System.out.println("operation : "+ getParam("operation"));
		
		
	  
	}
	//################add fe #################// 
	 public void addFe(ActionEvent e){
		
		
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
		log.info("id : "+param.get("id"));
		log.info("ref : "+param.get("ref"));
		
		Fe fe = null;
		System.out.println("addFe : "+operation+"-"+id);
		 
		if("edit".equalsIgnoreCase(operation)){
			
			fe  = feService.findById(new Long(id));
			
			System.out.println("edit");
		}else{
			fe = new Fe();
			System.out.println("new");
		}
			fe.setBailleur(bailleur);
			fe.setCommission_Engagement(commission_Engagement);
			fe.setDate_actualisation(date_actualisation);
			fe.setDate_clo_Actualise(date_clo_Actualise);
			fe.setDate_cloture(date_cloture);
			fe.setDate_cloture_Actualise(date_cloture_Actualise);
			fe.setDate_dernier_engagement(date_dernier_engagement);
			fe.setDate_dernier_engagement_Actualise(date_dernier_engagement_Actualise);
			fe.setDate_dernier_pai(date_dernier_pai);
			fe.setDate_dernier_pai_Actualise(date_dernier_pai_Actualise);
			fe.setDate_entree(date_entree);
			fe.setDate_entree_Vigueur(date_entree_Vigueur);
			fe.setDate_loi(date_loi);
			fe.setDate_loi(date_loi);
			fe.setDate_signature(date_signature);
			fe.setDelai_grace(delai_grace);
			fe.setDesignation(designation);
			fe.setDuree_remboursement(duree_remboursement);
			fe.setLoi(loi);
			fe.setMnt_actualise(mnt_actualise);
			fe.setMonnaie(monnaie);
			fe.setMonnaie_tnd(monnaie_tnd);
			fe.setMontant(montant);
			fe.setNature(nature);
			fe.setObservation(observation);
			fe.setReference(reference);
			fe.setTaux_change(taux_change);
			fe.setTaux_interet(taux_interet);
			fe.setProjetId(projetId);
			
			feService.add(fe);
			
			bailleur="";
			commission_Engagement="";
			delai_grace="";
			designation="";
			duree_remboursement="";
			loi="";
			mnt_actualise="";
			monnaie="";
			monnaie_tnd="";
			montant="";
			nature="";
			observation="";
			reference="";
			taux_change="";
			taux_interet="";
			date_actualisation=null;
			date_clo_Actualise=null;
			date_cloture=null;
			date_cloture_Actualise=null;
			date_dernier_engagement=null;
			date_dernier_engagement_Actualise=null;
			date_dernier_pai=null;
			date_dernier_pai_Actualise=null;
			date_entree=null;
			date_entree_Vigueur=null;
			date_loi=null;
			date_signature=null;
	
	 }
	  public ProjetService getProjetService() {
		return projetService;
	}

	public void setProjetService(ProjetService projetService) {
		this.projetService = projetService;
	}

	public void update() {  
          this.feService.edit(this.selectedFe);
          
	   }
	  
		public String getParam(String name){
			FacesContext fc = FacesContext.getCurrentInstance();
			Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
			return params.get(name);
		}

		public void onFeRowSelect(SelectEvent event) {
	        setSelectedFe((Fe) event.getObject());
	    }
		   
		   public void onFeRowUnselect(UnselectEvent event) {
		        setSelectedFe(null);
		    }
	
			public void setDesignation(String designation) {
				this.designation = designation;
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

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
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

			public String getDelai_grace() {
				return delai_grace;
			}

			public void setDelai_grace(String delai_grace) {
				this.delai_grace = delai_grace;
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

			public FeService getFeService() {
				return feService;
			}

			public void setFeService(FeService feService) {
				this.feService = feService;
			}


	public void setFeList(List<Fe> feList) {
		this.feList = feList;
	}

	public List<Fe> getFeList() {
		return feList;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getReference() {
		return reference;
	}

	public void setTaux_change(String taux_change) {
		this.taux_change = taux_change;
	}

	public String getTaux_change() {
		return taux_change;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getOperation() {
		return operation;
	}


	public void setSelectedFe(Fe selectedFe) {
		this.selectedFe = selectedFe;
	}

	public Fe getSelectedFe() {
		return selectedFe;
	}

	
	public String getDesignation() {
		return designation;
	}

	public void setFilteredFes(List<Fe> filteredFes) {
		this.filteredFes = filteredFes;
	}

	public List<Fe> getFilteredFes() {
		return filteredFes;
	}

	public void setProjetId(Long projetId) {
		this.projetId = projetId;
	}

	public Long getProjetId() {
		return projetId;
	}

	public void setProjetList(List<SelectItem> projetList) {
		this.projetList = projetList;
	}

	public List<SelectItem> getProjetList() {
		return projetList;
	}
}
