package tn.cni.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.component.inputtext.InputText;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import tn.cni.dao.UserDao;
import tn.cni.dao.UserJpaDao;
import tn.cni.domain.UserEntity;
import tn.cni.services.UserService;


/**
 * 
 * @author hasna
 *
 */
public class UserServiceImpl implements UserService, UserDetailsService {

	private UserDao userDao ;
	
	
	/**
	 * Construct UserDetails instance required by spring security
	 */
	
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		UserEntity user = userDao.loadUserByUserName(userName);

		if(user == null){
			throw new UsernameNotFoundException(String.format(getMessageBundle().getString("BadCredentials"), userName));
			
		}

		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		User userDetails = new User(user.getUserName(), user.getPassword(), authorities);
		
		
		return userDetails  ;
	}
	
	public List<String> getRoles(Integer role) {
		 
        List<String> roles = new ArrayList<String>();
 
        if (role.intValue() == 1) {
            roles.add("ROLE_ADMIN");
        } else if (role.intValue() == 2) {
            roles.add("ROLE_CHEFPROJET");
        } else if (role.intValue() == 3) {
            roles.add("ROLE_RESPONSABLEMARCHE");
        } else if (role.intValue() == 4) {
            roles.add("ROLE_RESPONSABLEFINANCIER");
        }
        return roles;
    }
	
	  public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
	        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	         
	        for (String role : roles) {
	            authorities.add(new SimpleGrantedAuthority(role));
	        }
	        return authorities;
	    }
	 /**
     * Retrives full User record from database by user name
     * 
     * @param userName
     * @return user Entity
     */
	public UserEntity loadUserEntityByUsername(String userName) {
		
		return userDao.loadUserByUserName(userName);
	}
	
	
	public boolean checkAvailable(AjaxBehaviorEvent event) {
	
		InputText inputText = (InputText)event.getSource();
		String value = (String) inputText.getValue();
		boolean available = userDao.checkAvailable(value);
		
		
		if (!available){
			
			FacesMessage message = constructErrorMessage(null, String.format(getMessageBundle().getString("userExistsMsg"), value));
			getFacesContext().addMessage(event.getComponent().getClientId(), message);
		}else{
			
			FacesMessage message = constructInfoMessage(null, String.format(getMessageBundle().getString("userAvailableMsg"), value));
			getFacesContext().addMessage(event.getComponent().getClientId(), message);
		}
		
		return available;
		
		
	}
   
	public boolean createUser(UserEntity user) {
		
		if (!userDao.checkAvailable(user.getUserName())){
			
			FacesMessage message = constructErrorMessage(String.format("User Name '%s' is not available",user.getUserName()),null);
			getFacesContext().addMessage(null, message);
			
			return false;
		}
		
		try{
		
		
		userDao.save(user);
		}catch (Exception e){
			
			FacesMessage message = constructFatalMessage(e.getMessage(), null);
			getFacesContext().addMessage(null, message);
			return false;
		}
		return true;
	}




	   protected FacesMessage constructErrorMessage(String message, String detail){
	    	
	    	return new FacesMessage(FacesMessage.SEVERITY_ERROR, message, detail);
	    }
	    
	    protected FacesMessage constructInfoMessage(String message, String detail){
	    	
	    	return new FacesMessage(FacesMessage.SEVERITY_INFO, message, detail);
	    }
	    
	    protected FacesMessage constructFatalMessage(String message, String detail){
	    	
	    	return new FacesMessage(FacesMessage.SEVERITY_FATAL, message, detail);
	    }

	    protected FacesContext getFacesContext(){
	    	return FacesContext.getCurrentInstance();
	    }
	    
	  protected ResourceBundle getMessageBundle(){
		  return ResourceBundle.getBundle("message-labels");
	  }
	    
	    
	    
	public UserDao getUserDao() {
			return userDao;
		}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	UserDao dao = new UserJpaDao();
	
	
	
 public List<UserEntity> findAll() {
		
		return dao.findAll();
	}

	public void add(UserEntity userEntity) {
		dao.add(userEntity);
		
	}

	public UserEntity edit(UserEntity userEntity) {
		
		return dao.edit(userEntity);
	}

	public void delete(Long id) {
		dao.delete(id);	
	}

	public UserEntity findById(Long id) {
		
		return dao.findById(id);
	}

	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}



	
}

