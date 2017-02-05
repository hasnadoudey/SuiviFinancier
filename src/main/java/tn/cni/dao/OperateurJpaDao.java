package tn.cni.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import tn.cni.domain.Operateur;
import tn.cni.domain.Responsable;
import tn.cni.ui.utils.HibernateUtil;


public class OperateurJpaDao  implements OperateurDao {

	
	 Session session = HibernateUtil.openSession();
		
	    @SuppressWarnings("unchecked")
		public List<Operateur> findAll() {
		return session.createQuery("select o from Operateur o").list();
		
	
	}

	
     public void add(Operateur operateur) {
     	
		session.beginTransaction();
		session.save(operateur);
		session.getTransaction().commit();
		

	}


		public Operateur edit(Operateur operateur) {
			session.beginTransaction();
			Operateur p =(Operateur)session.merge(operateur);
			session.getTransaction().commit();
			return p;
		}


		public void delete(Integer id) {
	    session.beginTransaction();
	    
	    Operateur o = findById(id);
	    session.delete(o);
	    session.getTransaction().commit();	
		}
		
		


		public Operateur findById(Integer id) {	
	    return (Operateur)session.get(Operateur.class,id);
		}

		
			
		  
	
	
	



}
