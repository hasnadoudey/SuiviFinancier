package tn.cni.dao;

import java.util.List;

import org.hibernate.Session;

import tn.cni.domain.Fe;
import tn.cni.ui.utils.HibernateUtil;

public class FeJpaDao implements FeDao{
	
	
	 Session session = HibernateUtil.openSession();
		
	    @SuppressWarnings("unchecked")
		public List<Fe> findAll() {
		return session.createQuery("select f from Fe f").list();
		
	
	}

	
     public void add(Fe fe) {
     	
		session.beginTransaction();
		session.save(fe);
		session.getTransaction().commit();
		

	}


		public Fe edit(Fe fe) {
			session.beginTransaction();
			Fe p =(Fe)session.merge(fe);
			session.getTransaction().commit();
			return p;
		}


		public void delete(Long id) {
		session.beginTransaction();
	    Fe p =findById(id);
	    session.delete(p);
	    session.getTransaction().commit();	
		}


		public Fe findById(Long id) {
		
	    return (Fe) session.get(Fe.class,id);
		}

	

	
	
	

}
