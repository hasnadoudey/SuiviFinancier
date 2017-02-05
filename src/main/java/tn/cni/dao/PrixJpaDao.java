package tn.cni.dao;

import java.util.List;

import org.hibernate.Session;

import tn.cni.domain.Prix;
import tn.cni.ui.utils.HibernateUtil;

public class PrixJpaDao implements PrixDao{

	 Session session = HibernateUtil.openSession();
		
	    @SuppressWarnings("unchecked")
		public List<Prix>findAll() {
		return session.createQuery("select p from Prix p").list();
		
	
	}
	
}
