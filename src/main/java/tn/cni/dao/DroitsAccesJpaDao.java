package tn.cni.dao;

import java.util.List;

import org.hibernate.Session;


import tn.cni.domain.DroitsAcces;
import tn.cni.ui.utils.HibernateUtil;

public class DroitsAccesJpaDao implements DroitsAccesDao{
	
	Session session = HibernateUtil.openSession();
	
    @SuppressWarnings("unchecked")
	public List<DroitsAcces> findAll() {
	return session.createQuery("select d from DroitsAcces d").list();
	

}


 public void add(DroitsAcces droitsAcces) {
 	
	session.beginTransaction();
	session.save(droitsAcces);
	session.getTransaction().commit();
	

}


	public DroitsAcces edit(DroitsAcces droitsAcces) {
		session.beginTransaction();
		DroitsAcces p =(DroitsAcces)session.merge(droitsAcces);
		session.getTransaction().commit();
		return p;
	}




	



}
