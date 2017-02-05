package tn.cni.dao;

import java.util.List;

import tn.cni.commons.dao.GenericDao;
import tn.cni.domain.UserEntity;


/**
 *  Data access object interface to work with User entity database operations.
 * @author hasna
 *
 */

public interface UserDao extends GenericDao<UserEntity, Long> {
	
	public void add(UserEntity userEntity);

	public UserEntity edit(UserEntity userEntity);

	public void delete(Long id);

	public List<UserEntity> findAll();
	
	public UserEntity findById(Long id);
	/**
     * Queries database for user name availability
     * 
     * @param userName
     * @return true if available
     */
    boolean checkAvailable(String userName);
    /**
     * Queries user by username
     * 
     * @param userName
     * @return User 
     */
    UserEntity loadUserByUserName(String userName);

}
