package tn.cni.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;

import tn.cni.commons.domain.BaseEntity;

@Entity
@Table(name="account")
public class Account extends BaseEntity{

	 /**
	 * 
	 */
	private static final long serialVersionUID = -4642238209205656424L;
	
		private String username;
	    private String password;
	    private String firstName;
	    private String lastName;
	    private boolean enabled;
	    private Long roleId;





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





	



	public Account(String username, String password, String firstName,
				String lastName, boolean enabled, Long roleId) {
			super();
			this.username = username;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
			this.enabled = enabled;
			this.roleId = roleId;
		}





	public Account(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		
		}





	public Account() {
		super();
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
