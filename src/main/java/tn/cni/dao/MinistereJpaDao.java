package tn.cni.dao;

import java.util.List;

import org.hibernate.Session;

import tn.cni.domain.Ministere;
import tn.cni.ui.utils.HibernateUtil;

public class MinistereJpaDao implements MinistereDao{
	
	 Session session = HibernateUtil.openSession();
		
	    @SuppressWarnings("unchecked")
		public List<Ministere> findAll() {
		return session.createQuery("select o from Ministere o ").list();
		
	
	}

	
  public void add(Ministere ministere) {
  	
		session.beginTransaction();
		session.save(ministere);
		session.getTransaction().commit();
		

	}


		public Ministere edit(Ministere ministere) {
			session.beginTransaction();
			Ministere p =(Ministere)session.merge(ministere);
			session.getTransaction().commit();
			return p;
		}


		public void delete(Long id) {
		session.beginTransaction();
		Ministere p =findById(id);
	    session.delete(p);
	    session.getTransaction().commit();	
		}


		public Ministere findById(Long id) {
		
	    return (Ministere) session.get(Ministere.class,id);
		}

	

}
