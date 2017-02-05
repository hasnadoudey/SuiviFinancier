																				package tn.cni.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.util.Assert;

import tn.cni.commons.dao.GenericJpaDao;
import tn.cni.domain.UserEntity;
import tn.cni.ui.utils.HibernateUtil;

/**
 * Data access object JPA impl to work with User entity database operations.
 * @author hasna
 *
 */


public class UserJpaDao extends GenericJpaDao<UserEntity, Long> implements UserDao {
	
	public UserJpaDao() {
		super(UserEntity.class);
	}

    /**
     * Queries database for user name availability
     * 
     * @param userName
     * @return true if available
     */
	public boolean checkAvailable(String userName) {
		 Assert.notNull(userName);
		 Query query = getEntityManager()
         .createQuery("select count(*) from " + getPersistentClass().getSimpleName() 
                         + " u where u.userName = :userName").setParameter("userName", userName);
 
		 Long count = (Long) query.getSingleResult();
 
		
		return count < 1 ;
	}

	 /**
     * Queries user by username
     * 
     * @param userName
     * @return User entity
     */
	public UserEntity loadUserByUserName(String userName) {
		 Assert.notNull(userName);
         
         UserEntity user = null;
         
         Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
                         + " u where u.userName = :userName").setParameter("userName", userName);
         
         try {
                 user = (UserEntity) query.getSingleResult();
         } catch(NoResultException e) {
                 //do nothing
         }
		return user;
	}
	
	Session session = HibernateUtil.openSession();
	
    @SuppressWarnings("unchecked")
	public List<UserEntity> findAll() {
	return session.createQuery("select o from UserEntity o ").list();
	

}


 public void add(UserEntity userEntity) {
 	
	session.beginTransaction();
	session.save(userEntity);
	session.getTransaction().commit();
	

}


	public UserEntity edit(UserEntity userEntity) {
		session.beginTransaction();
		UserEntity p =(UserEntity)session.merge(userEntity);
		session.getTransaction().commit();
		return p;
	}


	public void delete(Long id) {
	session.beginTransaction();
	UserEntity p =findById(id);
    session.delete(p);
    session.getTransaction().commit();	
	}


	public UserEntity findById(Long id) {
	
    return (UserEntity) session.get(UserEntity.class,id);
	}


}
