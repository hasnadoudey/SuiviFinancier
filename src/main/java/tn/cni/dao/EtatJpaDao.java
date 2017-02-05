package tn.cni.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import tn.cni.domain.Etat;
import tn.cni.ui.utils.HibernateUtil;

public class EtatJpaDao implements EtatDao{
	 Session session = HibernateUtil.openSession();
		
	    @SuppressWarnings("unchecked")
		public List<Etat> findAll() {
		return session.createQuery("select e from Etat e ").list();
		
	
	}

	
  public void add(Etat etat) {
  	
		session.beginTransaction();
		session.save(etat);
		session.getTransaction().commit();
		

	}

	
		public Etat edit(Etat etat) {
			session.beginTransaction();
			Etat e =(Etat)session.merge(etat);
			session.getTransaction().commit();
			return e;
		}
	

		public void delete(Integer id) {
		session.beginTransaction();
	    Etat e =findById(id);
	    session.delete(e);
	    session.getTransaction().commit();	
		}


		public Etat findById(Integer id) {
		
	    return (Etat) session.get(Etat.class,id);
		}

		

			
		


	
		
}
