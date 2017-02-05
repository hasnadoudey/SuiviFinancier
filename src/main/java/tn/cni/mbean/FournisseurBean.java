package tn.cni.mbean;

import java.io.Serializable;
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

import tn.cni.domain.Country;
import tn.cni.domain.Fournisseur;
import tn.cni.domain.Operateur;
import tn.cni.domain.Projet;
import tn.cni.domain.Type;
import tn.cni.services.CountryService;
import tn.cni.services.FournisseurService;
import tn.cni.services.ProjetService;
import tn.cni.services.TypeService;
import tn.cni.services.impl.CountryServiceImpl;
import tn.cni.services.impl.FournisseurServiceImpl;
import tn.cni.services.impl.ProjetServiceImpl;
import tn.cni.services.impl.TypeServiceImpl;

@ManagedBean(name="fournisseurBean")
@ViewScoped
public class FournisseurBean implements Serializable{

	public Logger log = Logger.getLogger(FournisseurBean.class);
	
	private static final long serialVersionUID = 616551026259273422L;
	
	private String compte;
	private String matricule;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private String fax;
	private String nationalite;
	private String mail;
	private String pays; 
	private String fournisseur_Rep;
	private String taux;
	private String country;
	private Integer idOperateur;
	private Operateur operateur;
    private Long typeId;
    private Long countryId;
	private String operation;
	private String id;
	private Fournisseur selectedFournisseur;
	
	private List<Fournisseur> filteredFournisseurs;
	
	private List<Fournisseur> selectedFournisseurs;
	private List<SelectItem> countryList;
	private List<SelectItem> typeList;
	private List<Fournisseur> fournisseurList;
	
	TypeService typeService = new TypeServiceImpl();
	CountryService countryService = new CountryServiceImpl();
	FournisseurService fournisseurService = new FournisseurServiceImpl();
	private Long projetId;
	ProjetService projetService = new ProjetServiceImpl();
	private List<SelectItem> projetList;
	
	
	
	
	
public List<SelectItem> getProjetList() {
		return projetList;
	}

	public void setProjetList(List<SelectItem> projetList) {
		this.projetList = projetList;
	}

public FournisseurBean() {
		
	}
	
@PostConstruct
public void init(){
	selectedFournisseur = new Fournisseur();
	
	
 countryList = new ArrayList<SelectItem>();
 countryList.add(new SelectItem("","")) ;


 List<Country> listServices = countryService.findAll();

for(Country c:listServices){
  countryList.add(new SelectItem(c.getId(),c.getDescription()));
}

//################Preparer type list#################//
 typeList = new ArrayList<SelectItem>();
 typeList.add(new SelectItem("","")) ;


 List<Type> listServicestype = typeService.findAll();

for(Type t:listServicestype){
typeList.add(new SelectItem(t.getId(),t.getName()));
}

//################op#################// 
projetList = new ArrayList<SelectItem>();
projetList.add(new SelectItem("","")) ;


 List<Projet> projetServices = projetService.findAll();

for(Projet o:projetServices){
  projetList.add(new SelectItem(o.getId(),o.getRef()));

}
//################Preparer Fournisseur list#################// 

   fournisseurList = fournisseurService.findAll();
}
	
//################Add Fournisseur#################//
 public void addFournisseur(ActionEvent e){
	 
	 
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
		log.info("id : "+param.get("id"));
		log.info("ref : "+param.get("ref"));
		
		 Fournisseur fournisseur = null;
			System.out.println("addFournisseur : " +operation+"-"+ id);
		 
			if("edit".equalsIgnoreCase(operation)){
				
				fournisseur  = fournisseurService.findById(new Long(id));
				
				System.out.println("edit");
				
			}else{
				
				fournisseur = new Fournisseur();
				System.out.println("new");
			
				}
			fournisseur.setAdresse(adresse);
			fournisseur.setCountryId(countryId);
			fournisseur.setFax(fax);
			fournisseur.setNationalite(nationalite);
			fournisseur.setMatricule(matricule);
			fournisseur.setTelephone(telephone);
			fournisseur.setMail(mail);
			fournisseur.setTypeId(typeId);
			fournisseur.setNom(nom);
			fournisseur.setProjetId(projetId);
			
			
			fournisseurService.add(fournisseur);
		
			adresse="";
			country="";
			fax="";
			nationalite="";
			matricule="";
			telephone="";
			mail="";
			typeId=null;
			nom="";
			taux="";
			operation="";
	
	 }
		//################delete Fournisseur#################//
		public void deleteFournisseur(ActionEvent e){
			
			FacesContext fc = FacesContext.getCurrentInstance();
			Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
			log.info("id : "+param.get("id"));
			
			
			fournisseurService.delete(selectedFournisseur.getId());
			fournisseurList=fournisseurService.findAll();
		}
		
	
		 
	  //################Select#################//  
	 
	 	
		 public String getParam(String name){
				FacesContext fc = FacesContext.getCurrentInstance();
				Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
				return params.get(name);
			}

			public void onFournisseurRowSelect(SelectEvent event) {
		        setSelectedFournisseur((Fournisseur) event.getObject());
		    }
			   
			   public void onFournisseurRowUnselect(UnselectEvent event) {
			        setSelectedFournisseur(null);
			    }
	 
	 
	 
			   public List<String> completeText(String query) {
			        List<String> results = new ArrayList<String>();
			        for(int i = 0; i < 10; i++) {
			            results.add(query + i);
			        }
			        return results;
			   }
	 
	 
	 
			   public void update() {  
		           this.fournisseurService.edit(this.selectedFournisseur);
		           
			   }
	 
	 
	 
	 
	public String getMatricule() {
		return matricule;
	}



	public void setMatricule(String matricule) {
		this.matricule = matricule;
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



	public String getAdresse() {
		return adresse;
	}



	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public String getTelephone() {
		return telephone;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public String getFax() {
		return fax;
	}



	public void setFax(String fax) {
		this.fax = fax;
	}



	public String getNationalite() {
		return nationalite;
	}



	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public String getPays() {
		return pays;
	}



	public void setPays(String pays) {
		this.pays = pays;
	}



	public String getFournisseur_Rep() {
		return fournisseur_Rep;
	}



	public void setFournisseur_Rep(String fournisseur_Rep) {
		this.fournisseur_Rep = fournisseur_Rep;
	}



	public String getTaux() {
		return taux;
	}



	public void setTaux(String taux) {
		this.taux = taux;
	}



	



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public Integer getIdOperateur() {
		return idOperateur;
	}



	public void setIdOperateur(Integer idOperateur) {
		this.idOperateur = idOperateur;
	}



	public void setOperateur(Operateur operateur) {
		this.operateur = operateur;
	}

	public Operateur getOperateur() {
		return operateur;
	}
	public List<SelectItem> getCountryList() {
		return countryList;
	}
	public void setCountryList(List<SelectItem> countryList) {
		this.countryList = countryList;
	}


	public List<SelectItem> getTypeList() {
		return typeList;
	}
	public void setTypeList(List<SelectItem> typeList) {
		this.typeList = typeList;
	}


	public void setFournisseurList(List<Fournisseur> fournisseurList) {
		this.fournisseurList = fournisseurList;
	}


	public List<Fournisseur> getFournisseurList() {
		return fournisseurList;
	}






	public void setSelectedFournisseurs(List<Fournisseur> selectedFournisseurs) {
		this.selectedFournisseurs = selectedFournisseurs;
	}



	public List<Fournisseur> getSelectedFournisseurs() {
		return selectedFournisseurs;
	}



	public void setOperation(String operation) {
		this.operation = operation;
	}



	public String getOperation() {
		return operation;
	}








	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public TypeService getTypeService() {
		return typeService;
	}



	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}



	public CountryService getCountryService() {
		return countryService;
	}



	public void setCountryService(CountryService countryService) {
		this.countryService = countryService;
	}



	public FournisseurService getFournisseurService() {
		return fournisseurService;
	}



	public void setFournisseurService(FournisseurService fournisseurService) {
		this.fournisseurService = fournisseurService;
	}






	public void setSelectedFournisseur(Fournisseur selectedFournisseur) {
		this.selectedFournisseur = selectedFournisseur;
	}



	public Fournisseur getSelectedFournisseur() {
		return selectedFournisseur;
	}




	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}



	public Long getTypeId() {
		return typeId;
	}

	public void setCompte(String compte) {
		this.compte = compte;
	}

	public String getCompte() {
		return compte;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setFilteredFournisseurs(List<Fournisseur> filteredFournisseurs) {
		this.filteredFournisseurs = filteredFournisseurs;
	}

	public List<Fournisseur> getFilteredFournisseurs() {
		return filteredFournisseurs;
	}

	public void setProjetId(Long projetId) {
		this.projetId = projetId;
	}

	public Long getProjetId() {
		return projetId;
	}






	
	
}
