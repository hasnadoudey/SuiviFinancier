package tn.cni.mbean;




import java.io.IOException;
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
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

import tn.cni.domain.Projet;
import tn.cni.domain.Secteur;
import tn.cni.domain.Stade;
import tn.cni.domain.Type;
import tn.cni.services.ProjetService;
import tn.cni.services.SecteurService;
import tn.cni.services.StadeService;
import tn.cni.services.TypeService;
import tn.cni.services.impl.ProjetServiceImpl;
import tn.cni.services.impl.SecteurServiceImpl;
import tn.cni.services.impl.StadeServiceImpl;
import tn.cni.services.impl.TypeServiceImpl;


@ManagedBean(name="project")
@ViewScoped
public class ProjetBean {
	
	
	public Logger log = Logger.getLogger(ProjetBean.class);
	
	StadeService stadeService = new StadeServiceImpl();
	SecteurService secteurService = new SecteurServiceImpl();
	ProjetService projetService = new ProjetServiceImpl();
	TypeService typeService = new TypeServiceImpl();
	
	
	 private List<Projet> filteredProjects;
	private List<SelectItem> typeList;
	private List<Projet> projetList;
	private List<SelectItem> stadeList;
	private List<SelectItem> secteurList;

	
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
	private String nature;
	
	
	
	private Long secteurId;
	private Long stadeId;
	
	
	
	private String id;
	private String operation;
	
	private ChartSeries projetData;
	private BarChartModel barModel;
	private PieChartModel pieModel;
	
	
	
	private Projet selectedProjet;

	


	public ProjetBean() {
		
	}
	//################add project#################//
	public void addProject(ActionEvent e){
		
	
	FacesContext fc = FacesContext.getCurrentInstance();
	Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
	log.info("id : "+param.get("id"));
	log.info("ref : "+param.get("ref"));
	
	Projet projet = null;
	System.out.println("addProject : ");
	 
	if("edit".equalsIgnoreCase(operation)){
		
		projet  = projetService.findById(new Long(id));
		
		System.out.println("edit");
	}else{
		projet = new Projet();
		System.out.println("new");
	
		
		
	
	}
	
		projet.setCout(cout);
		projet.setCout_actualise(cout_actualise);
		projet.setDate_act_cout(date_act_cout);
		projet.setDate_debut(date_debut);
		projet.setDate_fin(date_fin);
		projet.setDate_fin_actualise(date_fin_actualise);
		projet.setDescription(description);
		projet.setIntitule(intitule);
		projet.setMaitre_oeuvre(maitre_oeuvre);
		projet.setMaitre_ouvrage(maitre_ouvrage);
		projet.setObservations(observations);
		projet.setRef(ref);
		projet.setSecteurId(secteurId);
		projet.setStadeId(stadeId);
		
	  
	    projetService.add(projet);
	    
	   
		cout_actualise="";
		intitule="";
		maitre_oeuvre="";
		maitre_ouvrage="";
		ref="";
		secteurId=null;
		taux_rent_economique="";
		taux_rent_interne="";
		observations="";
		description="";
		date_act_cout=null;
		date_debut=null;
		date_fin=null;
		date_fin_actualise=null;
		stadeId=null;
	
	}
	
	
	//################create bar model#################//
	
	public StadeService getStadeService() {
		return stadeService;
	}
	public void setStadeService(StadeService stadeService) {
		this.stadeService = stadeService;
	}
	public SecteurService getSecteurService() {
		return secteurService;
	}
	public void setSecteurService(SecteurService secteurService) {
		this.secteurService = secteurService;
	}
	private BarChartModel initBarModel() {
     BarChartModel model = new BarChartModel();	
     
	projetData=new ChartSeries();
	projetData.setLabel("projets");
	for (Projet cData :projetList){
		projetData.set(cData.getRef(),cData.getCout());
	}
	model.addSeries(projetData);
	return model;
}
	//################create bar model#################//
	
	 private void createPieModel() {
	        pieModel = new PieChartModel();
	        for (Projet cData :projetList){
	    		pieModel.set(cData.getSecteurList(),cData.getCout());
	        }
	        pieModel.setTitle("Projet par Secteurs");
	        pieModel.setLegendPosition("w");
	    }
//################create bar model#################//
private void createBarModel(){
	barModel = initBarModel();
	
	barModel.setTitle("projets par côut");
	barModel.setLegendPosition("ne");
	
	Axis xAxis = barModel.getAxis(AxisType.X);
	xAxis.setLabel("secteur");
	
	Axis yAxis = barModel.getAxis(AxisType.Y);
	yAxis.setLabel("projet");
	yAxis.setMin(0);
	yAxis.setMax(1000);
	
}
	
	
	
	
	//################delete project#################//
	public void deleteProject(ActionEvent e){
		log.info("delete project");
		
		
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
		log.info("id : "+param.get("id"));
		log.info("ref : "+param.get("ref"));
		
		
		projetService.delete(selectedProjet.getId());
		projetList=projetService.findAll();
	}
	@PostConstruct
	public void init(){
		

		   selectedProjet = new Projet();
	//################Preparer type list#################//
		 typeList = new ArrayList<SelectItem>();
		 typeList.add(new SelectItem("","")) ;

		
		 List<Type> listServices = typeService.findAll();

       for(Type t:listServices){
       typeList.add(new SelectItem(t.getId(),t.getName()));
       
       
  
	}
    
//################Preparer secteur list#################//
      
      secteurList = new ArrayList<SelectItem>();
	  secteurList.add(new SelectItem("","")) ;

		
		 List<Secteur> secteurServices = secteurService.findAll();

	  for(Secteur s:secteurServices){
		  secteurList.add(new SelectItem(s.getId(),s.getDescription()));
      
	  }
       
 	//################Preparer stade list#################//
      
      stadeList = new ArrayList<SelectItem>();
	  stadeList.add(new SelectItem("","")) ;

		
		 List<Stade> stadeServices = stadeService.findAll();

	  for(Stade s:stadeServices){
		  stadeList.add(new SelectItem(s.getId(),s.getDescription()));
	  }
	  
	
     //################Preparer Projet list#################// 
       
       projetList = projetService.findAll();
       
       System.out.println("id: "+getParam("id"));
       System.out.println("operation: "+getParam("operation"));
       
		createBarModel();
		createPieModel();
       
       if("edit".equalsIgnoreCase(getParam("operation"))){
    	 
    	   Long id = Long.valueOf(getParam("id"));
   		   Projet p  = projetService.findById(id);
   		 ref=p.getRef();
   		 intitule=p.getIntitule();
   		 description=p.getDescription();
   		 maitre_ouvrage=p.getMaitre_ouvrage();
   		 maitre_oeuvre=p.getMaitre_oeuvre();
   		
   		 taux_rent_economique=p.getTaux_rent_economique();
   		 taux_rent_interne=p.getTaux_rent_interne();
   		 cout=p.getCout();
   		 cout_actualise=p.getCout_actualise();
   		 date_act_cout=p.getDate_act_cout();
   		 date_debut=p.getDate_debut();
   		 date_fin=p.getDate_fin();
   		 date_fin_actualise=p.getDate_fin_actualise();
   		 stadeId=p.getStadeId();
   		 secteurId=p.getSecteurId();
   		 observations=p.getObservations();
       }
	}
	
	public void update() {  
        this.projetService.edit(this.selectedProjet);
        
	   }
	
	public String getParam(String name){
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get(name);
	}

	public void onProjetRowSelect(SelectEvent event) {
        setSelectedProjet((Projet) event.getObject());
    }
	
	   public void onProjetRowUnselect(UnselectEvent event) {
	        setSelectedProjet(null);
	    }
	  
	 
		
	   public void onRowDblClckSelect(final SelectEvent event) throws IOException
	   {


	     FacesContext.getCurrentInstance().getExternalContext().redirect("menu5.jsf?id=" +selectedProjet.getId());


	   }
	   
	    
	public List<SelectItem> getTypeList() {
		return typeList;
	}
	

	public void setTypeList(List<SelectItem> typeList) {
		this.typeList = typeList;
	}

	

	public List<Projet> getProjetList() {
		return projetList;
	}

	
	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public ProjetService getProjetService() {
		return projetService;
	}

	public void setProjetService(ProjetService projetService) {
		this.projetService = projetService;
	}

	public TypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
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


	

	public void setProjetList(List<Projet> projetList) {
		this.projetList = projetList;
	}

	

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public String getObservations() {
		return observations;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	public List<SelectItem> getStadeList() {
		return stadeList;
	}

	public void setStadeList(List<SelectItem> stadeList) {
		this.stadeList = stadeList;
	}

	public List<SelectItem> getSecteurList() {
		return secteurList;
	}

	public void setSecteurList(List<SelectItem> secteurList) {
		this.secteurList = secteurList;
	}



	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}


	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	public void setSelectedProjet(Projet selectedProjet) {
		this.selectedProjet = selectedProjet;
	}
	public Projet getSelectedProjet() {
		return selectedProjet;
	}
	
	
	public Long getSecteurId() {
		return secteurId;
	}
	public void setSecteurId(Long secteurId) {
		this.secteurId = secteurId;
	}
	public Long getStadeId() {
		return stadeId;
	}
	public void setStadeId(Long stadeId) {
		this.stadeId = stadeId;
	}
	
	
	public ChartSeries getProjetData() {
		return projetData;
	}
	public BarChartModel getBarModel() {
		return barModel;
	}
	public PieChartModel getPieModel() {
		return pieModel;
	}
	public void setFilteredProjects(List<Projet> filteredProjects) {
		this.filteredProjects = filteredProjects;
	}
	public List<Projet> getFilteredProjects() {
		return filteredProjects;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	public String getNature() {
		return nature;
	}

}

		
		

