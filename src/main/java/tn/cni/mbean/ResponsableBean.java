package tn.cni.mbean;

import java.util.ArrayList;
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
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

import tn.cni.domain.Projet;
import tn.cni.domain.Responsable;
import tn.cni.services.ProjetService;
import tn.cni.services.ResponsableService;
import tn.cni.services.impl.ProjetServiceImpl;
import tn.cni.services.impl.ResponsableServiceImpl;

@ManagedBean(name="respBean")
@ViewScoped
public class ResponsableBean {
	


public Logger log = Logger.getLogger(ResponsableBean.class);
	
	
	
private String nom;
private String prenom;
private String fonction;
private String observation;
private String tel;
private String fax;
private String mail;


private Integer id;
private String operation;
	
	
	
	
	private List<Responsable> filteredResponsables;
	ResponsableService responsableService = new ResponsableServiceImpl();

	private List<Responsable> responsableList;
	private Responsable selectedResponsable;
	
	
	private Long projetId;
	ProjetService projetService = new ProjetServiceImpl();
	private List<SelectItem> projetList;
	
	
	
	
	
	
	
	
	
	
	public ResponsableBean() {
		
	}

	//################delete Responsable#################//
        @Secured("ROLE_ADMIN")
		public void deleteResponsable(ActionEvent e){
			log.info("delete Responsable");
			
			
			FacesContext fc = FacesContext.getCurrentInstance();
			Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
			log.info("id : "+param.get("id"));
			log.info("ref : "+param.get("ref"));
			
			
			responsableService.delete(selectedResponsable.getId());
		    responsableList=responsableService.findAll();
		}
		
		
	
		
	@PostConstruct
	public void init(){
		
		selectedResponsable = new Responsable();
	//################Preparer responsable list#################// 
		responsableList=responsableService.findAll();
		 //################op#################// 
	    projetList = new ArrayList<SelectItem>();
	    projetList.add(new SelectItem("","")) ;

		
		 List<Projet> projetServices = projetService.findAll();

	  for(Projet o:projetServices){
		  projetList.add(new SelectItem(o.getId(),o.getRef()));

	  }
		System.out.println("id : "+ getParam("id"));
		System.out.println("operation : "+ getParam("operation"));
		
		if("edit".equalsIgnoreCase(getParam("operation"))){
		
			
	    	   Long id = null;
	    	   Responsable f =null;
	    	   try{
	    		   id=Long.valueOf(getParam("id"));
	    	   }catch(Exception e){
	    		   
	    	   }
	    	   if(id!=null){
	    		   f  = responsableService.findById(null);
	    		   
	    		   if(f!=null){
	    	  

	    			   observation=f.getObservation();
	    	   		   fax=f.getFax();
	    	   		   fonction=f.getFonction();
	    	   		   mail=f.getMail();
	    	   		   nom=f.getNom();
	    	   		   prenom=f.getPrenom();
	    	   		   tel=f.getTel();
	    	   		
	    	   		
	    	   		
	    	   		
	    	   		
	    		   }
	    	   }
	    	   
	    	
	   		   
		}
		
		
	}
	//################add Responsable #################// 
	 public void addResponsable(ActionEvent e){
		
		
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
		log.info("id : "+param.get("id"));
		log.info("ref : "+param.get("ref"));
		
		Responsable responsable = null;		
		System.out.println("addResponsable : "+operation+"-"+id);
		 
		if("edit".equalsIgnoreCase(operation)){
			
			responsable  = responsableService.findById(id);
			
			System.out.println("edit");
		}else{
			responsable = new Responsable();
			
			System.out.println("new");
		}
		responsable.setFax(fax);
		responsable.setFonction(fonction);
		responsable.setMail(mail);
		responsable.setNom(nom);
		responsable.setObservation(observation);
		responsable.setPrenom(prenom);
		responsable.setTel(tel);
		responsable.setProjetId(projetId);
		
		responsableService.add(responsable);
			
			
		fax="";
		fonction="";
		mail="";
		nom="";
		observation="";
		
		prenom="";
		tel="";
	
	 }

	 public void update() {  
         this.responsableService.edit(this.selectedResponsable);
         
	   }
	
			
	
	  
		public String getParam(String name){
			FacesContext fc = FacesContext.getCurrentInstance();
			Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
			return params.get(name);
		}

		public void onResponsableRowSelect(SelectEvent event) {
			setSelectedResponsable((Responsable) event.getObject());
		}
   
		public void onResponsableRowUnselect(UnselectEvent event) {
			setSelectedResponsable(null);
		}

		public Logger getLog() {
			return log;
		}

		public void setLog(Logger log) {
			this.log = log;
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

	

		
		public String getOperation() {
			return operation;
		}

		public void setOperation(String operation) {
			this.operation = operation;
		}

		public List<Responsable> getFilteredResponsables() {
			return filteredResponsables;
		}

		public void setFilteredResponsables(List<Responsable> filteredResponsables) {
			this.filteredResponsables = filteredResponsables;
		}

		public ResponsableService getResponsableService() {
			return responsableService;
		}

		public void setResponsableService(ResponsableService responsableService) {
			this.responsableService = responsableService;
		}

		public List<Responsable> getResponsableList() {
			return responsableList;
		}

		public void setResponsableList(List<Responsable> responsableList) {
			this.responsableList = responsableList;
		}

		public Responsable getSelectedResponsable() {
			return selectedResponsable;
		}

		public void setSelectedResponsable(Responsable selectedResponsable) {
			this.selectedResponsable = selectedResponsable;
		}

		public void setProjetId(Long projetId) {
			this.projetId = projetId;
		}

		public Long getProjetId() {
			return projetId;
		}
		public List<SelectItem> getProjetList() {
			return projetList;
		}

		public void setProjetList(List<SelectItem> projetList) {
			this.projetList = projetList;
		}

		public ProjetService getProjetService() {
			return projetService;
		}

		public void setProjetService(ProjetService projetService) {
			this.projetService = projetService;
		}
		
			
}
