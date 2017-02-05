package tn.cni.dao;

import java.util.List;

import org.hibernate.Session;

import tn.cni.domain.Facture;
import tn.cni.ui.utils.HibernateUtil;


public class FactureJpaDao implements FactureDao {
	
	 Session session = HibernateUtil.openSession();
		
	    @SuppressWarnings("unchecked")
		public List<Facture> findAll() {
		return session.createQuery("select o from Facture o").list();
		
	
	}

	
     public void add(Facture facture) {
     	
		session.beginTransaction();
		session.save(facture);
		session.getTransaction().commit();
		

	}


		public Facture edit(Facture facture) {
			session.beginTransaction();
			Facture p =(Facture)session.merge(facture);
			session.getTransaction().commit();
			return p;
		}


		public void delete(Long id) {
	    session.beginTransaction();
	    Facture p =findById(id);
	    session.delete(p);
	    session.getTransaction().commit();	
		}


		public Facture findById(Long id) {
		
	    return (Facture) session.get(Facture.class,id);
		}

	

	
	
		
	
	
}
