package tn.cni.dao;

import java.util.List;

import org.hibernate.Session;


import tn.cni.domain.Responsable;
import tn.cni.ui.utils.HibernateUtil;

public class ResponsableJpaDao implements ResponsableDao {

	 Session session = HibernateUtil.openSession();
		
	    @SuppressWarnings("unchecked")
		public List<Responsable> findAll() {
		return session.createQuery("select f from Responsable f").list();
		
	
	}

	
  public void add(Responsable responsable) {
  	
		session.beginTransaction();
		session.save(responsable);
		session.getTransaction().commit();
		
	}

		public void delete(Integer id) {
		session.beginTransaction();
		Responsable p =findById(id);
	    session.delete(p);
	    session.getTransaction().commit();	
		}


		public Responsable findById(Integer id) {
		
	    return (Responsable) session.get(Responsable.class,id);
		}



		public Responsable edit(Responsable responsable) {
			session.beginTransaction();
			Responsable p =(Responsable)session.merge(responsable);
			session.getTransaction().commit();
			return p;
		}


		
		
	
	
}
