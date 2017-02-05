package tn.cni.domain;



import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name="roles")
public class Role implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6495957000643289842L;

	@Id
    @GeneratedValue
    private Integer id;
     
    private String role;

	 @OneToMany
    private Set<UserEntity> userRoles;
    
	public void setRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setUserRoles(Set<UserEntity> userRoles) {
		this.userRoles = userRoles;
	}

	public Set<UserEntity> getUserRoles() {
		return userRoles;
	}
     
}
