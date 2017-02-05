package tn.cni.dao;

import java.util.List;

import org.hibernate.Session;

import tn.cni.domain.Role;
import tn.cni.ui.utils.HibernateUtil;

public class RoleJpaDao implements RoleDao {

	 Session session = HibernateUtil.openSession();
		
	    @SuppressWarnings("unchecked")
		public List<Role> findAll() {
		return session.createQuery("select o from Role o ").list();
		
	
	}

	
  public void add(Role role) {
  	
		session.beginTransaction();
		session.save(role);
		session.getTransaction().commit();
		

	}


		public Role edit(Role role) {
			session.beginTransaction();
			Role p =(Role)session.merge(role);
			session.getTransaction().commit();
			return p;
		}


		public void delete(Long id) {
		session.beginTransaction();
		Role p =findById(id);
	    session.delete(p);
	    session.getTransaction().commit();	
		}


		public Role findById(Long id) {
		
	    return (Role) session.get(Role.class,id);
		}

	
}
