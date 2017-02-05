package tn.cni.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.cni.domain.Account;
import tn.cni.domain.AccountModel;
import tn.cni.services.AccountService;
import tn.cni.services.impl.AccountServiceImpl;
@SessionScoped
@ManagedBean(name="accountController")
public class AccountController {
	
	public Account account = new Account();
	private String errorMessage = "";
	private boolean remember = false;
	AccountService accountService = new AccountServiceImpl();
	private String id;
    private String operation;
    private String firstName;
    private String lastName;
    private boolean enabled;
    private Long roleId;
    private String username;
    private String password;
    
    

	public void verifyLogin(){
		Account acc = checkCookie();
		if (acc != null){
			AccountModel accountModel = new AccountModel();
			if (accountModel.login(acc.getUsername(), acc.getPassword())){
				this.account = acc;
				redirect("accountHome");
			}else{
				this.errorMessage="Account non valide";
				redirect("login");
			}
			
		
		}
		
		
		
		
		
	}
	public void logout(){
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)fc.getExternalContext().getRequest();
		HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
		for (Cookie ck : request.getCookies()){
			if(ck.getName().equalsIgnoreCase("username")){
				ck.setMaxAge(0);
				response.addCookie(ck);
			}
			if(ck.getName().equalsIgnoreCase("password")){
				ck.setMaxAge(0);
				response.addCookie(ck);
			}
			redirect("accountHome.xhtml");
		}
	}
	
	
	
	
	public void login(){
		
		AccountModel accountModel = new AccountModel();
		 FacesContext fc = FacesContext.getCurrentInstance();
		 HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
		 if(accountModel.login(this.account.getUsername(),this.account.getPassword())){
			 if(this.remember){
				 Cookie ckUsername = new Cookie("username", this.account.getUsername());
				 ckUsername.setMaxAge(3600);
				 response.addCookie(ckUsername);
				 
				 Cookie ckPassword = new Cookie("password", this.account.getPassword());
				 ckPassword.setMaxAge(3600);
				 response.addCookie(ckPassword);
			 }
			 redirect("accountHome.jsf");
		 }else{
			 this.errorMessage = "Account valide";
			 redirect("login.jsf");
		 }
	}
	
	private void redirect(String page){
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.getExternalContext().redirect(page);
		} catch (Exception e) {
			
		}
	}
	
	private Account checkCookie(){
		Account account = null;
		 FacesContext fc = FacesContext.getCurrentInstance();
		 HttpServletRequest request = (HttpServletRequest)fc.getExternalContext().getRequest();
		 String username="",password="";
		 Cookie[] cookies = request.getCookies();
		 if(cookies != null){
		        for(Cookie ck :cookies) {
		        	if(ck.getName().equalsIgnoreCase("username"))
		            username = ck.getValue();
		        	if(ck.getName().equalsIgnoreCase("password"))
		        		password = ck.getValue();
		        }
	}
	
	if(!username.isEmpty()&& !password.isEmpty())
		account = new Account(username, password);
	return account;
		        
		
		
		
	}
	
	
	//################add fe #################// 
	 public void addUser(ActionEvent e){
		
		
		
		
		
		Account account = null;
		System.out.println("adduser : "+operation+"-"+id);
		 
		if("edit".equalsIgnoreCase(operation)){
			
			account  = accountService.findById(new Long(id));
			
			System.out.println("edit");
		}else{
			account = new Account();
			System.out.println("new");
		}
		
		account.setFirstName(firstName);
		account.setLastName(lastName);
		account.setPassword(password);
		account.setUsername(username);
		account.setRoleId(roleId);
		account.setEnabled(enabled);
	
	
		accountService.add(account);
		
		
		
		firstName="";
		lastName="";
		username="";
		password="";
		roleId=null;
		
		
		
	 }
	

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}



	public String getErrorMessage() {
		return errorMessage;
	}



	public void setRemember(boolean remember) {
		this.remember = remember;
	}



	public boolean isRemember() {
		return remember;
	}
	public AccountService getAccountService() {
		return accountService;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
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
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
