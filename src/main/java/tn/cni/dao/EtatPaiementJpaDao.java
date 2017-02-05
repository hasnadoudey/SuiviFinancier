package tn.cni.dao;

import java.util.List;

import org.hibernate.Session;

import tn.cni.domain.EtatPaiement;
import tn.cni.ui.utils.HibernateUtil;

public class EtatPaiementJpaDao implements EtatPaiementDao {
	
	
	Session session = HibernateUtil.openSession();
		
	    @SuppressWarnings("unchecked")
		public List<EtatPaiement> findAll() {
		return session.createQuery("select f from EtatPaiement f").list();
		
	
	}

	
	    	public void add(EtatPaiement etatPaiement) {
	
		session.beginTransaction();
		session.save(etatPaiement);
		session.getTransaction().commit();
		

	}


		public EtatPaiement edit(EtatPaiement etatPaiement) {
			session.beginTransaction();
			EtatPaiement p =(EtatPaiement)session.merge(etatPaiement);
			session.getTransaction().commit();
			return p;
		}


		public void delete(Long id) {
		session.beginTransaction();
		EtatPaiement p =findById(id);
	    session.delete(p);
	    session.getTransaction().commit();	
		}


		public EtatPaiement findById(Long id) {
		
	    return (EtatPaiement) session.get(EtatPaiement.class,id);
		} 


		
}
