package tn.cni.dao;

import java.util.List;

import org.hibernate.Session;

import tn.cni.domain.Country;
import tn.cni.ui.utils.HibernateUtil;

public class CountryJpaDao implements CountryDao{

	 Session session = HibernateUtil.openSession();
		
	    @SuppressWarnings("unchecked")
		public List<Country> findAll() {
		return session.createQuery("select c from Country c").list();
		
	
	}
}
