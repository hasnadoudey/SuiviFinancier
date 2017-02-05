package tn.cni.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;

import tn.cni.commons.domain.BaseEntity;

/**
 * 
 * @author hasna
 *
 */

@Entity
@Table(name="user")
public class UserEntity extends BaseEntity {
	

	private static final long serialVersionUID = 1L;
	
	

	private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private boolean enabled;
    
 
   
  
    
    
    
    public boolean isEnabled() {
		return enabled;
	}



	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	
	



	public UserEntity(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}





	public UserEntity() {
		super();
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
		
		PasswordEncoder crypto = new Md5PasswordEncoder();
		this.password = crypto.encodePassword(password, null);
	}



	


	
    
}
