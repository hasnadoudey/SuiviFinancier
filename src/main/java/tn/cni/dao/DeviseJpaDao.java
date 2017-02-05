package tn.cni.dao;

import java.util.List;

import org.hibernate.Session;

import tn.cni.domain.Devise;
import tn.cni.ui.utils.HibernateUtil;

public class DeviseJpaDao implements DeviseDao {

	 Session session = HibernateUtil.openSession();
		
	    @SuppressWarnings("unchecked")
		public List<Devise>findAll() {
		return session.createQuery("select d from Devise d").list();
		
	
	}

}
