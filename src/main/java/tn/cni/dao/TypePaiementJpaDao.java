package tn.cni.dao;

import java.util.List;

import org.hibernate.Session;

import tn.cni.domain.TypePaiement;
import tn.cni.ui.utils.HibernateUtil;

public class TypePaiementJpaDao implements TypePaiementDao{
	
	
	 Session session = HibernateUtil.openSession();
		
	    @SuppressWarnings("unchecked")
		public List<TypePaiement> findAll() {
		return session.createQuery("select f from TypePaiement f").list();
		
	
	}

	
	    	public void add(TypePaiement typePaiement) {
  	
		session.beginTransaction();
		session.save(typePaiement);
		session.getTransaction().commit();
		

	}


		public TypePaiement edit(TypePaiement typePaiement) {
			session.beginTransaction();
			TypePaiement p =(TypePaiement)session.merge(typePaiement);
			session.getTransaction().commit();
			return p;
		}


		public void delete(Long id) {
		session.beginTransaction();
		TypePaiement p =findById(id);
	    session.delete(p);
	    session.getTransaction().commit();	
		}


		public TypePaiement findById(Long id) {
		
	    return (TypePaiement) session.get(TypePaiement.class,id);
		}


		

	

	
}
