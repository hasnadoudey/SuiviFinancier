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

import tn.cni.domain.Etat;
import tn.cni.domain.Projet;
import tn.cni.services.EtatService;
import tn.cni.services.ProjetService;
import tn.cni.services.impl.EtatServiceImpl;
import tn.cni.services.impl.ProjetServiceImpl;

@ManagedBean(name="etatBean")
@ViewScoped
public class EtatBean  {
	public Logger log = Logger.getLogger(EtatBean.class);

	private static final long serialVersionUID = 8175869504404093114L;
	
	private String ref;
	private String mnt_initial;
	private String mnt_act;
	private Date dat_act;
	private Etat selectedEtat;
	private String operation;
	private Integer id;
	 private List<Etat> filteredEtats;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public EtatBean() {
		
	}
	 EtatService etatService = new EtatServiceImpl();
	
	 private List<Etat> filteredEtat;
	private List<Etat> etatList;
	
	private Long projetId;
	ProjetService projetService = new ProjetServiceImpl();
	private List<SelectItem> projetList;

	
	
	
	
	public ProjetService getProjetService() {
		return projetService;
	}
	public void setProjetService(ProjetService projetService) {
		this.projetService = projetService;
	}
	public List<SelectItem> getProjetList() {
		return projetList;
	}
	public void setProjetList(List<SelectItem> projetList) {
		this.projetList = projetList;
	}
	@PostConstruct
	public void init(){
		
		 selectedEtat = new Etat();
	
	 //################Preparer Projet list#################// 
    
	etatList = etatService.findAll();
	 //################Preparer Projet list#################// 
	
	System.out.println("id : "+ getParam("id"));
	System.out.println("operation : "+ getParam("operation"));
	
	if("edit".equalsIgnoreCase(getParam("operation"))){
	
    	   Long id = null;
    	   Etat etat =null;
    	   try{
    		   id=Long.valueOf(getParam("id"));
    	   }catch(Exception e){
    		   
    	   }
    	   if(id!=null){
    		   etat  = etatService.findById(getId());
    		   
    		   if(etat!=null){

    	   		   dat_act=etat.getDat_act();
    	   		   mnt_act=etat.getMnt_act();
    	   		   mnt_initial=etat.getMnt_initial();
    	   		   ref=etat.getRef();
    	   		   
    		   }
    	   }
    	   
    	
   		   
	}
	 //################op#################// 
    projetList = new ArrayList<SelectItem>();
    projetList.add(new SelectItem("","")) ;

	
	 List<Projet> projetServices = projetService.findAll();

  for(Projet o:projetServices){
	  projetList.add(new SelectItem(o.getId(),o.getRef()));

  }
    
	}
	
	//################add Etat#################//
	public void addEtat(ActionEvent e){
		
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
		log.info("id : "+param.get("id"));
		log.info("ref : "+param.get("ref"));
		
	
	
		
	
	 Etat etat = null;
		System.out.println("addEtat : " );
	 
	 
		if("edit".equalsIgnoreCase(operation)){
			
			etat  = etatService.findById(id);
			
			System.out.println("edit");
			
		}else{
			
			etat = new Etat();
			System.out.println("new");
		}
	    
		etat.setDat_act(dat_act);
		etat.setMnt_act(mnt_act);
		etat.setMnt_initial(mnt_initial);
		etat.setRef(ref);
		etat.setProjetId(projetId);
			etatService.add(etat);
	    ref="";
		dat_act=null;
		mnt_act=null;
		mnt_initial=null;
		operation="";
		

}
	
	
	
	//################delete Etat#################//
	public void deleteEtat(ActionEvent e){
		log.info("delete etat");
		
		
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
		log.info("id : "+param.get("id"));
		
	
		etatService.delete(selectedEtat.getId_etat());
		
		etatList=etatService.findAll();
	}

	
	public void update() {  
        this.etatService.edit(this.selectedEtat);
        
	   }
	      
	public String getParam(String name){
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get(name);
	}

	public void onEtatRowSelect(SelectEvent event) {
        setSelectedEtat((Etat) event.getObject());
    }
	   
	   public void onEtatRowUnselect(UnselectEvent event) {
	        setSelectedEtat(null);
	    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	




	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public Etat getSelectedEtat() {
		return selectedEtat;
	}
	
	


	   public void setSelectedEtat(Etat selectedEtat) {

	          this.selectedEtat = selectedEtat;
	      }
	

















































	public void setEtatList(List<Etat> etatList) {
		this.etatList = etatList;
	}





















































public String getMnt_initial() {
		return mnt_initial;
	}
	public void setMnt_initial(String mnt_initial) {
		this.mnt_initial = mnt_initial;
	}
	public String getMnt_act() {
		return mnt_act;
	}
	public void setMnt_act(String mnt_act) {
		this.mnt_act = mnt_act;
	}
public List<Etat> getEtatList() {
		return etatList;
	}


	public Date getDat_act() {
		return dat_act;
	}

	public void setDat_act(Date dat_act) {
		this.dat_act = dat_act;
	}


	public String getOperation() {
		return operation;
	}


	public void setOperation(String operation) {
		this.operation = operation;
	}



	public EtatService getEtatService() {
		return etatService;
	}
	public void setEtatService(EtatService etatService) {
		this.etatService = etatService;
	}
	public void setFilteredEtat(List<Etat> filteredEtat) {
		this.filteredEtat = filteredEtat;
	}
	public List<Etat> getFilteredEtat() {
		return filteredEtat;
	}
	public void setFilteredEtats(List<Etat> filteredEtats) {
		this.filteredEtats = filteredEtats;
	}
	public List<Etat> getFilteredEtats() {
		return filteredEtats;
	}
	public void setProjetId(Long projetId) {
		this.projetId = projetId;
	}
	public Long getProjetId() {
		return projetId;
	}

	
	
	
}


