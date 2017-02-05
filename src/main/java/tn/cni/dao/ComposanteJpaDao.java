package tn.cni.dao;

import java.util.List;

import org.hibernate.Session;

import tn.cni.domain.Composante;
import tn.cni.ui.utils.HibernateUtil;

public class ComposanteJpaDao implements ComposanteDao{
	
	
	 Session session = HibernateUtil.openSession();
		
	    @SuppressWarnings("unchecked")
		public List<Composante> findAll() {
		return session.createQuery("select o from Composante o ").list();
		
	
	}

	
     public void add(Composante composante) {
     	
		session.beginTransaction();
		session.save(composante);
		session.getTransaction().commit();
		

	}


		public Composante edit(Composante composante) {
			session.beginTransaction();
			Composante p =(Composante)session.merge(composante);
			session.getTransaction().commit();
			return p;
		}


		public void delete(Long id) {
		session.beginTransaction();
	    Composante p =findById(id);
	    session.delete(p);
	    session.getTransaction().commit();	
		}


		public Composante findById(Long id) {
		
	    return (Composante) session.get(Composante.class,id);
		}

	

	
	
	

}
