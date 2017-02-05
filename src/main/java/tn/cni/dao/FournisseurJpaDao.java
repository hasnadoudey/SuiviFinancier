package tn.cni.dao;

import java.util.List;

import org.hibernate.Session;

import tn.cni.domain.Fe;
import tn.cni.domain.Fournisseur;
import tn.cni.ui.utils.HibernateUtil;

public class FournisseurJpaDao implements FournisseurDao{


	 Session session = HibernateUtil.openSession();
	
	    @SuppressWarnings("unchecked")
		public List<Fournisseur> findAll() {
		return session.createQuery("select o from Fournisseur o").list();
		
	
	}

	
       public void add(Fournisseur fournisseur) {
       	
		session.beginTransaction();
		session.save(fournisseur);
		session.getTransaction().commit();
		

	}


		public Fournisseur edit(Fournisseur fournisseur) {
			session.beginTransaction();
			Fournisseur f =(Fournisseur)session.merge(fournisseur);
			session.getTransaction().commit();
			return f;
		}
	
		public void delete(Long id) {
		session.beginTransaction();
	    Fournisseur f =findById(id);
	    session.delete(f);
	    session.getTransaction().commit();	
		}


		public Fournisseur findById(Long id) {
		
	    return (Fournisseur) session.get(Fournisseur.class,id);
		}

	

	
}
