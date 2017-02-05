package tn.cni.dao;



import java.util.List;

import org.hibernate.Session;

import tn.cni.domain.Projet;
import tn.cni.ui.utils.HibernateUtil;




public class ProjetJpaDao implements ProjetDao {
	
	
	 Session session = HibernateUtil.openSession();
	
	    @SuppressWarnings("unchecked")
		public List<Projet> findAll() {
		return session.createQuery("select o from Projet o").list();
		
	
	}

	
        public void add(Projet projet) {
        	
		session.beginTransaction();
		session.save(projet);
		session.getTransaction().commit();
		

	}

    
		public Projet edit(Projet projet) {
			session.beginTransaction();
			Projet p =(Projet)session.merge(projet);
			session.getTransaction().commit();
			return p;
		}


		public void delete(Long id) {
		session.beginTransaction();
	    Projet p =findById(id);
	    session.delete(p);
	    session.getTransaction().commit();	
		}


		public Projet findById(Long id) {
		
	    return (Projet) session.get(Projet.class,id);
		}

	

	
	
	

	
}



	


