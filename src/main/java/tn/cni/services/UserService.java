package tn.cni.services;

import java.util.List;

import javax.faces.event.AjaxBehaviorEvent;

import tn.cni.domain.UserEntity;

/**
 * 
 * @author hasna
 *
 */


public interface UserService {
	
	 /**
     * Create user - persist to database
     * 
     * @param user
     * @return true if success
     */
	
	 boolean createUser(UserEntity user);
	 /**
	     * Check user name availabilty.UI ajax use
	     * 
	     * @param ajax event
	     * @return 
	     */
	 boolean checkAvailable(AjaxBehaviorEvent event);
	 /**
	     * Retrives full User record from database by user name
	     * 
	     * @param userName
	     * @return user Entity
	     */
	 UserEntity loadUserEntityByUsername(String userName);
	 
	    public void add(UserEntity userEntity);

		public UserEntity edit(UserEntity userEntity);

		public void delete(Long id);

		public List<UserEntity> findAll();
		
		public UserEntity findById(Long id);
}
