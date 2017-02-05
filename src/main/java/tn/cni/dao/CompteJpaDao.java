package tn.cni.dao;

import java.util.List;

import org.hibernate.Session;

import tn.cni.domain.Compte;
import tn.cni.ui.utils.HibernateUtil;

public class CompteJpaDao implements CompteDao{

	
	Session session = HibernateUtil.openSession();
	
    @SuppressWarnings("unchecked")
	public List<Compte> findAll() {
	return session.createQuery("select f from Compte f").list();
	

}


 public void add(Compte compte) {
 	
	session.beginTransaction();
	session.save(compte);
	session.getTransaction().commit();
	

}


	public Compte edit(Compte compte) {
		session.beginTransaction();
		Compte p =(Compte)session.merge(compte);
		session.getTransaction().commit();
		return p;
	}


	public void delete(Long id) {
	session.beginTransaction();
	Compte p =findById(id);
    session.delete(p);
    session.getTransaction().commit();	
	}


	public Compte findById(Long id) {
	
    return (Compte) session.get(Compte.class,id);
	}

}
