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

import tn.cni.domain.Operateur;
import tn.cni.domain.Projet;
import tn.cni.services.OperateurService;
import tn.cni.services.ProjetService;
import tn.cni.services.impl.OperateurServiceImpl;
import tn.cni.services.impl.ProjetServiceImpl;

@ManagedBean(name="operateurBean")
@ViewScoped
public class OperateurBean {
	

	private static final long serialVersionUID = -1036253510118753645L;


	public Logger log = Logger.getLogger(OperateurBean.class);

	private String ugcp;
	private String designation;
	private String responsable_oper;

	private Operateur selectedOperateur;
	
	private String projet;
	private String operation;
	private Integer id;
	
	private List<Operateur> filteredOperateurs;
	
	
	private List<Operateur> operateurList;
	

	OperateurService operateurService = new OperateurServiceImpl();
	
	
	private Long projetId;
	ProjetService projetService = new ProjetServiceImpl();
	private List<SelectItem> projetList;

	
	
	
	
	
	public List<SelectItem> getProjetList() {
		return projetList;
	}
	public void setProjetList(List<SelectItem> projetList) {
		this.projetList = projetList;
	}
	public OperateurBean() {
		
	}
	//################delete Op#################//
	public void deleteOperateur(ActionEvent e){
		log.info("delete Op");
		
		
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
		log.info("id : "+param.get("id"));
		log.info("ref : "+param.get("ref"));
		operateurService.delete(selectedOperateur.getId());
	    operateurList=operateurService.findAll();
	}
	
	 	 
	//########### init############//
	   @PostConstruct
	    public void init(){
		   selectedOperateur = new Operateur();
		   
		
	    	operateurList= operateurService.findAll();
	    
			System.out.println("id : "+ getParam("id"));
			System.out.println("operation : "+ getParam("operation"));
			
			if("edit".equalsIgnoreCase(getParam("operation"))){
			
		    	   Long id = null;
		    	   Operateur operateur =null;
		    	   try{
		    		   id=Long.valueOf(getParam("id"));
		    	   }catch(Exception e){
		    		   
		    	   }
		    	   if(id!=null){
		    		   operateur  = operateurService.findById(null);
		    		   
		    		   if(operateur!=null){

		    	   		   designation=operateur.getDesignation();
		    	   		   responsable_oper=operateur.getResponsable_oper();
		    	   		   
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
	
	 //########### add Operateur ############//
		
	    public void addOperateur(ActionEvent e){
	    	FacesContext fc = FacesContext.getCurrentInstance();
			Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
			log.info("id : "+param.get("id"));
			log.info("ref : "+param.get("ref"));
			
			Operateur operateur = null;
			System.out.println("addOp : "+operation+"-"+id);
			 
			if("edit".equalsIgnoreCase(operation)){
				
				operateur  = operateurService.findById(id);
				
				System.out.println("edit");
			}else{
				 operateur = new Operateur();
				System.out.println("new");
			}
		
	    operateur.setDesignation(designation);
		operateur.setUgcp(ugcp);
		operateur.setResponsable_oper(responsable_oper);
		operateur.setProjetId(projetId);
		
		operateurService.add(operateur);
		
			designation="";
			ugcp="";
			responsable_oper="";
		}

    
    public String getParam(String name){
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get(name);
	}

	public void onOperateurRowSelect(SelectEvent event) {
        setSelectedOperateur((Operateur) event.getObject());
    }
	   
	   public void onOperateurRowUnselect(UnselectEvent event) {
	        setSelectedOperateur(null);
	    }

	
	   public void update() {  
           this.operateurService.edit(this.selectedOperateur);
           
	   }
	
    
   
	
	
	public List<Operateur> getOperateurList() {
		return operateurList;
	}
	public void setOperateurList(List<Operateur> operateurList) {
		this.operateurList = operateurList;
	}
	
	
	
	
	public OperateurService getOperateurService() {
		return operateurService;
	}


	public void setOperateurService(OperateurService operateurService) {
		this.operateurService = operateurService;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDesignation() {
		return designation;
	}
	public void setResponsable_oper(String responsable_oper) {
		this.responsable_oper = responsable_oper;
	}
	public String getResponsable_oper() {
		return responsable_oper;
	}
	public void setUgcp(String ugcp) {
		this.ugcp = ugcp;
	}
	public String getUgcp() {
		return ugcp;
	}




	
	

	public void setSelectedOperateur(Operateur selectedOperateur) {
		this.selectedOperateur = selectedOperateur;
	}


	public Operateur getSelectedOperateur() {
		return selectedOperateur;
	}

	

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getOperation() {
		return operation;
	}


	
	public void setFilteredOperateurs(List<Operateur> filteredOperateurs) {
		this.filteredOperateurs = filteredOperateurs;
	}
	public List<Operateur> getFilteredOperateurs() {
		return filteredOperateurs;
	}
	public void setProjetId(Long projetId) {
		this.projetId = projetId;
	}
	public Long getProjetId() {
		return projetId;
	}
	public void setProjet(String projet) {
		this.projet = projet;
	}
	public String getProjet() {
		return projet;
	}



	
}
