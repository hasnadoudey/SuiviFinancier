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

import tn.cni.domain.Role;
import tn.cni.domain.UserEntity;
import tn.cni.services.RoleService;
import tn.cni.services.UserService;
import tn.cni.services.impl.RoleServiceImpl;
import tn.cni.services.impl.UserServiceImpl;

@ManagedBean(name="userBean")
@ViewScoped
public class UtilisateurBean {
	
	public Logger log = Logger.getLogger(UtilisateurBean.class);
	
	public UserEntity user = new UserEntity();
	
	private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private boolean enabled;
    private Long roleId;
    
    public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	private List<UserEntity> filteredUsers;
    
    
    private String id;
	private String operation;
    
	private UserEntity selectedUser;
    
	RoleService roleService = new RoleServiceImpl();
	private List<UserEntity> userList;
	private List<SelectItem> roleList;
	
	UserService userService = new UserServiceImpl();
    public UtilisateurBean() {
		
	}

	//################delete user#################//
	public void deleteUser(ActionEvent e){
		log.info("delete User");
		
		
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
		log.info("id : "+param.get("id"));
		log.info("ref : "+param.get("ref"));
		
		
		userService.delete(selectedUser.getId());
	    userList=userService.findAll();
	}
	@PostConstruct
	public void init(){
		
		 selectedUser = new UserEntity();
	//################Preparer type list#################//
	 	userList= userService.findAll();

	 	//################Preparer type list#################//
	 	 roleList = new ArrayList<SelectItem>();
	 	 roleList.add(new SelectItem("","")) ;


	 	 List<Role> listServicestype = roleService.findAll();

	 	for(Role r:listServicestype){
	 	roleList.add(new SelectItem(r.getId(),r.getRole()));
	 	}

	}
	
	//################add fe #################// 
	 public void addUser(ActionEvent e){
		
		
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
		log.info("id : "+param.get("id"));
		log.info("ref : "+param.get("ref"));
		
		UserEntity userEntity = null;
		System.out.println("adduser : "+operation+"-"+id);
		 
		if("edit".equalsIgnoreCase(operation)){
			
			userEntity  = userService.findById(new Long(id));
			
			System.out.println("edit");
		}else{
			userEntity = new UserEntity();
			System.out.println("new");
		}
		
		userEntity.setFirstName(firstName);
		userEntity.setLastName(lastName);
		userEntity.setPassword(password);
		
		userEntity.setUserName(userName);
		userService.add(userEntity);
		
		firstName="";
		lastName="";
		password="";
		
		userName="";
		
		
	 }

	

	public String getParam(String name){
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get(name);
	}

	public void onUserRowSelect(SelectEvent event) {
		setSelectedUser((UserEntity) event.getObject());
	}

	public void onUserRowUnselect(UnselectEvent event) {
		setSelectedUser(null);
	}
    
	public void update() {  
        this.userService.edit(this.selectedUser);
        
	   }
    
    
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setUserList(List<UserEntity> userList) {
		this.userList = userList;
	}

	public List<UserEntity> getUserList() {
		return userList;
	}










	public void setRoleList(List<SelectItem> roleList) {
		this.roleList = roleList;
	}










	public List<SelectItem> getRoleList() {
		return roleList;
	}










	public void setId(String id) {
		this.id = id;
	}










	public String getId() {
		return id;
	}










	public void setOperation(String operation) {
		this.operation = operation;
	}










	public String getOperation() {
		return operation;
	}










	public void setSelectedUser(UserEntity selectedUser) {
		this.selectedUser = selectedUser;
	}










	public UserEntity getSelectedUser() {
		return selectedUser;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setFilteredUsers(List<UserEntity> filteredUsers) {
		this.filteredUsers = filteredUsers;
	}

	public List<UserEntity> getFilteredUsers() {
		return filteredUsers;
	}
    
    
}
